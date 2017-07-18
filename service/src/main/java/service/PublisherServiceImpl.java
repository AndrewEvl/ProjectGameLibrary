package service;

import dao.interfaceDao.PublisherDao;
import entity.Publisher;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by User on 13.07.2017.
 */
@Service
@Transactional
public class PublisherServiceImpl implements PublisherService {

    private final PublisherDao publisherDao;

    public PublisherServiceImpl(PublisherDao publisherDao) {
        this.publisherDao = publisherDao;
    }

    @Override
    public List<Publisher> findAll() {
        return publisherDao.findAll();
    }

    @Override
    public void save(Publisher publisher) {
        publisherDao.save(publisher);
    }
}
