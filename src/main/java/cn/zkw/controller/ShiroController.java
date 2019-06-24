package cn.zkw.controller;

import cn.zkw.util.action.AbstractAction;
import org.springframework.stereotype.Controller;

@Controller
public class ShiroController extends AbstractAction {

    @Override
    public String getType() {
        return null;
    }

    @Override
    public String getFileUploadDir() {
        return null;
    }
}
