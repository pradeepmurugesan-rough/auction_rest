package com.auction.rest.dao.impl.user;

import com.auction.rest.model.User;
import com.auction.rest.testutils.HibernateTestConfig;
import com.auction.rest.testutils.data.user.UserDaoData;
import org.hibernate.SessionFactory;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class UserDaoTest {
    private static SessionFactory factory;
    private static User user;

    @BeforeClass
    public static void setUpDb() {
        factory = new HibernateTestConfig().getUnitTestSessionFactory();
        user = UserDaoData.getUser();
        UserDao userDao = new UserDao(factory);
        userDao.openCurrentSessionwithTransaction();
        userDao.add(user);
        userDao.closeCurrentSessionwithTransaction();
    }

    @Test
    public void testInsert() {
        user = UserDaoData.getUser();
        UserDao userDao = new UserDao(factory);
        userDao.openCurrentSessionwithTransaction();
        userDao.add(user);
        User inserteduser = userDao.getUser(user.getId());
        userDao.closeCurrentSessionwithTransaction();
        Assert.assertNotNull(inserteduser);
        Assert.assertEquals(inserteduser.getLocation(), user.getLocation());
    }

    @Test
    public void testRetrive() {
        UserDao userDao = new UserDao(factory);
        userDao.openCurrentSessionwithTransaction();
        User inserteduser = userDao.getUser(Long.valueOf(1));
        userDao.closeCurrentSessionwithTransaction();
        Assert.assertNotNull(inserteduser);
        Assert.assertEquals(inserteduser.getId(), Long.valueOf(1));
    }
}
