package dao.reviews;

import dao.common.BaseDaoImpl;
import entity.reviews.NewsComment;

/**
 * Created by User on 15.06.2017.
 */
public class NewsCommentsDaoImpl extends BaseDaoImpl<NewsComment> {
    public NewsCommentsDaoImpl() {
        super(NewsComment.class);
    }
}
