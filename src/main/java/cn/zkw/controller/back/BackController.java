package cn.zkw.controller.back;

import cn.zkw.util.action.AbstractAction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BackController extends AbstractAction {
    //后台主页
    @RequestMapping("/back/main")
    public String main(){
        return "/back/main";
    }

    //文章添加
    @RequestMapping("/back/add-article")
    public String addArticle(){
        return "/back/add-article";
    }

    //文章列表
    @RequestMapping("/back/article")
    public String article(){
        return "/back/article";
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
