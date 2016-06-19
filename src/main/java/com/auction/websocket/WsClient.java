package com.auction.websocket;

import com.auction.rest.config.Environment;
import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;

import java.net.URISyntaxException;

public class WsClient {

    private static Socket socket;

    public static Socket getInstance() {
        try {
            if (socket == null || !socket.connected()) {
                socket = createInstance();
            }
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return socket;
    }

    private static Socket createInstance() throws URISyntaxException {
        socket = IO.socket(Environment.getInstance().getWebSocketUrl());
        socket.on(Socket.EVENT_CONNECT, new Emitter.Listener() {

            @Override
            public void call(Object... args) {
                System.out.println("Connection successful");
                //socket.disconnect();
            }

        })
            .on("event", new Emitter.Listener() {

                @Override
                public void call(Object... args) {}

            })
            .on(Socket.EVENT_DISCONNECT, new Emitter.Listener() {

                @Override
                public void call(Object... args) {
                    System.out.println("Connection Terminated");
                }

            });
        socket.connect();
        return socket;
    }


}
