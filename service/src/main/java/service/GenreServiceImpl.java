package service;

import dao.interfaceDao.GenreDao;
import entity.Genre;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by User on 04.07.2017.
 */
@Service
public class GenreServiceImpl implements GenreService {

    private final GenreDao genreDao;

    public GenreServiceImpl(GenreDao genreDao) {
        this.genreDao = genreDao;
    }

    @Override
    public List<Genre> findAll() {
        List<Genre> genres = genreDao.findAll();
        return genres;
    }
}
