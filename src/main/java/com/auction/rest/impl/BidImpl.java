package com.auction.rest.impl;

import static com.auction.rest.util.Constants.WS_BID_UPDATED;

import com.auction.rest.dao.impl.auction.AuctionDaoService;
import com.auction.rest.dao.impl.bid.BidDaoService;
import com.auction.rest.dao.impl.user.UserDaoService;
import com.auction.rest.dao.utils.DaoUtils;
import com.auction.rest.exception.AuctionException;
import com.auction.rest.model.Auction;
import com.auction.rest.model.Bid;
import com.auction.rest.model.Id;
import com.auction.rest.model.User;
import com.auction.rest.util.JsonConverter;
import com.auction.websocket.WsClient;

import java.io.IOException;
import java.util.List;


public class BidImpl {
    BidDaoService bidDaoService;

    public BidImpl(BidDaoService bidDaoService) {
        this.bidDaoService = bidDaoService;
    }

    public Id addBid(Bid bid) throws AuctionException {
        final Long id = this.bidDaoService.addBid(bid);
        AuctionDaoService auctionDaoService = DaoUtils.getAuctionService();
        Auction auction = auctionDaoService.getAuction(bid.getAuctionId());
        auction.setHighestBid(bid.getPrice());
        auctionDaoService.updateAuction(auction);
        WsClient.getInstance().emit(WS_BID_UPDATED, JsonConverter.objectToJson(this.getBid(bid.getId())));
        return new Id(id);
    }

    public Bid getBid(Long id) throws AuctionException {
        Bid bid = this.bidDaoService.getBid(id);
        UserDaoService userDaoService = DaoUtils.getUserService();
        User user = userDaoService.getUser(bid.getUserId());
        bid.setUser(user);
        return bid;
    }

    public List<Bid> getBidsForAucion(Long auctionId) throws AuctionException {
        List<Bid> bids = this.bidDaoService.getBidsForAuction(auctionId);
        return bids;
    }

    public List<Bid> getBidsForUserAndAuction(Long auctionId, Long userId) throws AuctionException {
        List<Bid> bids = this.bidDaoService.getBidsForUserAndAuction(auctionId, userId);
        return bids;
    }
}
