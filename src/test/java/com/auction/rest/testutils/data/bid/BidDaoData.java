package com.auction.rest.testutils.data.bid;

import com.auction.rest.model.Bid;

import java.util.ArrayList;
import java.util.List;

public class BidDaoData {
    public static Bid getBid() {
        Bid bid = new Bid();
        bid.setPrice(1.2);
        return bid;
    }

    public static List<Bid> getBids() {
        List<Bid> bids = new ArrayList<Bid>();
        for(int i = 10; i < 20; i++) {
            Bid bid = new Bid();
            bid.setPrice(new Double(i));
            bid.setAuctionId(new Long(i % 2));
            bid.setUserId(new Long((i%2) + 1));
            bids.add(bid);
        }
        return bids;
    }
}
