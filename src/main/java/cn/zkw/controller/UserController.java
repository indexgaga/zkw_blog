package cn.zkw.controller;

import cn.zkw.service.UserService;
import cn.zkw.util.action.AbstractAction;
import cn.zkw.vo.User;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Controller
public class UserController extends AbstractAction {
    @Resource
    UserService service;

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


    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public @ResponseBody
    Object addUser(User user, HttpServletRequest request) throws Exception {
        System.out.println(request.getRemoteAddr());
        System.out.println(user);
        ModelAndView modelAndView = new ModelAndView("front/tip");
        user.setUser_lock(0); //用户默认不锁定
        user.setUser_level(1); //用户默认等级为一级
        user.setUser_ip(request.getRemoteAddr());  //ip
        user.setUser_photo("nophoto.png");  //头像名称
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

    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public @ResponseBody
    Object login(User user, HttpServletRequest request) throws Exception {
        System.out.println(this.getIp2(request));
        JSONObject json = new JSONObject();
        json.put("code", 200);
        json.put("msg", "登陆成功");
        System.out.println("username=" + user.getUser_name());
//        User vo = service.getUserByName(user.getUser_name());
        System.out.println(user);
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
    public String index() {
        return "front/index";
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
