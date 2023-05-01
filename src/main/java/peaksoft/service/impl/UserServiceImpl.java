package peaksoft.service.impl;

import peaksoft.dao.UserDao;
import peaksoft.dao.daoimpl.UserDaoImpl;
import peaksoft.model.User;
import peaksoft.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
     UserDaoImpl userDao = new UserDaoImpl();
    @Override
    public void createUserTable() {
    userDao.crateUserTable();
    }

    @Override
    public void saveUser(User user) {
    userDao.saveUser(new User());
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
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

    }

    @Override
    public void dropTable() {

    }
}
