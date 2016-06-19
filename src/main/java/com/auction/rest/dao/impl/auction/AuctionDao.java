package com.auction.rest.dao.impl.auction;

import static com.auction.rest.dao.utils.DaoConstants.Query.Auction.GET_AUCTION_BY_ID;
import static com.auction.rest.dao.utils.DaoConstants.QueryParameters.ID;

import com.auction.rest.dao.AbstractDao;
import com.auction.rest.exception.AuctionException;
import com.auction.rest.model.Auction;
import com.auction.rest.util.JsonConverter;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AuctionDao extends AbstractDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuctionDao.class);

    public AuctionDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Long add(Auction auction) throws AuctionException {
        try {
            getCurrentSession().save(auction);
            return auction.getId();
        } catch (Exception e) {
            LOGGER.error("Exception While adding auction " + JsonConverter.objectToJson(auction), e);
            throw new AuctionException(e.getMessage());
        }
    }

    public Auction getAuction(Long id) throws AuctionException {
        try {
            Query query = getCurrentSession().createQuery(GET_AUCTION_BY_ID);
            query.setParameter(ID, id);
            return (Auction) query.uniqueResult();
        } catch (Exception e) {
            LOGGER.error("Exception While getting auction " + id , e);
            throw new AuctionException(e.getMessage());
        }
    }

    public Auction updateAuction(Auction auction) throws AuctionException {
        try {
            getCurrentSession().update(auction);
            return auction;
        } catch (Exception e) {
            LOGGER.error("Exception While updating auction " + JsonConverter.objectToJson(auction) , e);
            throw new AuctionException(e.getMessage());
        }
    }
}
