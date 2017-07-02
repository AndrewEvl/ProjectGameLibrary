package controller;

import entity.Game;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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


}
