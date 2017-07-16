package service;

import entity.News;

import java.util.List;

/**
 * Created by Lino on 01.07.2017.
 */
public interface NewsService {

    List<News> getAll();

    News findById (Long id);

    void save(News news);
}
