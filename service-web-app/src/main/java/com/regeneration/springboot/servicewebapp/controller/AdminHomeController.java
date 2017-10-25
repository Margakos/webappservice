package com.regeneration.springboot.servicewebapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdminHomeController {



    @RequestMapping(value = "admin/home",method = RequestMethod.GET)
    public String showAdminHome(Model model){

        return "admin-home";


    }






}
