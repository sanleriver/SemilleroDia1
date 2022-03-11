package com.example.semillerodia1.infraestructure.controller;

import com.example.semillerodia1.core.gateways.MaintenanceServiceRepository;
import com.example.semillerodia1.infraestructure.controller.models.MaintenanceServiceDTO;
import com.example.semillerodia1.infraestructure.controller.models.MaintenanceServiceInput;
import com.example.semillerodia1.core.domain.*;
import com.example.semillerodia1.shared.domain.Limit;
import com.example.semillerodia1.shared.domain.PageQuery;
import com.example.semillerodia1.shared.domain.Skip;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
public class MaintenanceServiceController {
    private final MaintenanceServiceRepository maintenanceServiceRepository;

    public MaintenanceServiceController(MaintenanceServiceRepository maintenanceServiceRepository) {
        this.maintenanceServiceRepository = maintenanceServiceRepository;
    }

    @RequestMapping(path = "/services/{id}", method = RequestMethod.GET)
    public MaintenanceServiceDTO getProducts(@PathVariable(value = "id") String id){
        return new MaintenanceServiceDTO();
    }

    @RequestMapping(path = "/services", method = RequestMethod.GET)
    public List<MaintenanceServiceDTO> listServiceDTO(
            @RequestParam(name = "skip", defaultValue = "0") Integer skip,
            @RequestParam(name = "limit", defaultValue = "50") Integer limit
    ){
        PageQuery pageQuery = new PageQuery(
                new Limit(limit),
                new Skip(skip)
        );
        List<MaintenanceService> maintenanceServices = maintenanceServiceRepository.query(pageQuery);
        List<MaintenanceServiceDTO> result = new ArrayList<>();
        for (MaintenanceService maintenance: maintenanceServices) {
            MaintenanceServiceDTO dto = MaintenanceServiceDTO.fromDomain(maintenance);
            result.add(dto);
        }
        return result;
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
