package service;

import dao.interfaceDao.reviews.ForumCommentsDao;
import entity.reviews.ForumComments;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Lino on 16.07.2017.
 */
@Service
@Transactional
public class ForumCommentsServiceImpl implements ForumCommentsService {

    private final ForumCommentsDao forumCommentsDao;

    public ForumCommentsServiceImpl(ForumCommentsDao forumCommentsDao) {
        this.forumCommentsDao = forumCommentsDao;
    }

    @Override
    public void save(ForumComments forumComments) {
        forumCommentsDao.save(forumComments);
    }

    @Override
    public List<ForumComments> findAll() {
        return forumCommentsDao.findAll();
    }

    @Override
    public ForumComments findById(Long id) {
        return forumCommentsDao.findById(id);
    }
}
