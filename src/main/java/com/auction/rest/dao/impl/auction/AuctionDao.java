package com.auction.rest.dao.impl.auction;

import static com.auction.rest.dao.utils.DaoConstants.Query.Auction.GET_AUCTION_BY_ID;
import static com.auction.rest.dao.utils.DaoConstants.QueryParameters.ID;

import com.auction.rest.dao.AbstractDao;
import com.auction.rest.model.Auction;
import org.hibernate.Query;
import org.hibernate.SessionFactory;

public class AuctionDao extends AbstractDao{

    public AuctionDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Long add(Auction auction) {
        getCurrentSession().save(auction);
        return auction.getId();
    }

    public Auction getAuction(Long id) {
        Query query = getCurrentSession().createQuery(GET_AUCTION_BY_ID);
        query.setParameter(ID, id);
        return (Auction) query.uniqueResult();
    }

    public Auction updateAuction(Auction auction) {
        getCurrentSession().update(auction);
        return auction;
    }
}
