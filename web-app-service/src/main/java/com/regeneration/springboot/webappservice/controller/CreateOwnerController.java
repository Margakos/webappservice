package com.regeneration.springboot.webappservice.controller;

import com.regeneration.springboot.webappservice.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CreateOwnerController {

    @RequestMapping(value="/create", method = RequestMethod.GET)
    public String createOwner( @ModelAttribute("user") User user) {


        return "createOwner";
    }

}
