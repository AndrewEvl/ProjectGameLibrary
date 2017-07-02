package service;

import dao.interfaceDao.NewsDao;
import entity.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Lino on 01.07.2017.
 */
@Service
@Transactional
public class NewsServiceImpl implements NewsService {

    private final NewsDao newsDao;

    @Autowired
    public NewsServiceImpl(NewsDao newsDao) {
        this.newsDao = newsDao;
    }

    @Override
    public List<News> getAll() {
        return newsDao.findAll();
    }
}