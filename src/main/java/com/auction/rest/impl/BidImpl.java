package com.auction.rest.impl;

import com.auction.rest.dao.impl.bid.BidDaoService;
import com.auction.rest.model.Bid;
import com.auction.rest.model.Id;

import java.util.List;


public class BidImpl {
    BidDaoService bidDaoService;

    public BidImpl(BidDaoService bidDaoService) {
        this.bidDaoService = bidDaoService;
    }

    public Id addBid(Bid bid) {
        Long id = this.bidDaoService.addBid(bid);
        return new Id(id);
    }

    public Bid getBid(Long id) {
        Bid bid = this.bidDaoService.getBid(id);
        return bid;
    }

    public List<Bid> getBidsForAucion(Long auctionId) {
        List<Bid> bids = this.bidDaoService.getBidsForAuction(auctionId);
        return bids;
    }

    public List<Bid> getBidsForUserAndAuction(Long auctionId, Long userId) {
        List<Bid> bids = this.bidDaoService.getBidsForUserAndAuction(auctionId, userId);
        return bids;
    }
}
