package com.regeneration.springboot.servicewebapp.converters;

import com.regeneration.springboot.servicewebapp.forms.CreateRepair;
import com.regeneration.springboot.servicewebapp.model.Repair;

public class RepairConverter {


    public static Repair buildRepairObject(CreateRepair createRepair){

        Repair repair = new Repair();
        repair.setArriveDate(createRepair.getArriveDate());
        repair.setCost(createRepair.getCost());
        repair.setType(createRepair.getType());
        repair.setDescription(createRepair.getDescription());
        repair.setStatus(createRepair.getStatus());
        repair.setUserId(createRepair.getUserId());
        return repair;
    }

}
