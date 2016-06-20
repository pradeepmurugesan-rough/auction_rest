package com.auction.rest.dao.impl.bid;

import static com.auction.rest.dao.utils.DaoConstants.Query.Bid.GET_BIDS_BY_AUCTION_ID;
import static com.auction.rest.dao.utils.DaoConstants.Query.Bid.GET_BIDS_BY_AUCTION_ID_AND_USER_ID;
import static com.auction.rest.dao.utils.DaoConstants.Query.Bid.GET_BID_BY_AUCTION_ID_AND_PRICE;
import static com.auction.rest.dao.utils.DaoConstants.Query.Bid.GET_BID_BY_ID;
import static com.auction.rest.dao.utils.DaoConstants.QueryParameters.AUCTION_ID;
import static com.auction.rest.dao.utils.DaoConstants.QueryParameters.ID;
import static com.auction.rest.dao.utils.DaoConstants.QueryParameters.PRICE;
import static com.auction.rest.dao.utils.DaoConstants.QueryParameters.USER_ID;

import com.auction.rest.dao.AbstractDao;
import com.auction.rest.exception.AuctionException;
import com.auction.rest.model.Bid;
import com.auction.rest.util.JsonConverter;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;


public class BidDao extends AbstractDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(BidDao.class);

    public BidDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Long add(Bid bid) throws AuctionException {
        try {
            getCurrentSession().save(bid);
            return bid.getId();
        } catch (Exception e) {
            LOGGER.error("Exception While adding bid " + JsonConverter.objectToJson(bid), e);
            throw new AuctionException(e.getMessage());
        }
    }

    public Bid getBid(Long id) throws AuctionException {
        try {
            Query query = getCurrentSession().createQuery(GET_BID_BY_ID);
            query.setParameter(ID, id);
            return (Bid) query.uniqueResult();
        } catch (Exception e) {
            LOGGER.error("Exception While adding bid " + id, e);
            throw new AuctionException(e.getMessage());
        }
    }

    public List<Bid> getBidsOfAuction(Long auctionId) throws AuctionException {
        try {
            Query query = getCurrentSession().createQuery(GET_BIDS_BY_AUCTION_ID);
            query.setParameter(AUCTION_ID, auctionId);
            return query.list();
        } catch (Exception e) {
            LOGGER.error("Exception While retrieving bids of Auction " + auctionId, e);
            throw new AuctionException(e.getMessage());
        }
    }

    public Bid getHighestBidOfAuction(Long auctionId, Double price) throws AuctionException {
        try {
            Query query = getCurrentSession().createQuery(GET_BID_BY_AUCTION_ID_AND_PRICE);
            query.setParameter(AUCTION_ID, auctionId);
            query.setParameter(PRICE, price);
            return (Bid) query.uniqueResult();
        } catch (Exception e) {
            LOGGER.error("Exception While retrieving bids of Auction " + auctionId, e);
            throw new AuctionException(e.getMessage());
        }
    }


    public List<Bid> getBidsOfUserAndAuction(Long auctionId, Long userId) throws AuctionException {
        try {
            Query query = getCurrentSession().createQuery(GET_BIDS_BY_AUCTION_ID_AND_USER_ID);
            query.setParameter(AUCTION_ID, auctionId);
            query.setParameter(USER_ID, userId);
            return query.list();
        } catch (Exception e) {
            LOGGER.error("Exception While retrieving bids of Auction " + auctionId + " and user " + userId, e);
            throw new AuctionException(e.getMessage());
        }
    }
}
