package com.auction.websocket;

import com.auction.rest.exception.AuctionException;
import com.auction.rest.model.Bid;
import com.auction.rest.model.User;
import com.auction.rest.util.JsonConverter;
import io.socket.client.Socket;

import java.io.IOException;

public class AuctionWsMain {
    public static void main(String[] args) throws InterruptedException {
        final Socket socket = WsClient.getInstance();
        User user = new User();
        user.setLocation("INDIA");
        user.setName("Sapna");
        Bid bid = new Bid();
        bid.setPrice(180.00);
        bid.setUser(user);
        try {
            socket.emit("bidUpdated", JsonConverter.objectToJson(bid));
        } catch (AuctionException e) {
            e.printStackTrace();
        }
        Thread.sleep(5000);
        socket.disconnect();
    }
}
