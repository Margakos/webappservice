package com.regeneration.springboot.servicewebapp.controller;

import com.regeneration.springboot.servicewebapp.forms.SearchForm;
import com.regeneration.springboot.servicewebapp.model.User;
import com.regeneration.springboot.servicewebapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AdminSearchController {

public static final String SEARCH_FORM="searchForm";
public static final String CUSTOMER="customer";


@Autowired
    UserService userService;

    @RequestMapping(value = "/admin/search",method = RequestMethod.GET)
    public String searchUsers(Model model){

        return "search-form";
    }

     @RequestMapping(value = "/admin/search",method = RequestMethod.POST)
    public String searchUser(Model model, @RequestParam("search") String input,@ModelAttribute(name=SEARCH_FORM)SearchForm searchForm,
                             RedirectAttributes redirectAttributes){

     User user=userService.findByEmailOrAfm(input);
        if (user==null){

            redirectAttributes.addFlashAttribute("errorMessage","No user found");
        }
        else {
            redirectAttributes.addFlashAttribute(CUSTOMER,user);
        }
        return "redirect:/admin/search";
     }

}
