package dao;

import entity.Genre;

/**
 * Created by User on 15.06.2017.
 */
public class GenreDao extends BaseDao<Genre> {
    public GenreDao() {
        super(Genre.class);
    }
}
