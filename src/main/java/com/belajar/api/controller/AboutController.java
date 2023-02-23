package com.belajar.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AboutController {

    @RequestMapping("/about")
    @ResponseBody
    public String about() {
        return "Ini adalah halaman About Us.";
    }
}
