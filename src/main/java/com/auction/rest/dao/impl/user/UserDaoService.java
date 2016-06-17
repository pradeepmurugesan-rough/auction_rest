package com.auction.rest.dao.impl.user;

import com.auction.rest.model.User;

public class UserDaoService {
    private UserDao userDao;

    public UserDaoService(UserDao userDao) {
        this.userDao = userDao;
    }

    public Long addUser(User user) {
        this.userDao.openCurrentSessionwithTransaction();
        Long id = this.userDao.add(user);
        this.userDao.closeCurrentSessionwithTransaction();
        return id;
    }

    public User getUser(Long id) {
        this.userDao.openCurrentSession();
        User user = this.userDao.getUser(id);
        this.userDao.closeCurrentSession();
        return user;
    }
}
