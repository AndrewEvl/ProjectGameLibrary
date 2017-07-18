package service;

import entity.Game;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

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
        assertEquals(gameService.findByName("test"),game);
    }

    @Test
    public void listGame() throws Exception {
        Game game = new Game();
        game.setName("test");
        gameService.save(game);
        List<Game> games = gameService.listGame();
        assertNotNull(games);

    }

    @Test
    public void findById() throws Exception {
        Game game = new Game();
        gameService.save(game);
        Game byId = gameService.findById(game.getId());
        assertEquals(byId.getId(),game.getId());
    }

    @Test
    public void findByName() throws Exception {
        Game game = new Game();
        game.setName("test");
        gameService.save(game);
        Game byName = gameService.findByName("test");
        assertEquals(byName.getName(),game.getName());
    }

    @Test
    public void update() throws Exception {
        Game game = new Game();
        game.setName("test");
        gameService.save(game);
        game.setName("update");
        gameService.update(game);
        Game update = gameService.findByName("update");
        assertEquals(update.getName(),"update");
    }

}