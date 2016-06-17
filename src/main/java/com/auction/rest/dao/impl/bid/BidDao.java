package com.auction.rest.dao.impl.bid;

import static com.auction.rest.dao.utils.DaoConstants.Query.Bid.GET_BIDS_BY_AUCTION_ID;
import static com.auction.rest.dao.utils.DaoConstants.Query.Bid.GET_BIDS_BY_AUCTION_ID_AND_USER_ID;
import static com.auction.rest.dao.utils.DaoConstants.Query.Bid.GET_BID_BY_ID;
import static com.auction.rest.dao.utils.DaoConstants.QueryParameters.AUCTION_ID;
import static com.auction.rest.dao.utils.DaoConstants.QueryParameters.ID;
import static com.auction.rest.dao.utils.DaoConstants.QueryParameters.USER_ID;

import com.auction.rest.dao.AbstractDao;
import com.auction.rest.model.Bid;
import org.hibernate.Query;
import org.hibernate.SessionFactory;

import java.util.List;


public class BidDao extends AbstractDao {
    public BidDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Long add(Bid bid) {
        getCurrentSession().save(bid);
        return bid.getId();
    }

    public Bid getBid(Long id) {
        Query query = getCurrentSession().createQuery(GET_BID_BY_ID);
        query.setParameter(ID, id);
        return (Bid) query.uniqueResult();
    }

    public List<Bid> getBidsOfAuction(Long auctionId) {
        Query query = getCurrentSession().createQuery(GET_BIDS_BY_AUCTION_ID);
        query.setParameter(AUCTION_ID, auctionId);
        return query.list();
    }

    public List<Bid> getBidsOfUserAndAuction(Long auctionId, Long userId) {
        Query query = getCurrentSession().createQuery(GET_BIDS_BY_AUCTION_ID_AND_USER_ID);
        query.setParameter(AUCTION_ID, auctionId);
        query.setParameter(USER_ID, userId);
        return query.list();
    }
}
