package controller;

import entity.Game;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import service.GameService;

import java.util.List;

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

    @GetMapping("/game-info{gameId}")
    public String gameInfoGet (Game game, Model model){
        Game id = gameService.findById(game.getId());
        model.addAttribute("gameId",id);
        return "/game-html/game-info{gameId}";
    }

    @GetMapping("/game-save")
    public String gameSaveGet (){
        return "game-html/game-save";
    }

    @PostMapping("/game-save")
    public String gameSavePost(Game game, Model model){
        gameService.save(game);
        model.addAttribute("game",game);
        Long id = game.getId();
        model.addAttribute("gameId",id );
        return "redirect:/game-info{gameId}";
    }

}
