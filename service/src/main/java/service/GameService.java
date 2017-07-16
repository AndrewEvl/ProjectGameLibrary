package service;

import entity.Game;

import java.util.List;

/**
 * Created by Lino on 02.07.2017.
 */
public interface GameService {

    Long save(Game game);

    List<Game> listGame ();

    Game findById (Long id);

    Game findByName (String name);

    void update (Game game);
}
