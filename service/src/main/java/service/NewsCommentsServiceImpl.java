package service;

import dao.interfaceDao.reviews.NewsCommentsDao;
import entity.reviews.NewsComment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by User on 16.07.2017.
 */
@Service
@Transactional
public class NewsCommentsServiceImpl implements NewsCommentsService {

    private final NewsCommentsDao newsCommentsDao;

    @Autowired
    public NewsCommentsServiceImpl(NewsCommentsDao newsCommentsDao) {
        this.newsCommentsDao = newsCommentsDao;
    }

    @Override
    public void save(NewsComment newsComment) {
        newsCommentsDao.save(newsComment);
    }
}
