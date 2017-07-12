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
    private final PlatformDao platformDao;

    public GameServiceImpl(GameDao gameDao, PlatformDao platformDao) {
        this.gameDao = gameDao;
        this.platformDao = platformDao;
    }

    @Override
    public Long save(Game game) {
         gameDao.save(game);
        return game.getId();
    }

    @Override
    public List<Game> listGame() {
        return gameDao.findAll();
    }

    @Override
    public Game findById(Long id) {
        Game byId = gameDao.findById(id);
        return byId;
    }

    @Override
    public Game findByName(String name) {
        Game byName = gameDao.findByName(name);
        return byName;
    }
}
