package service;

import entity.Game;

import java.util.List;

/**
 * Created by Lino on 02.07.2017.
 */
public interface GameService {

    void save(Game game);

    List<Game> listGame ();
}
