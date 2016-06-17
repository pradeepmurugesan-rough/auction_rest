package com.auction.rest.dao.utils;

public class DaoConstants {
    public class Query {
        public class Auction {
            public static final String GET_AUCTION_BY_ID = "FROM Auction where id = :id";
        }

        public class Bid {
            public static final String GET_BID_BY_ID = "FROM Bid where id = :id";
            public static final String GET_BIDS_BY_AUCTION_ID = "FROM Bid where auctionId = :auctionId";
            public static final String GET_BIDS_BY_AUCTION_ID_AND_USER_ID =
                    "FROM Bid where auctionId = :auctionId AND userId = :userId";
        }

        public class Item {
            public static final String GET_ITEM_BY_ID = "FROM Item where id = :id";
        }

        public class User {
            public static final String GET_USER_BY_ID = "FROM User where id = :id";
        }
    }

    public class QueryParameters {
        public static final String ID = "id";
        public static final String AUCTION_ID = "auctionId";
        public static final String USER_ID = "userId";

    }
}
