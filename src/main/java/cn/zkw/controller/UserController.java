package cn.zkw.controller;

import cn.zkw.util.action.AbstractAction;
import cn.zkw.vo.User;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class UserController extends AbstractAction {

    @RequestMapping(value = "/login",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public @ResponseBody
    Object login(User user){
        JSONObject json = new JSONObject();
        json.put("msg","登陆成功");
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
