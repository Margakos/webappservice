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
        repair.setId(createRepair.getId());   //Try without it <---

        return repair;
    }

    public static CreateRepair buildCreateRepairObject(Repair repair){
        CreateRepair createRepair = new CreateRepair();
        createRepair.setArriveDate(repair.getArriveDate());
        createRepair.setCost(repair.getCost());
        createRepair.setType(repair.getType());
        createRepair.setDescription(repair.getDescription());
        createRepair.setStatus(repair.getStatus());
        createRepair.setUserId(repair.getUserId());
        createRepair.setId(repair.getId());
        return createRepair;
    }

}
