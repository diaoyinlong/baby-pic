package com.diao.home;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * PageController
 */
@Controller
public class HomeIndex {

    @RequestMapping("/qiqi")
    public String qiqiAction(Model model) {
        return "index";
    }
}