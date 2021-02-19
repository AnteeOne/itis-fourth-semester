package tech.anteeone.springcontrollers.repository.user;

import org.springframework.stereotype.Repository;
import tech.anteeone.springcontrollers.dto.UserDto;
import tech.anteeone.springcontrollers.repository.JDBCConnectionService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository ,AutoCloseable {

    private JDBCConnectionService connector;
    private Connection connection;

    public UserRepositoryImpl() {
        this.connector = new JDBCConnectionService();
        connection = connector.getConnection();
    }

    public UserDto readByEmail(String email){
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT hw3_user.email FROM hw3_user");
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                String emailSQL = rs.getString(1);
                if(email.equals(emailSQL)){
                    return new UserDto(emailSQL);
                }
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void create(UserDto entity) {
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO hw3_user (email,password)" +
                    " VALUES (?,?)");
            ps.setString(1,entity.getEmail());
            ps.setString(2,entity.getPassword());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void read(UserDto entity) {

    }

    @Override
    public List readAll() {
        return null;
    }

    @Override
    public void update(UserDto entity) {

    }

    @Override
    public void delete(UserDto entity) {

    }

    @Override
    public void close() throws Exception {
        connection.close();
    }
}
