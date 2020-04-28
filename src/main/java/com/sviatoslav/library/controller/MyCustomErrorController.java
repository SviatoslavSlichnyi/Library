package com.sviatoslav.library.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyCustomErrorController implements ErrorController {

    @RequestMapping(value = "/error")
    public String renderErrorPage() {
        return "error";
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}
