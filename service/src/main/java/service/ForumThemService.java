package service;

import entity.ForumTheme;

import java.util.List;

/**
 * Created by Lino on 16.07.2017.
 */
public interface ForumThemService {

    void save(ForumTheme forumTheme);

    List<ForumTheme> findAll();

    ForumTheme findById(Long id);
}
