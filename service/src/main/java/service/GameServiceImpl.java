package service;

import dao.interfaceDao.GameDao;
import entity.Game;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Lino on 02.07.2017.
 */
@Service
@Transactional
public class GameServiceImpl implements GameService {

    private final GameDao gameDao;

    public GameServiceImpl(GameDao gameDao) {
        this.gameDao = gameDao;
    }

    @Override
    public void save(Game game) {
         gameDao.save(game);
    }

    @Override
    public List<Game> listGame() {
        return gameDao.findAll();
    }


}
