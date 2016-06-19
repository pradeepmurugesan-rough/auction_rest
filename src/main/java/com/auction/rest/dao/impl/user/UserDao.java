package com.auction.rest.dao.impl.user;

import static com.auction.rest.dao.utils.DaoConstants.Query.User.GET_ALL_USERS;
import static com.auction.rest.dao.utils.DaoConstants.Query.User.GET_USER_BY_ID;
import static com.auction.rest.dao.utils.DaoConstants.QueryParameters.ID;

import com.auction.rest.dao.AbstractDao;
import com.auction.rest.exception.AuctionException;
import com.auction.rest.model.User;
import com.auction.rest.util.JsonConverter;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class UserDao extends AbstractDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserDao.class);

    public UserDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Long add(User user) throws AuctionException {
        try {
            getCurrentSession().save(user);
            return user.getId();
        } catch (Exception e) {
            LOGGER.error("Exception While adding user " + JsonConverter.objectToJson(user), e);
            throw new AuctionException(e.getMessage());
        }
    }

    public User getUser(Long id) throws AuctionException {
        try {
            Query query = getCurrentSession().createQuery(GET_USER_BY_ID);
            query.setParameter(ID, id);
            return (User) query.uniqueResult();
        } catch (Exception e) {
            LOGGER.error("Exception While getting user " + id, e);
            throw new AuctionException(e.getMessage());
        }
    }

    public List getUsers() throws AuctionException {
        try {
            Query query = getCurrentSession().createQuery(GET_ALL_USERS);
            return query.list();
        } catch (Exception e) {
            LOGGER.error("Exception While retrieving users ", e);
            throw new AuctionException(e.getMessage());
        }

    }
}
