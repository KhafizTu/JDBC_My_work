package peaksoft.dao;

import peaksoft.model.User;

import java.util.List;

public interface UserDao {
    // crud
    void crateUserTable();
    void saveUser(User user);

    List<User> getAllUsers();

    User getByUser(Long id);
    void updateUser(Long id , User user);
    void cleanTable();
    void dropTable();


}
