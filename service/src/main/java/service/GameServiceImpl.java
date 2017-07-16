package service;

import dao.interfaceDao.GameDao;
import dao.interfaceDao.PlatformDao;
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
    @Loggable
    public Long save(Game game) {
         gameDao.save(game);
        return game.getId();
    }

    @Override
    @LoggableAfter
    public List<Game> listGame() {
        return gameDao.findAll();
    }

    @Override
    public Game findById(Long id) {
        Game byId = gameDao.findById(id);
        return byId;
    }

    @Override
    @Loggable
    public Game findByName(String name) {
        Game byName = gameDao.findByName(name);
        return byName;
    }

    @Override
    public void update(Game game) {
        gameDao.update(game);
    }
}
