package com.savior.controllers.index;

import com.savior.common.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2015/1/29.
 */
@Controller("indexController")
@RequestMapping("")
public class IndexController extends BaseController {

    @RequestMapping({"", "/index"})
    public String index() throws Exception {
        return "index";
    }
}
