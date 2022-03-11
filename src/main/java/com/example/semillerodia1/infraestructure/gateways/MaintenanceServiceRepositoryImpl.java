package com.example.semillerodia1.infraestructure.gateways;

import com.example.semillerodia1.core.domain.MaintenanceService;
import com.example.semillerodia1.core.domain.MaintenanceServiceId;
import com.example.semillerodia1.core.gateways.MaintenanceServiceRepository;
import com.example.semillerodia1.infraestructure.gateways.models.MaintenanceServiceDBO;
import com.example.semillerodia1.shared.domain.PageQuery;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class MaintenanceServiceRepositoryImpl implements MaintenanceServiceRepository {
    private final DataSource dataSource;

    public MaintenanceServiceRepositoryImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<MaintenanceService> query(PageQuery pageQuery) {
        String sql = "SELECT * FROM maintenance_service LIMIT ? OFFSET ?";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)){

            preparedStatement.setInt(1, pageQuery.getLimit().getValue());
            preparedStatement.setInt(2, pageQuery.getSkip().getValue());

            ResultSet resultSet = preparedStatement.executeQuery();
            List<MaintenanceService> result = new ArrayList<>();

            while (resultSet.next()){
                MaintenanceServiceDBO maintenanceServiceDBO = new MaintenanceServiceDBO();
                maintenanceServiceDBO.setId(resultSet.getString("maintenance_id"));
                maintenanceServiceDBO.setDateTimeStart(resultSet.getTimestamp("maintenance_datetimestart").toLocalDateTime());
                maintenanceServiceDBO.setDateTimeEnd(resultSet.getTimestamp("maintenance_datetimeend").toLocalDateTime());
                maintenanceServiceDBO.setDescription(resultSet.getString("maintenance_description"));
                MaintenanceService domain = maintenanceServiceDBO.toDomain();
                result.add(domain);
            }

            resultSet.close();

            return result;
        } catch (SQLException exception){
            throw new RuntimeException("Error querying database", exception);
        }
    }

    @Override
    public Optional<MaintenanceService> get(MaintenanceServiceId maintenanceServiceId) {
        return Optional.empty();
    }

    @Override
    public void store(MaintenanceService maintenanceService) {

    }
}
