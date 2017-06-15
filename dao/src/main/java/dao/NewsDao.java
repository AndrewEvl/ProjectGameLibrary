package dao;

import entity.News;

/**
 * Created by User on 15.06.2017.
 */
public class NewsDao extends BaseDao<News> {
    public NewsDao() {
        super(News.class);
    }
}
