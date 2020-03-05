package com.team.myproject.service.impl;

import com.team.myproject.dao.UserDao;
import com.team.myproject.dao.impl.UserDaoimpl;
import com.team.myproject.entity.User;
import com.team.myproject.service.UserService;

import java.util.List;

public class UserServiceimpl implements UserService {
    UserDao userDao=new UserDaoimpl();
    @Override
    public int addInfo(User user) {
        return userDao.addInfo(user);
    }

    @Override
    public int deleteInfo(int userId) {
        return userDao.deleteInfo(userId);
    }

    @Override
    public int updateInfo(User user) {
        return userDao.updateInfo(user);
    }

    @Override
    public User getInfo(int userId) {
        return userDao.getInfo(userId);
    }

    @Override
    public List<User> getAllInfo(int page, int pageSize, int cardsId, String name) {
        return userDao.getAllInfo(page,pageSize,cardsId,name);
    }

    @Override
    public int getInfoPages(int pageSize, int cardsId, String name) {
        return userDao.getInfoPages(pageSize,cardsId,name);
    }
}
