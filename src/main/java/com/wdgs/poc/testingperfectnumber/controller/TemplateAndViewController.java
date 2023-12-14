package com.wdgs.poc.testingperfectnumber.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = "/")
public class TemplateAndViewController {

    @GetMapping
    public ModelAndView loadTemplate() {
        return new ModelAndView("layout");

    }


}
