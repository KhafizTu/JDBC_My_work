package peaksoft.dao.daoimpl;
import peaksoft.config.Config;
import peaksoft.dao.UserDao;
import peaksoft.model.User;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    @Override
    public void crateUserTable() {
        String sql = "create table if not exists users (" +
                "id serial primary key ," +
                "first_name varchar ," +
                "last_name varchar ," +
                "age int );";

        try (Connection connection = Config.getConnection();
             Statement statement = connection.createStatement()) {

            statement.executeUpdate(sql);
            System.out.println("Table is created ...");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void saveUser(User user) {
        String sql = "insert into users(" +
                "first_name , last_name , age)" +
                "VALUES ( ?,?,?) ";

        try (Connection connection = Config.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setInt(3, user.getAge());
            preparedStatement.executeUpdate();

            System.out.println("User is save !");
        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }
    }

    @Override
    public List<User> getAllUsers() {
        String sql = "select * from users";
        List<User> users = new ArrayList<>();
        try (
                Connection connection = Config.getConnection();
                Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                users.add(new User(
                        resultSet.getLong("id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getInt("age")
                ));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return users;
    }

    @Override
    public User getByUser(Long id) {
        return null;
    }

    @Override
    public void updateUser(Long id, User user) {

    }

    @Override
    public void cleanTable() {
        String sql = "delete from  students";
        try {Connection connection = Config.getConnection();
            Statement statement = connection.createStatement();
            statement.execute(sql);
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void dropTable() {
        String sql = "drop table students";
        try {
            Connection connection = Config.getConnection();
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);

            System.out.println("Table is drop...");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
