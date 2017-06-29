package dao.daoImpl.reviews;

import dao.common.BaseDaoImpl;
import dao.interfaceDao.reviews.NewsCommentsDao;
import entity.reviews.NewsComment;
import org.springframework.stereotype.Repository;

/**
 * Created by User on 15.06.2017.
 */
@Repository
public class NewsCommentsDaoImpl extends BaseDaoImpl<NewsComment> implements NewsCommentsDao {
}
