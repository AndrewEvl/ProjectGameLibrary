package controller;

import entity.Game;
import entity.Genre;
import entity.Platform;
import entity.reviews.ReviewGame;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import service.GameService;
import service.GenreService;

import java.util.List;
import java.util.Set;

/**
 * Created by Lino on 02.07.2017.
 */
@Controller
public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @ModelAttribute("game")
    public Game game(){
        return new Game();
    }

    @GetMapping("/game-list")
    public String gameListGet (Model model){
        List<Game> gameList = gameService.listGame();
        model.addAttribute("allGame", gameList);
        return "game-html/game-list";
    }

    @GetMapping("/game-info")
    public String gameInfoGet (){
        return "game-html/game-info";
    }

    @PostMapping("/game-info")
    public String gameInfoPost (Game game, Model model){
        Game id = gameService.findById(game.getId());
        model.addAttribute("gameId",id);
        return "/game-html/game-info";
    }

    @GetMapping("/game-save")
    public String gameSaveGet (){
        return "game-html/game-save";
    }

    @PostMapping("/game-save")
    public String gameSavePost(Game game, Model model){
        gameService.save(game);
        model.addAttribute("gameInfo",game);
        Long id = game.getId();
        model.addAttribute("gameId",id );
        return "redirect:/game-info{gameId}";
    }

    @GetMapping("/findByNameGame")
    public String findByNameGameGet() {
        return "game-html/game-by-name";
    }

    @PostMapping("/findByNameGame")
    public String findByNamePost (String name, Model model){
        model.addAttribute("name", name);
        return "redirect:/game-info/{name}";
    }

    @GetMapping("/game-info/{name}")
    public String findByNameGamePost (@PathVariable ("name") String name, Model model){
        Game byName = gameService.findByName(name);
        Set<ReviewGame> reviews = byName.getReviews();
        Set<Platform> platform = byName.getPlatform();
        model.addAttribute("game", byName);
        model.addAttribute("platform", platform);
        model.addAttribute("reviews", reviews);
        return "game-html/game-info";
    }
}
