package com.example.semillerodia1.infraestructure.services;

import com.example.semillerodia1.core.domain.*;
import com.example.semillerodia1.core.gateways.MaintenanceServiceRepository;
import com.example.semillerodia1.infraestructure.controller.models.MaintenanceServiceDTO;
import com.example.semillerodia1.infraestructure.controller.models.MaintenanceServiceInput;
import com.example.semillerodia1.shared.domain.Limit;
import com.example.semillerodia1.shared.domain.PageQuery;
import com.example.semillerodia1.shared.domain.Skip;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Function;

@Service
public class MaintenanceServiceService {
    private final MaintenanceServiceRepository maintenanceServiceRepository;

    public MaintenanceServiceService(MaintenanceServiceRepository maintenanceServiceRepository) {
        this.maintenanceServiceRepository = maintenanceServiceRepository;
    }

    public MaintenanceServiceDTO createMaintenanceService(MaintenanceServiceInput maintenanceServiceInput){
        String value = UUID.randomUUID().toString();
            MaintenanceService maintenanceService = new MaintenanceService(
                new MaintenanceServiceId(value),
                new MaintenanceServiceDateTimeStart(maintenanceServiceInput.getDateTimeStart()),
                    new MaintenanceServiceDateTimeEnd(maintenanceServiceInput.getDateTimeEnd()),
                    new MaintenanceServiceDescription(maintenanceServiceInput.getDescription())
            );
            maintenanceServiceRepository.store(maintenanceService);
            return MaintenanceServiceDTO.fromDomain(maintenanceService);
    }

    public List<MaintenanceServiceDTO> queryMaintenance(Integer limit, Integer skip){
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

    public Optional<MaintenanceServiceDTO> getMaintenance(String id) {
        return maintenanceServiceRepository.get(new MaintenanceServiceId(id))
                .map((maintenance) ->{
                    return MaintenanceServiceDTO.fromDomain(maintenance);
                });
    }

    public MaintenanceServiceId deleteService(String id) {
        return maintenanceServiceRepository.delete(new MaintenanceServiceId(id));
    }
}
