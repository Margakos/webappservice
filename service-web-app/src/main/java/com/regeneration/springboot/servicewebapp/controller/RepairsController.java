package com.regeneration.springboot.servicewebapp.controller;

import com.regeneration.springboot.servicewebapp.converters.RepairConverter;
import com.regeneration.springboot.servicewebapp.forms.CreateRepair;
import com.regeneration.springboot.servicewebapp.forms.SearchRepair;
import com.regeneration.springboot.servicewebapp.model.Repair;
import com.regeneration.springboot.servicewebapp.services.RepairService;
import com.regeneration.springboot.servicewebapp.services.RepairServiceImpl;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
public class RepairsController {

    private final static org.slf4j.Logger logger = LoggerFactory.getLogger(RepairsController.class);
    public static final String REPAIR_SEARCH ="repairSearch";
    public static final String REPAIR_SEARCH_BETWEEN="repairSearchBetween";

    @Autowired
    private RepairService repairService;

    private final static org.slf4j.Logger LOG = LoggerFactory.getLogger(RepairServiceImpl.class);
    private static final String CREATE_REPAIR = "createRepair";

    @RequestMapping(value = "/admin/create/repair", method = RequestMethod.GET)
    public String repairsForm(Model model,
                        @RequestParam(name = "error", required = false) String error,
                        HttpSession session) {

        if (error != null) {
            LOG.error("Repair not found!");
            model.addAttribute("errorMessage", "User not found! Please try again");
        }

        model.addAttribute(CREATE_REPAIR, new CreateRepair());
        return "create-repair";
    }

    @RequestMapping(value = "/admin/create/repair", method = RequestMethod.POST)
    public String createRepair(@Valid @ModelAttribute(CREATE_REPAIR)
                                   CreateRepair createRepair, BindingResult bindingResult,
                           Model model, HttpSession session,
                           RedirectAttributes redirectAttributes) {


        if (bindingResult.hasErrors()) {

            logger.error(String.format("%s Validation Errors present: ",
                    bindingResult.getErrorCount()));
            model.addAttribute(CREATE_REPAIR, createRepair);
            return "create-repair";
        }

        try {

            Repair repair = RepairConverter.buildRepairObject(createRepair);
            repairService.register(repair);
            session.setAttribute("arriveDate", createRepair.getArriveDate());
            redirectAttributes.addFlashAttribute("message", "You have successfully completed registration");


        } catch (Exception exception) {
            redirectAttributes.addFlashAttribute("errorMessage", exception.getMessage());
            logger.error("Repair registration failed: " + exception);
        }
        return "redirect:/admin/create/repair";
    }

    @RequestMapping(value = "/admin/search/repair",method = RequestMethod.GET)
    public String showSearch(Model model){
        model.addAttribute(REPAIR_SEARCH,new SearchRepair());
        return "search-repair";
    }

    @RequestMapping(value = "/admin/search/repair",method = RequestMethod.POST)
    public String postSearcheRepairs(@RequestParam("arriveDate")String day,@ModelAttribute(REPAIR_SEARCH)SearchRepair searchRepair,
                                     RedirectAttributes redirectAttributes){

        try{
            day=day.replace("T"," ");
            System.out.println(day);
            DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            LocalDateTime finalDate=LocalDateTime.parse(day,formatter);
            System.out.println(finalDate);
            List<Repair> repair=repairService.findByArriveDateLessThanOrderByArriveDateAsc(finalDate);

            redirectAttributes.addFlashAttribute("myRepairs",repair);
        }catch(Exception ex){
            System.out.println(ex.getCause().toString());
            redirectAttributes.addFlashAttribute("errorMessage","Repairs not found fot this period");}
        return "redirect:/admin/search/repair";

    }

    @RequestMapping(value = "admin/search/repair/between",method = RequestMethod.POST)
    public String betweenDates(@RequestParam("first")String day1,@RequestParam("last")String day2,
                               @ModelAttribute(REPAIR_SEARCH_BETWEEN)SearchRepair searchRepair,
                               RedirectAttributes redirectAttributes){

        try {
            day1=day1.replace("T"," ");
            day2=day2.replace("T"," ");
            DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            LocalDateTime firstDay=LocalDateTime.parse(day1,formatter);
            LocalDateTime lastDay=LocalDateTime.parse(day2,formatter);
            List<Repair> repairs = repairService.findByArriveDateBetweenOrderByArriveDateAsc(firstDay, lastDay);
            redirectAttributes.addFlashAttribute("myRepairs",repairs);
        }
        catch(Exception ex){

            redirectAttributes.addFlashAttribute("errorMessage","No  repairs for this period");

        }
        return "redirect:/admin/search/repair";
    }

    @RequestMapping(value = "/admin/update/repair/{repairID}", method = RequestMethod.GET)
    public String updateForm(@PathVariable Long repairID, Model model) throws Exception {

        Repair repair = repairService.findById(repairID).get(0);
        CreateRepair createRepair = RepairConverter.buildCreateRepairObject(repair);
        model.addAttribute(CREATE_REPAIR, createRepair);

        return "update-repair";

    }

    @RequestMapping(value = "/admin/update/repair", method = RequestMethod.POST)
    public String doUpdate(@Valid @ModelAttribute(CREATE_REPAIR)
                                 CreateRepair createRepair, BindingResult bindingResult,
                         Model model, HttpSession session,
                         RedirectAttributes redirectAttributes) {


        if (bindingResult.hasErrors()) {

            logger.error(String.format("%s Validation Errors present: ",
                    bindingResult.getErrorCount()));
            model.addAttribute(CREATE_REPAIR, createRepair);
            return "create-repair";
        }

        try {

            Repair repair = RepairConverter.buildRepairObject(createRepair);
            repairService.register(repair);
            session.setAttribute("arriveDate", createRepair.getArriveDate());
            redirectAttributes.addFlashAttribute("message", "You have successfully completed update");


        } catch (Exception exception) {
            redirectAttributes.addFlashAttribute("errorMessage", exception.getMessage());
            logger.error("Repair registration failed: " + exception);
        }
        return "redirect:/admin/create/repair";
    }

    @RequestMapping(value="/admin/repair/delete/{repairID}", method = RequestMethod.POST)
    public String doDelete(@PathVariable Long repairID) throws Exception {
        repairService.deleteRepair(repairID);
        return "search-repair";

    }


}
