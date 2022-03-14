package com.example.semillerodia1.core.gateways;

import com.example.semillerodia1.core.domain.MaintenanceService;
import com.example.semillerodia1.core.domain.MaintenanceServiceId;
import com.example.semillerodia1.shared.domain.PageQuery;

import java.util.List;
import java.util.Optional;

public interface MaintenanceServiceRepository {

    List<MaintenanceService> query(PageQuery pageQuery);

    Optional<MaintenanceService> get(MaintenanceServiceId maintenanceServiceId);

    void store(MaintenanceService maintenanceService);

    MaintenanceServiceId delete(MaintenanceServiceId id);

    void update(MaintenanceService maintenanceService);
}
