package dao.reviews;

import dao.common.BaseDao;
import entity.reviews.NewsComment;

/**
 * Created by User on 15.06.2017.
 */
public class NewsCommentsDao extends BaseDao<NewsComment> {
    public NewsCommentsDao() {
        super(NewsComment.class);
    }
}
