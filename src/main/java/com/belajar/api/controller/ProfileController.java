package com.belajar.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ProfileController {

    @RequestMapping("/profile")
    @ResponseBody
    public String about() {
        return "Ini adalah halaman Profile.";
    }
}
