package com.auction.rest.testutils.data.item;

import com.auction.rest.model.Item;

public class ItemDaoData {
    public static Item getItem() {
        Item item = new Item();
        item.description("This is a item description");
        item.setName("Rolex");
        item.setStartingPrice(1.0);
        return item;
    }
}
