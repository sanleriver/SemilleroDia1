package com.example.semillerodia1.controller;

import com.example.semillerodia1.controller.models.MaintenanceServiceDTO;
import com.example.semillerodia1.controller.models.MaintenanceServiceInput;
import com.example.semillerodia1.domain.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class MaintenanceServiceController {

    @RequestMapping(path = "/services/{id}", method = RequestMethod.GET)
    public MaintenanceServiceDTO getProducts(@PathVariable(value = "id") String id){
        return new MaintenanceServiceDTO();
    }

    @RequestMapping(path = "/services", method = RequestMethod.GET)
    public List<MaintenanceServiceDTO> listServiceDTO(
            @RequestParam(name = "skip", defaultValue = "0") Integer skip,
            @RequestParam(name = "limit", defaultValue = "50") Integer limit
    ){
        return List.of();
    }

    @RequestMapping(path = "/services", method = RequestMethod.POST)
    public MaintenanceServiceDTO createService(@RequestBody MaintenanceServiceInput maintenanceServiceInput){
        MaintenanceService maintenanceService = new MaintenanceService(
                new MaintenanceServiceId(UUID.randomUUID().toString()),
                new MaintenanceServiceDateTimeStart(maintenanceServiceInput.getDateTimeStart()),
                new MaintenanceServiceDateTimeEnd(maintenanceServiceInput.getDateTimeEnd()),
                new MaintenanceServiceDescription(maintenanceServiceInput.getDescription()));

        return MaintenanceServiceDTO.fromDomain(maintenanceService);
    }
}
