package service;

import entity.Game;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Lino on 16.07.2017.
 */
public class GameServiceImplTest extends BaseTest {

    @Autowired
    private GameService gameService;

    @Test
    public void save() throws Exception {
        Game game = new Game();
        game.setName("test");
        gameService.save(game);
    }

    @Test
    public void listGame() throws Exception {
        Game game = new Game();
        game.setName("test");
        gameService.save(game);
        List<Game> games = gameService.listGame();

    }

    @Test
    public void findById() throws Exception {
        Game game = new Game();
        game.setId(1L);
        gameService.save(game);
        Game byId = gameService.findById(1L);
    }

    @Test
    public void findByName() throws Exception {
        Game game = new Game();
        game.setName("test");
        gameService.save(game);
        gameService.findByName("test");
    }

    @Test
    public void update() throws Exception {
        Game game = new Game();
        game.setName("test");
        gameService.save(game);
        game.setName("update");
        gameService.update(game);
    }

}