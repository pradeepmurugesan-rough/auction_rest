package com.auction.rest.dao.impl.item;

import com.auction.rest.exception.AuctionException;
import com.auction.rest.model.Item;
import com.auction.rest.testutils.HibernateTestConfig;
import com.auction.rest.testutils.data.item.ItemDaoData;
import org.hibernate.SessionFactory;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class ItemDaoTest {
    private static SessionFactory factory;
    private static Item item;

    @BeforeClass
    public static void setUpDb() throws AuctionException {
        factory = new HibernateTestConfig().getUnitTestSessionFactory();
        item = ItemDaoData.getItem();
        ItemDao itemDao = new ItemDao(factory);
        itemDao.openCurrentSessionwithTransaction();
        itemDao.add(item);
        itemDao.closeCurrentSessionwithTransaction();
    }

    @Test
    public void testInsert() throws AuctionException {
        item = ItemDaoData.getItem();
        ItemDao itemDao = new ItemDao(factory);
        itemDao.openCurrentSessionwithTransaction();
        itemDao.add(item);
        Item insertedItem = itemDao.getItem(item.getId());
        itemDao.closeCurrentSessionwithTransaction();
        Assert.assertNotNull(insertedItem);
        Assert.assertEquals(insertedItem.getDescription(), item.getDescription());
    }

    @Test
    public void testRetrive() throws AuctionException {
        ItemDao itemDao = new ItemDao(factory);
        itemDao.openCurrentSessionwithTransaction();
        Item insertedItem = itemDao.getItem(Long.valueOf(1));
        itemDao.closeCurrentSessionwithTransaction();
        Assert.assertNotNull(insertedItem);
        Assert.assertEquals(insertedItem.getId(), Long.valueOf(1));
    }
}
