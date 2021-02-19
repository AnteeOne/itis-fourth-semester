package tech.anteeone.springcontrollers.repository;

import tech.anteeone.springcontrollers.config.ConfigRepository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnectionService {

    private Connection connection = null;

    public Connection getConnection() {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(ConfigRepository.DB_URI,
                    ConfigRepository.DB_USER,
                    ConfigRepository.DB_PASSWORD);
        }
        catch (SQLException e){
            throw new IllegalStateException(e);
            //fixme logger logic
        }
        catch (Exception e){
            throw new IllegalStateException(e);
            //fixme logger logic
        }
        return connection;
    }

}
