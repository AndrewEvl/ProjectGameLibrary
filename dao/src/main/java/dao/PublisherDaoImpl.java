package dao;

import dao.common.BaseDaoImpl;
import entity.Publisher;

/**
 * Created by User on 15.06.2017.
 */
public class PublisherDaoImpl extends BaseDaoImpl<Publisher> {

    public PublisherDaoImpl() {
        super(Publisher.class);
    }
}
