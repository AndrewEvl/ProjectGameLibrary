package service;

import dao.interfaceDao.GameCollectionDao;
import entity.GameCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Lino on 16.07.2017.
 */
@Service
@Transactional
public class GameCollectionServiceImpl implements GameCollectionService {

    private final GameCollectionDao gameCollectionDao;

    @Autowired
    public GameCollectionServiceImpl(GameCollectionDao gameCollectionDao) {
        this.gameCollectionDao = gameCollectionDao;
    }

    @Override
    public void save(GameCollection gameCollection) {
        gameCollectionDao.save(gameCollection);
    }

    @Override
    public List<GameCollection> findAll() {
        return gameCollectionDao.findAll();
    }

    @Override
    public GameCollection findById(Long id) {
        return gameCollectionDao.findById(id);
    }
}
