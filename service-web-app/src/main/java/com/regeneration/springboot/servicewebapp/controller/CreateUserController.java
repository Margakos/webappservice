package com.regeneration.springboot.servicewebapp.controller;

import com.regeneration.springboot.servicewebapp.converters.UserConverter;
import com.regeneration.springboot.servicewebapp.forms.CreateUser;

import com.regeneration.springboot.servicewebapp.model.User;
import com.regeneration.springboot.servicewebapp.services.AccountService;
import com.regeneration.springboot.servicewebapp.services.AccountServiceImpl;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class CreateUserController {
    private final static org.slf4j.Logger logger = LoggerFactory.getLogger(CreateUserController.class);


    @Autowired
    private AccountService accountService;

    private final static org.slf4j.Logger LOG = LoggerFactory.getLogger(AccountServiceImpl.class);
    private static final String CREATE_USER = "createUser";

    @RequestMapping(value = "/admin/create", method = RequestMethod.GET)
    public String login(Model model,
                        @RequestParam(name = "error", required = false) String error,
                        HttpSession session) {

        if (error != null) {
            LOG.error("User not found!");
            model.addAttribute("errorMessage", "User not found! Please try again");
        }

        model.addAttribute(CREATE_USER, new CreateUser());
        return "createUser";
    }

    @RequestMapping(value = "/admin/create", method = RequestMethod.POST)
    public String register(@ModelAttribute(CREATE_USER)
                                   CreateUser createUser,
                           Model model,
                           BindingResult bindingResult, HttpSession session,
                           RedirectAttributes redirectAttributes) {


        if (bindingResult.hasErrors()) {

            logger.error(String.format("%s Validation Errors present: ",
                    bindingResult.getErrorCount()));
            model.addAttribute(CREATE_USER, createUser);
            return "createUser";
        }

        try {

            User user = UserConverter.buildUserObject(createUser);
            accountService.register(user);
            session.setAttribute("firstName", createUser.getFirstName());


        } catch (Exception exception) {
            redirectAttributes.addFlashAttribute("errorMessage", exception.getMessage());
            logger.error("User registration failed: " + exception);
        }
        redirectAttributes.addFlashAttribute("message", "You have sucessfully completed registration");
        return "redirect:/admin/create";
    }
}
