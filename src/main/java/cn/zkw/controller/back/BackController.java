package cn.zkw.controller.back;

import cn.zkw.service.SortService;
import cn.zkw.util.action.AbstractAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class BackController extends AbstractAction {
    @Autowired
    SortService sortService;

    //后台主页
    @RequestMapping("/back/main")
    public String main(){
        return "/back/main";
    }

    //文章添加的页面跳转,加载了文章类别的数据
    @RequestMapping("/back/add_article")
    public ModelAndView addArticle(){
        //获取当前日期,显示在添加文章页面
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String datestr = simpleDateFormat.format(date);

        ModelAndView modelAndView = new ModelAndView("/back/add-article");
        modelAndView.addObject("date",datestr);
        modelAndView.addObject("sortList",sortService.findAllSort());  //传入文章类别集合
        return modelAndView;  //跳转到文章添加页面
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
