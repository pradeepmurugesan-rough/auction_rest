package com.auction.rest.dao.impl.item;

import static com.auction.rest.dao.utils.DaoConstants.Query.Item.GET_ITEM_BY_ID;
import static com.auction.rest.dao.utils.DaoConstants.QueryParameters.ID;

import com.auction.rest.dao.AbstractDao;
import com.auction.rest.exception.AuctionException;
import com.auction.rest.model.Item;
import com.auction.rest.util.JsonConverter;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ItemDao extends AbstractDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(ItemDao.class);

    public ItemDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Long add(Item item) throws AuctionException {
        try {
            getCurrentSession().save(item);
            return item.getId();
        } catch (Exception e) {
            LOGGER.error("Exception While adding item " + JsonConverter.objectToJson(item), e);
            throw new AuctionException(e.getMessage());
        }
    }

    public Item getItem(Long id) throws AuctionException {
        try {
            Query query = getCurrentSession().createQuery(GET_ITEM_BY_ID);
            query.setParameter(ID, id);
            return (Item) query.uniqueResult();
        } catch (Exception e) {
            LOGGER.error("Exception While getting item " + id, e);
            throw new AuctionException(e.getMessage());
        }
    }
}
