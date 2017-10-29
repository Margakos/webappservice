package com.regeneration.springboot.servicewebapp.controller;

import com.regeneration.springboot.servicewebapp.converters.UserConverter;
import com.regeneration.springboot.servicewebapp.forms.CreateRepair;
import com.regeneration.springboot.servicewebapp.forms.CreateUser;
import com.regeneration.springboot.servicewebapp.model.Repair;
import com.regeneration.springboot.servicewebapp.model.User;
import com.regeneration.springboot.servicewebapp.services.RepairService;
import com.regeneration.springboot.servicewebapp.services.UserService;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserHomeController {

    public static final String CREATE_USER = "createUser";
    public static final String REPAIR_LIST = "repairs";

    @Autowired
    private RepairService repairService;

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/user/home", method = RequestMethod.GET)
    public String showUserHome(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            String email = (String) auth.getPrincipal();
            User user = userService.findByEmailOrAfm(email);
            List<Repair> repairList = repairService.findAllByUserId(user.getUserId());
            model.addAttribute(REPAIR_LIST,repairList);
        }
        model.addAttribute(CREATE_USER, new CreateUser());
        return "user-home";

    }


    @RequestMapping(value = "/user/home",method = RequestMethod.POST)
    public String showUserPage(Model model, @ModelAttribute(CREATE_USER)CreateUser createUser, RedirectAttributes redirectAttributes){


        model.addAttribute(CREATE_USER,new CreateUser());
        List<Repair> repair = repairService.findAllByUserId(createUser.getUserId());

        model.addAttribute(REPAIR_LIST, repair);

        return "user-home";
    }



}
