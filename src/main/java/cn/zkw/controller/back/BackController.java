package cn.zkw.controller.back;

import cn.zkw.service.SortService;
import cn.zkw.service.VisitorVolumeService;
import cn.zkw.util.action.AbstractAction;
import cn.zkw.vo.User;
import cn.zkw.vo.VisitorVolume;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Controller
public class BackController extends AbstractAction {
    @Autowired
    SortService sortService;

    @Autowired
    VisitorVolumeService visitorVolumeService;

    @RequestMapping(value = "/volume", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public @ResponseBody Object getVolume(HttpServletRequest request) throws Exception {
        JSONObject jsonObject = new JSONObject();
        List<VisitorVolume> list = visitorVolumeService.findAllVisitorVolume(); //获取全部访问量
        String day[] = new String[list.size()];
        Integer volume[] = new Integer[list.size()];
        Iterator<VisitorVolume> iterator = list.iterator();
        for (int i=0;i<list.size();i++){           //遍历list集合
            VisitorVolume vo = (VisitorVolume)list.get(i);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM.dd");
            day[i] = simpleDateFormat.format(vo.getDay());//添加日期
            volume[i] = vo.getVolume();
        }
        jsonObject.put("day",day);
        jsonObject.put("volume",volume);
        return jsonObject;
    }

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
