package com.example.SmartMedicalCenter.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class IndexController {

    @GetMapping("")
    public ModelAndView home() {
        ModelAndView mav=new ModelAndView("index");
        return mav;
    }

}