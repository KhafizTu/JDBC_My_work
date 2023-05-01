package peaksoft.service;

import peaksoft.model.User;

import java.util.List;

public interface UserService {
    void createUserTable();

    void saveUser(User user);

    List<User> getAllUsers();

    User getByUser(Long id);

    void updateUser(Long id, User user);

    void cleanTable();

    void dropTable();
}
