package com.auction.rest.testutils.data.auction;

import com.auction.rest.model.Auction;

public class AuctionDaoData {
    public static Auction getAuction() {
        Auction auction = new Auction();
        auction.setChannel("rolex");
        auction.setIsLive(false);
        auction.setHighestBid(0.0);
        return auction;
    }
}
