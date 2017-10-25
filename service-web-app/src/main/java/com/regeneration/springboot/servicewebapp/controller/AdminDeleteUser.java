package com.regeneration.springboot.servicewebapp.controller;

import com.regeneration.springboot.servicewebapp.converters.UserConverter;
import com.regeneration.springboot.servicewebapp.forms.CreateUser;
import com.regeneration.springboot.servicewebapp.model.User;
import com.regeneration.springboot.servicewebapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
public class AdminDeleteUser {

    public static final String USER_DETAILS="userDetails";

    @Autowired
    UserService userService;

    @RequestMapping(value = "/admin/search/delete",method = RequestMethod.POST)
    public String deleteUser(@ModelAttribute(USER_DETAILS)CreateUser deleteForm,
                              RedirectAttributes redirectAttributes){

        try {
            userService.deleteUser(deleteForm.getUserId());
            redirectAttributes.addFlashAttribute("message","User succefullly deleted");
        }catch(Exception ex){

            redirectAttributes.addFlashAttribute("errorMessage","Delete failed");

        }
        return "redirect:/admin/home";
    }
}
