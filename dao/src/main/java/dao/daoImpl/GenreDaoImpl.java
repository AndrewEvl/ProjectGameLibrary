package dao.daoImpl;

import dao.interfaceDao.GenreDao;
import dao.common.BaseDaoImpl;
import entity.Genre;
import org.springframework.stereotype.Repository;

/**
 * Created by User on 15.06.2017.
 */
@Repository
public class GenreDaoImpl extends BaseDaoImpl<Genre> implements GenreDao {
}
