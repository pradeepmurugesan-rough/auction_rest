package com.auction.rest.dao.impl.bid;

import com.auction.rest.dao.impl.user.UserDaoService;
import com.auction.rest.dao.utils.DaoUtils;
import com.auction.rest.exception.AuctionException;
import com.auction.rest.model.Bid;
import com.auction.rest.model.User;

import java.util.List;

public class BidDaoService {

    private BidDao bidDao;

    public BidDaoService(BidDao bidDao) {
        this.bidDao = bidDao;
    }

    public Long addBid(Bid bid) throws AuctionException {
        bidDao.openCurrentSessionwithTransaction();
        Long id = bidDao.add(bid);
        bidDao.closeCurrentSessionwithTransaction();
        return id;
    }

    public Bid getBid(Long id) throws AuctionException {
        bidDao.openCurrentSession();
        Bid bid = bidDao.getBid(id);
        bidDao.closeCurrentSession();
        return bid;
    }

    public List<Bid> getBidsForAuction(Long auctionId) throws AuctionException {
        bidDao.openCurrentSession();
        List<Bid> bids = bidDao.getBidsOfAuction(auctionId);
        bidDao.closeCurrentSession();
        return bids;
    }

    public Bid getHighestBidOfAuction(Long auctionId, Double price) throws AuctionException {
        bidDao.openCurrentSession();
        Bid bid = bidDao.getHighestBidOfAuction(auctionId, price);
        bidDao.closeCurrentSession();
        return bid;
    }

    public List<Bid> getBidsForUserAndAuction(Long auctionId, Long userId) throws AuctionException {
        bidDao.openCurrentSession();
        List<Bid> bids = bidDao.getBidsOfUserAndAuction(auctionId, userId);
        bidDao.closeCurrentSession();
        return bids;
    }
}
