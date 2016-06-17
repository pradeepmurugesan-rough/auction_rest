package com.auction.rest.dao.impl.user;

import static com.auction.rest.dao.utils.DaoConstants.Query.User.GET_USER_BY_ID;
import static com.auction.rest.dao.utils.DaoConstants.QueryParameters.ID;

import com.auction.rest.dao.AbstractDao;
import com.auction.rest.model.User;
import org.hibernate.Query;
import org.hibernate.SessionFactory;

public class UserDao extends AbstractDao {

    public UserDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Long add(User user) {
        getCurrentSession().save(user);
        return user.getId();
    }

    public User getUser(Long id) {
        Query query = getCurrentSession().createQuery(GET_USER_BY_ID);
        query.setParameter(ID, id);
        return (User) query.uniqueResult();
    }
}
