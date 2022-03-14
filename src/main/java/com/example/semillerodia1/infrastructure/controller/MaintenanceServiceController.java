package com.example.semillerodia1.infrastructure.controller;

import com.example.semillerodia1.infrastructure.controller.models.MaintenanceServiceDTO;
import com.example.semillerodia1.infrastructure.controller.models.MaintenanceServiceInput;
import com.example.semillerodia1.infrastructure.services.MaintenanceServiceService;
import com.example.semillerodia1.shared.errors.ApplicationError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class MaintenanceServiceController {
    private final MaintenanceServiceService service;

    public MaintenanceServiceController(MaintenanceServiceService service) {
        this.service = service;
    }

    @RequestMapping(path = "/services/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> getProducts(@PathVariable(value = "id") String id){
        Optional<MaintenanceServiceDTO> maintenanceServiceDTO = service.getMaintenance(id);
        if (maintenanceServiceDTO.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(maintenanceServiceDTO);
        } else {
            ApplicationError error = new ApplicationError(
                    "ResourseNotFound",
                    "Maintenance with this id not found",
                    Map.of("id", id)
            );
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
        }
    }

    @RequestMapping(path = "/services", method = RequestMethod.GET)
    public List<MaintenanceServiceDTO> listServiceDTO(
            @RequestParam(name = "skip", defaultValue = "0") Integer skip,
            @RequestParam(name = "limit", defaultValue = "50") Integer limit
    ){
        return service.queryMaintenance(limit, skip);
    }

    @RequestMapping(path = "/services", method = RequestMethod.POST)
    public ResponseEntity<?> createService(@RequestBody MaintenanceServiceInput maintenanceServiceInput){
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(service.createMaintenanceService(maintenanceServiceInput));
        } catch (IllegalArgumentException | NullPointerException e) {
            ApplicationError error = new ApplicationError(
                    "InputDataValidationError",
                    "Bad input data",
                    Map.of(
                            "error", e.getMessage()
                    )
            );
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(error);
        } catch (Exception e){
            ApplicationError error = new ApplicationError(
                    "SystemError",
                    e.getMessage(),
                    Map.of()
            );
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(error);
        }
    }

    @RequestMapping(path = "/services/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> putService(@PathVariable String id, @RequestBody MaintenanceServiceInput maintenanceServiceInput){
        try {
        Optional<MaintenanceServiceDTO> maintenanceServiceDTO = service.getMaintenance(id);
        if (maintenanceServiceDTO.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(service.updateMaintenance(id, maintenanceServiceInput));
        } else {
            ApplicationError error = new ApplicationError(
                    "ResourseNotFound",
                    "Maintenance with this id not found",
                    Map.of("id", id)
            );
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
        }
        } catch (IllegalArgumentException | NullPointerException e) {
            ApplicationError error = new ApplicationError(
                    "InputDataValidationError",
                    "Bad input data",
                    Map.of(
                            "error", e.getMessage()
                    )
            );
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(error);
        } catch (Exception e){
            ApplicationError error = new ApplicationError(
                    "SystemError",
                    e.getMessage(),
                    Map.of()
            );
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(error);
        }
    }

    @RequestMapping(path = "/services/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteService(@PathVariable String id){
        Optional<MaintenanceServiceDTO> maintenanceServiceDTO = service.getMaintenance(id);
        if (maintenanceServiceDTO.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(service.deleteService(id));
        } else {
            ApplicationError error = new ApplicationError(
                    "ResourseNotFound",
                    "Maintenance with this id not found",
                    Map.of("id", id)
            );
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
        }
    }
}
