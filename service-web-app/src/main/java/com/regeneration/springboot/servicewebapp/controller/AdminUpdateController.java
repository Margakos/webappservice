package com.regeneration.springboot.servicewebapp.controller;

import com.regeneration.springboot.servicewebapp.converters.UserConverter;
import com.regeneration.springboot.servicewebapp.forms.CreateUser;
import com.regeneration.springboot.servicewebapp.forms.SearchForm;
import com.regeneration.springboot.servicewebapp.model.User;
import com.regeneration.springboot.servicewebapp.repositories.UserRepository;
import com.regeneration.springboot.servicewebapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller

public class AdminUpdateController {

    public static final String UPDATE_FORM="userDetails";

    @Autowired
    UserService userService;


    @RequestMapping(value = "/admin/search/update",method = RequestMethod.POST)
    public String updateUser(@ModelAttribute(UPDATE_FORM)CreateUser updateForm, RedirectAttributes redirectAttributes){

        try{
        userService.update(UserConverter.buildUserObject(updateForm));
        redirectAttributes.addFlashAttribute("message","User succesfully updated");
        }
        catch(Exception ex){
            redirectAttributes.addFlashAttribute("errorMessage","Upadate faild");

        }

        return "redirect:/admin/home";
    }


/*    @RequestMapping(value = "/admin/search/update",method = RequestMethod.POST)
    public String postUpdateUser(){



    }*/


}
