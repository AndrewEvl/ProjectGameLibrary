package dao.daoImpl.reviews;

import dao.common.BaseDaoImpl;
import dao.reviews.ForumCommentsDao;
import entity.reviews.ForumComments;
import org.springframework.stereotype.Repository;

/**
 * Created by User on 15.06.2017.
 */
@Repository
public class ForumCommentsDaoImpl extends BaseDaoImpl<ForumComments> implements ForumCommentsDao {
}
