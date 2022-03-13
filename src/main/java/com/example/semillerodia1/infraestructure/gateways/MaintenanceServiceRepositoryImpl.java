package com.example.semillerodia1.infraestructure.gateways;

import com.example.semillerodia1.core.domain.MaintenanceService;
import com.example.semillerodia1.core.domain.MaintenanceServiceId;
import com.example.semillerodia1.core.gateways.MaintenanceServiceRepository;
import com.example.semillerodia1.infraestructure.gateways.models.MaintenanceServiceDBO;
import com.example.semillerodia1.shared.domain.PageQuery;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
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
                MaintenanceServiceDBO maintenanceServiceDBO = MaintenanceServiceDBO.fromResultSet(resultSet);
                MaintenanceService maintenanace = maintenanceServiceDBO.toDomain();
                result.add(maintenanace);
            }

            resultSet.close();

            return result;
        } catch (SQLException exception){
            throw new RuntimeException("Error querying database", exception);
        }
    }

    @Override
    public Optional<MaintenanceService> get(MaintenanceServiceId maintenanceServiceId) {
        String sql = "SELECT * FROM maintenance_service WHERE maintenance_id = ?";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)){

            preparedStatement.setString(1, maintenanceServiceId.toString());
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){
                MaintenanceServiceDBO maintenanceServiceDBO = MaintenanceServiceDBO.fromResultSet(resultSet);
                MaintenanceService maintenanace = maintenanceServiceDBO.toDomain();
                return Optional.of(maintenanace);
            } else {
                return Optional.empty();
            }
        }catch (SQLException exception){
            throw new RuntimeException("Error querying database", exception);
        }
    }

    @Override
    public void store(MaintenanceService maintenanceService) {
        String sql = "INSERT INTO maintenance_service (maintenance_id, maintenance_datetimestart, maintenance_datetimeend, maintenance_description) VALUES (?,?,?,?)";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)){

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

            preparedStatement.setString(1, maintenanceService.getId().toString());
            preparedStatement.setTimestamp(2, Timestamp.valueOf(maintenanceService.getDateTimeStart().getDateTimeStart().format(formatter)));
            preparedStatement.setTimestamp(3, Timestamp.valueOf(maintenanceService.getDateTimeEnd().getDateTimeEnd().format(formatter)));
            preparedStatement.setString(4, maintenanceService.getDescription().toString());
            preparedStatement.executeUpdate();


        }catch (SQLException exception){
            throw new RuntimeException("Error querying database", exception);
        }
    }

    @Override
    public MaintenanceServiceId delete(MaintenanceServiceId maintenanceServiceId) {
        String sql = "DELETE FROM maintenance_service WHERE maintenance_id = ?";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)){

            preparedStatement.setString(1, maintenanceServiceId.toString());
            preparedStatement.execute();

            return maintenanceServiceId;
        }catch (SQLException exception){
            throw new RuntimeException("Error querying database", exception);
        }
    }
}
