package service;

import entity.GameCollection;

import java.util.List;

/**
 * Created by Lino on 16.07.2017.
 */
public interface GameCollectionService {

    void save(GameCollection gameCollection);

    List<GameCollection> findAll();

    GameCollection findById(Long id);
}
