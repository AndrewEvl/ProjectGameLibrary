package dao.reviews;

import dao.common.BaseDao;
import entity.reviews.ForumComments;

/**
 * Created by User on 15.06.2017.
 */
public class ForumCommentsDao extends BaseDao<ForumComments> {
    public ForumCommentsDao() {
        super(ForumComments.class);
    }
}
