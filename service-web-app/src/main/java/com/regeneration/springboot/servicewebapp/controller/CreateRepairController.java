package com.regeneration.springboot.servicewebapp.controller;

import com.regeneration.springboot.servicewebapp.converters.RepairConverter;
import com.regeneration.springboot.servicewebapp.forms.CreateRepair;
import com.regeneration.springboot.servicewebapp.model.Repair;
import com.regeneration.springboot.servicewebapp.services.RepairService;
import com.regeneration.springboot.servicewebapp.services.RepairServiceImpl;
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
public class CreateRepairController {

    private final static org.slf4j.Logger logger = LoggerFactory.getLogger(CreateRepairController.class);


    @Autowired
    private RepairService repairService;

    private final static org.slf4j.Logger LOG = LoggerFactory.getLogger(RepairServiceImpl.class);
    private static final String CREATE_REPAIR = "createRepair";

    @RequestMapping(value = "/admin/create/repair", method = RequestMethod.GET)
    public String login(Model model,
                        @RequestParam(name = "error", required = false) String error,
                        HttpSession session) {

        if (error != null) {
            LOG.error("Repair not found!");
            model.addAttribute("errorMessage", "User not found! Please try again");
        }

        model.addAttribute(CREATE_REPAIR, new CreateRepair());
        return "createRepair";
    }

    @RequestMapping(value = "/admin/create/repair", method = RequestMethod.POST)
    public String register(@Valid @ModelAttribute(CREATE_REPAIR)
                                   CreateRepair createRepair, BindingResult bindingResult,
                           Model model, HttpSession session,
                           RedirectAttributes redirectAttributes) {


        if (bindingResult.hasErrors()) {

            logger.error(String.format("%s Validation Errors present: ",
                    bindingResult.getErrorCount()));
            model.addAttribute(CREATE_REPAIR, createRepair);
            return "createRepair";
        }

        try {

            Repair repair = RepairConverter.buildRepairObject(createRepair);
            repairService.register(repair);
            session.setAttribute("arriveDate", createRepair.getArriveDate());
            redirectAttributes.addFlashAttribute("message", "You have sucessfully completed registration");


        } catch (Exception exception) {
            redirectAttributes.addFlashAttribute("errorMessage", exception.getMessage());
            logger.error("Repair registration failed: " + exception);
        }
        return "redirect:/admin/create/repair";
    }


}
