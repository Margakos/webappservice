package com.regeneration.springboot.servicewebapp.controller;

import com.regeneration.springboot.servicewebapp.forms.CreateRepair;
import com.regeneration.springboot.servicewebapp.services.RepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class AdminHomeController {


    public static final String CREATE_REPAIR = "createRepair";
    public static final String REPAIRLIST = "repairs";

    @Autowired
    private RepairService repairService;

    @RequestMapping(value = "admin/home", method = RequestMethod.GET)
    public String showAdminHome(Model model) {
        model.addAttribute(CREATE_REPAIR, new CreateRepair());
        model.addAttribute(REPAIRLIST, repairService.findAll());

        return "admin-home";

    }

}
