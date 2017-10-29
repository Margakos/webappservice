package com.regeneration.springboot.servicewebapp.controller;

import com.regeneration.springboot.servicewebapp.converters.UserConverter;
import com.regeneration.springboot.servicewebapp.forms.CreateUser;
import com.regeneration.springboot.servicewebapp.forms.SearchForm;
import com.regeneration.springboot.servicewebapp.model.User;
import com.regeneration.springboot.servicewebapp.services.UserService;
import com.regeneration.springboot.servicewebapp.services.UserServiceImpl;
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
public class UserController {

    private final static org.slf4j.Logger logger = LoggerFactory.getLogger(UserController.class);
    private final static org.slf4j.Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);
    public static final String SEARCH_FORM = "searchForm";
    public static final String CUSTOMER = "customer";
    public static final String USER_DETAILS = "userDetails";
    private static final String CREATE_USER = "createUser";

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/admin/create", method = RequestMethod.GET)
    public String userForm(Model model,
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
    public String register(@Valid @ModelAttribute(CREATE_USER)
                                   CreateUser createUser,
                           Model model,
                           BindingResult bindingResult, HttpSession session,
                           RedirectAttributes redirectAttributes) {


        if (bindingResult.hasErrors()) {


            model.addAttribute(CREATE_USER, createUser);
            logger.error(String.format("%s Validation Errors present: ", bindingResult.getErrorCount()));

            return "register";
        }

        try {

            User user = UserConverter.buildUserObject(createUser);
            userService.register(user);
            session.setAttribute("username", createUser.getFirstName());


        } catch (Exception exception) {
            redirectAttributes.addFlashAttribute("errorMessage", exception.getMessage());
            logger.error("User registration failed: " + exception);
        }
        redirectAttributes.addFlashAttribute("message", "You have successfully completed registration");
        return "redirect:/admin/create";
    }

    @RequestMapping(value = "/admin/search", method = RequestMethod.GET)
    public String searchUser(Model model) {

        return "search-form";
    }

    @RequestMapping(value = "/admin/search", method = RequestMethod.POST)
    public String searchUserPost(Model model, @RequestParam("search") String input, @ModelAttribute(name = SEARCH_FORM) SearchForm searchForm,
                             RedirectAttributes redirectAttributes) {

        User user = userService.findByEmailOrAfm(input);
        if (user == null) {

            redirectAttributes.addFlashAttribute("errorMessage", "No user found");
        } else {
            redirectAttributes.addFlashAttribute(CUSTOMER, user);
        }
        return "redirect:/admin/search";
    }

    @RequestMapping(value = "/admin/search/update", method = RequestMethod.POST)
    public String updateUser(@ModelAttribute(USER_DETAILS) CreateUser updateForm, RedirectAttributes redirectAttributes) {

        try {
            userService.update(UserConverter.buildUserObject(updateForm));
            redirectAttributes.addFlashAttribute("message", "User successfully updated");
        } catch (Exception ex) {
            redirectAttributes.addFlashAttribute("errorMessage", "Upadate faild");

        }

        return "redirect:/admin/home";
    }

    @RequestMapping(value = "/admin/search/delete", method = RequestMethod.POST)
    public String deleteUser(@ModelAttribute(USER_DETAILS) CreateUser deleteForm,
                             RedirectAttributes redirectAttributes) {

        try {
            userService.deleteUser(deleteForm.getUserId());
            redirectAttributes.addFlashAttribute("message", "User successfully deleted");
        } catch (Exception ex) {

            redirectAttributes.addFlashAttribute("errorMessage", "Delete failed");

        }
        return "redirect:/admin/home";
    }

}
