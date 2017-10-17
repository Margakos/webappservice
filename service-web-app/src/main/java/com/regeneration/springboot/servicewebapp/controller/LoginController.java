package com.regeneration.springboot.servicewebapp.controller;

import com.regeneration.springboot.servicewebapp.forms.LoginForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class LoginController {


    public static final String LOGIN_FORM="loginForm";



    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String login(Model model){

        model.addAttribute(LOGIN_FORM, new LoginForm());

        return "login";
    }


    @RequestMapping(value = "/",method = RequestMethod.POST)
    public String postLogin( @Valid @ModelAttribute(LOGIN_FORM) LoginForm loginForm,BindingResult theResult){
        System.out.println(loginForm.getUsername());
       if (theResult.hasErrors()){

           return "login";
       }else

       return "confirm";

    }


}
