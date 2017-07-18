package service;

import entity.Publisher;

import java.util.List;

/**
 * Created by User on 13.07.2017.
 */
public interface PublisherService {

    List<Publisher> findAll();

    void save (Publisher publisher);
}
