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
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class UserController extends AbstractAction {
    @Resource
    UserService service;

    @RequestMapping(value = "/login",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public @ResponseBody
    Object login(User user)throws Exception{
        JSONObject json = new JSONObject();
        json.put("code",200);
        json.put("msg","登陆成功");
        System.out.println("username="+user.getUser_name());
        User vo =  service.findUserByName(user.getUser_name());
        System.out.println(vo);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(vo.getUser_name(),vo.getUser_password());
        try {
            subject.login(token);
        }catch (UnknownAccountException e){
            json.put("msg","账号不存在");
        }catch (LockedAccountException e){
            json.put("msg","账户被锁定");
        }catch (IncorrectCredentialsException e){
            e.printStackTrace();
            json.put("msg","密码错误");
        }catch (Exception e){
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
        return null;
    }
}
