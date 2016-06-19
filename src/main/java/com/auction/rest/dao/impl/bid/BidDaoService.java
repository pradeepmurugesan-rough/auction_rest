package com.auction.rest.dao.impl.bid;

import com.auction.rest.dao.impl.user.UserDao;
import com.auction.rest.dao.impl.user.UserDaoService;
import com.auction.rest.dao.utils.DaoUtils;
import com.auction.rest.model.Bid;
import com.auction.rest.model.User;

import java.util.List;

public class BidDaoService {

    private BidDao bidDao;

    public BidDaoService(BidDao bidDao) {
        this.bidDao = bidDao;
    }

    public Long addBid(Bid bid) {
        bidDao.openCurrentSessionwithTransaction();
        Long id = bidDao.add(bid);
        bidDao.closeCurrentSessionwithTransaction();
        return id;
    }

    public Bid getBid(Long id) {
        bidDao.openCurrentSession();
        Bid bid = bidDao.getBid(id);
        UserDaoService userDaoService = DaoUtils.getUserService();
        User user = userDaoService.getUser(bid.getUserId());
        bid.setUser(user);
        bidDao.closeCurrentSession();
        return bid;
    }

    public List<Bid> getBidsForAuction(Long auctionId) {
        bidDao.openCurrentSession();
        List<Bid> bids = bidDao.getBidsOfAuction(auctionId);
        bidDao.closeCurrentSession();
        return bids;
    }

    public List<Bid> getBidsForUserAndAuction(Long auctionId, Long userId) {
        bidDao.openCurrentSession();
        List<Bid> bids = bidDao.getBidsOfUserAndAuction(auctionId, userId);
        bidDao.closeCurrentSession();
        return bids;
    }
}
