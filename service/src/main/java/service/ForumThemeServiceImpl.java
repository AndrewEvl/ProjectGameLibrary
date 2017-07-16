package service;

import dao.interfaceDao.ForumThemeDao;
import entity.ForumTheme;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Lino on 16.07.2017.
 */
@Service
@Transactional
public class ForumThemeServiceImpl implements ForumThemService {

    private final ForumThemeDao forumThemeDao;

    public ForumThemeServiceImpl(ForumThemeDao forumThemeDao) {
        this.forumThemeDao = forumThemeDao;
    }

    @Override
    public void save(ForumTheme forumTheme) {
        forumThemeDao.save(forumTheme);
    }

    @Override
    public List<ForumTheme> findAll() {
        return forumThemeDao.findAll();
    }

    @Override
    public ForumTheme findById(Long id) {
        return forumThemeDao.findById(id);
    }
}
