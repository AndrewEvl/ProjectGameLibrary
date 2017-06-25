package dao.interfaceDao;

import dao.common.BaseDao;
import entity.Game;
import entity.Genre;
import entity.Platform;
import entity.Publisher;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by Lino on 25.06.2017.
 */
public interface GameDao extends BaseDao<Game> {

    Game findByName (String name);

    List<Game> findByReleaseDay (LocalDate localDate);

    List<Game> findByPublisher (Publisher publisher);

    List<Game> findByGenre (Genre genre);

    List<Game> findByPlatform (Platform platform);
}
