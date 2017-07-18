package service;

import entity.reviews.ForumComments;

import java.util.List;

/**
 * Created by Lino on 16.07.2017.
 */
public interface ForumCommentsService {

    void save(ForumComments forumComments);

    List<ForumComments> findAll();

    ForumComments findById(Long id);

}
