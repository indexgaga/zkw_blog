package cn.zkw.controller.back;

import cn.zkw.util.action.AbstractAction;
import net.sf.json.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

@RequestMapping("/back/article")
public class ArticleController extends AbstractAction {

    @RequestMapping(value = "/uploadimage",method = RequestMethod.POST)
    public Object uploadImg(MultipartFile upfile, HttpServletRequest request){
        System.out.println("into uploadAction");
        JSONObject jsonObject = new JSONObject();
        String filename = upfile.getName();  //ueditor UUID生成图片名
        System.out.println(filename);
        String url = "/uploadFiles/atricleImg/"+filename;
        jsonObject.put("url",url);    //设置图片路径
        jsonObject.put("title",filename);  //图片名称
        jsonObject.put("original",filename);  //图片名称
        if(super.saveFile(upfile,filename,request)){  //保存图片
            System.out.println("保存成功");
            jsonObject.put("state","SUCCESS");
        }else{
            System.out.println("保存失败");
            jsonObject.put("state","ERROR");
        }
        return jsonObject;
    }

    @Override
    public String getType() {
        return null;
    }

    @Override
    public String getFileUploadDir() {
        return "/uploadFiles/atricleImg";
    }
}
