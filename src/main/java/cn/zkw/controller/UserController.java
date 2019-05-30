package cn.zkw.controller;

import cn.zkw.service.UserService;
import cn.zkw.util.action.AbstractAction;
import cn.zkw.vo.User;
import net.sf.json.JSONObject;
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
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Controller
public class UserController extends AbstractAction {
    @Resource
    UserService service;

    @RequestMapping(value = "/user", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public @ResponseBody
    Object userAdd(User user, MultipartFile photo, HttpServletRequest request) throws Exception {
        System.out.println(request.getRemoteAddr());
        String time_photo_name = super.createFileName(photo); //图片名称UUID
        user.setUser_lock(0); //用户默认不锁定
        user.setUser_level(1); //用户默认等级为一级
        user.setUser_ip(request.getRemoteAddr());  //ip
        user.setUser_photo(time_photo_name);  //头像名称
        user.setUser_registration_time(new Date()); //注册时间
        user.setUser_rights(1);  //默认权限为一，，表示不是会员
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code",201);
        jsonObject.put("msg","注册失败，请检查格式");
        if (service.userAdd(user)) {
            if(super.saveFile(photo,time_photo_name,request)){
                jsonObject.put("code",200);
                jsonObject.put("msg","注册成功");
            }
        }
        return jsonObject;
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
        jsonObject.put("code", 200);
        return jsonObject;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public @ResponseBody
    Object login(User user) throws Exception {
        JSONObject json = new JSONObject();
        json.put("code", 200);
        json.put("msg", "登陆成功");
        System.out.println("username=" + user.getUser_name());
//        User vo = service.findUserByName(user.getUser_name());
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

    @Override
    public String getType() {
        return null;
    }

    @Override
    public String getFileUploadDir() {
        return "/uploadFiles/userPhoto";
    }
}
