package cn.zkw.controller;

import cn.zkw.service.ArticleService;
import cn.zkw.service.UserService;
import cn.zkw.util.action.AbstractAction;
import cn.zkw.util.encrypt.MyPasswordEncrypt;
import cn.zkw.vo.User;
import net.sf.json.JSON;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

@Controller
public class UserController extends AbstractAction {
    Logger logger = Logger.getLogger("UserController");
    @Resource
    UserService service;

    @Autowired
    ArticleService articleService;

    @RequestMapping(value = "/updateBirthday",method = RequestMethod.PUT,produces = "application/json;charset=UTF-8")
    public @ResponseBody Object updateBirthdayById(Date user_birthday){
        User user = new User();
        user.setUser_name(String.valueOf(SecurityUtils.getSubject().getPrincipal()));
        user.setUser_birthday(user_birthday);
        JSONObject jsonObject = new JSONObject();
        if(service.updateBirthdayById(user)){
            jsonObject.put("code",200);
        }else{
            jsonObject.put("code",304);
        }
        return jsonObject;
    }

    @RequestMapping(value = "/updateSex", method = RequestMethod.PUT, produces = "application/json;charset=UTF-8")
    public @ResponseBody Object updateUserSexById(String user_sex){
        Integer sex = Integer.parseInt(user_sex);
        User user = new User();
        user.setUser_sex(sex);
        user.setUser_name(String.valueOf(SecurityUtils.getSubject().getPrincipal()));
        JSONObject jsonObject = new JSONObject();
        if(service.updateSexById(user)){
            jsonObject.put("code",200);
        }else{
            jsonObject.put("code",201);
        }
        return jsonObject;
    }

    /**
     * 根据当前登陆的账号更新用户名
     * @param user_nickname
     * @return
     */
    @RequestMapping(value = "/updateUserName", method = RequestMethod.PUT, produces = "application/json;charset=UTF-8")
    public @ResponseBody Object updateUserName(String user_nickname){
        logger.info("updateUserName-user_name:"+SecurityUtils.getSubject().getPrincipal());
        User user = new User();//new一个user对象传给mybatis
        logger.info("updateUserName-user_nickname:"+user_nickname);
        user.setUser_nickname(user_nickname); //传入要修改的昵称
        user.setUser_name((String)SecurityUtils.getSubject().getPrincipal());  //传入要修改的账号
        JSONObject jsonObject = new JSONObject();//接口数据的返回
        if(service.updateNikeName(user)){
            jsonObject.put("code",200);
        }else{
            jsonObject.put("code",201);
        }

        return jsonObject;
    }

    /**
     * 检测同名账号接口
     * @param user_name
     * @return
     */
    @RequestMapping(value = "/registGetUser", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public @ResponseBody
    Object registGetUser(String user_name) {
        JSONObject jsonObject = new JSONObject();
        if (service.getUserByName(user_name) != null) {
            jsonObject.put("code", 201);
            jsonObject.put("msg", "账号已存在");
        } else {
            jsonObject.put("code", 200);
            jsonObject.put("msg", "可以使用的账号");
        }
        return jsonObject;
    }

    /**
     * 注册账号
     * @param user
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public @ResponseBody
    Object addUser(User user, HttpServletRequest request) throws Exception {
        System.out.println(request.getRemoteAddr());
        System.out.println(user);
        ModelAndView modelAndView = new ModelAndView("front/tip");
        String password = MyPasswordEncrypt.encryptPassword(user.getUser_password());
        user.setUser_password(password);
        user.setUser_lock(0); //用户默认不锁定
        user.setUser_level(1); //用户默认等级为一级
        user.setUser_ip(request.getRemoteAddr());  //ip
        user.setUser_photo("nophoto.jpg");  //头像名称
        user.setUser_registration_time(new Date()); //注册时间
        user.setUser_rights(1);  //默认权限为一，，表示不是会员

        if (service.getUserByName(user.getUser_name()) == null) {
            if (service.addUser(user)) {
                modelAndView.addObject("msg", "注册成功！");
                modelAndView.addObject("url", "index");
                return modelAndView;
            } else {
                modelAndView.addObject("msg", "出现异常,注册失败，请联系管理员！");
                modelAndView.addObject("url", "userAdd");
            }
        } else {
            modelAndView.addObject("msg", "注册失败，账号已存在！");
            modelAndView.addObject("url", "userAdd");
        }
        return modelAndView;
    }

    /**
     * 登陆注销
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/loginOut", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public @ResponseBody
    Object loginOut(HttpServletRequest request) throws Exception {
        request.getSession().setAttribute("name", null);
        request.getSession().setAttribute("photo", null);
        JSONObject jsonObject = new JSONObject();
        try {
            SecurityUtils.getSubject().logout();
        } catch (Exception e) {
            jsonObject.put("msg", "注销失败");
            jsonObject.put("code", 202);
        }
        jsonObject.put("msg", "注销成功");
        jsonObject.put("url", "index");
        jsonObject.put("code", 200);
        return jsonObject;
    }

    /**
     * 登陆功能
     * @param user
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public @ResponseBody
    Object login(User user, HttpServletRequest request) throws Exception {
        System.out.println(this.getIp2(request));
        JSONObject json = new JSONObject();
        json.put("code", 200);
        json.put("msg", "登陆成功");

        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUser_name(), user.getUser_password());
        try {
            subject.login(token);
        } catch (UnknownAccountException e) {
            json.put("code", 201);
            json.put("msg", "账号不存在");
        } catch (LockedAccountException e) {
            json.put("code", 201);
            json.put("msg", "账户被锁定");
        } catch (IncorrectCredentialsException e) {
            json.put("code", 201);
            json.put("msg", "密码错误");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return json;
    }


    /**
     * 获取ip
     * @param request
     * @return
     */
    public String getIp2(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");
        if (StringUtils.isNotEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)) {
            //多次反向代理后会有多个ip值，第一个ip才是真实ip
            int index = ip.indexOf(",");
            if (index != -1) {
                return ip.substring(0, index);
            } else {
                return ip;
            }
        }
        ip = request.getHeader("X-Real-IP");
        if (StringUtils.isNotEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)) {
            return ip;
        }
        return request.getRemoteAddr();
    }

    @RequestMapping("userAdd")
    public String userAdd() {
        return "front/userAdd";
    }

    @RequestMapping("index")
    public String index(Model model) {
        return "front/index";
    }

    /**
     * 获取用户详细信息
     * @param user_name
     * @return
     */
    @RequestMapping("userDetails")
    public ModelAndView userDetails(String user_name){
        ModelAndView modelAndView = new ModelAndView("front/user_details");
        User user = service.getUserByName(user_name);
        Date date =  user.getUser_birthday();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        modelAndView.addObject("birthday",simpleDateFormat.format(date));
        modelAndView.addObject("user",user);
        System.out.println(user.getUser_sex());
        modelAndView.addObject("user_age",super.getAgeByBirthday(user.getUser_birthday()));//计算年龄
        return modelAndView;
    }

    @Override
    public String getType() {
        return null;
    }

    @Override
    public String getFileUploadDir() {
        return "/uploadFiles/userPhoto";
    }
}
