package com.demico.customers.customers.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HomeController {
    public String getName(){
        return "my name is hamed";
    }
}
