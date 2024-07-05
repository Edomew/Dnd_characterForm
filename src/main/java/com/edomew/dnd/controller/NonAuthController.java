package com.edomew.dnd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NonAuthController {

    @GetMapping(value = {"/","/home"})
    public String nonAuthController() {
        return "/homePage";
    }
    /*TODO Сделать переадресацию на приложение auth*/
    @GetMapping("/login")
    public String login() {

        return "redirect:";
    }

    @GetMapping("/css")
    public String css() {
        return "/content/css/main.css";
    }

    @GetMapping("/js")
    public String js() {
        return "/content/js/index.js";
    }

}
