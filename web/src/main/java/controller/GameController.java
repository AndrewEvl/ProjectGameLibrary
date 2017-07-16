package controller;

import dto.GameDto;
import entity.*;
import entity.reviews.ReviewGame;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import service.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Lino on 02.07.2017.
 */
@Controller
public class GameController {

    private final GameService gameService;
    private final GenreService genreService;
    private final PublisherService publisherService;
    private final DeveloperService developerService;
    private final PlatformService platformService;

    public GameController(GameService gameService, GenreService genreService, PublisherService publisherService, DeveloperService developerService, PlatformService platformService) {
        this.gameService = gameService;
        this.genreService = genreService;
        this.publisherService = publisherService;
        this.developerService = developerService;
        this.platformService = platformService;
    }

    @ModelAttribute("game")
    public Game game() {
        return new Game();
    }

    @ModelAttribute("gameDto")
    public GameDto gameDto() {
        return new GameDto();
    }

    @GetMapping("/game-list")
    public String gameListGet(Model model) {
        List<Game> gameList = gameService.listGame();
        model.addAttribute("allGames", gameList);
        return "game-html/game-list";
    }

    @PostMapping("/game-list")
    public String gameListPost (Model model, Game game){
        String name = game.getName();
        model.addAttribute("name", name);
        return "redirect:/game-info/{name}";
    }

    @GetMapping("/game-update-list")
    public String gameListUpdateGet(Model model) {
        List<Game> gameList = gameService.listGame();
        model.addAttribute("allGames", gameList);
        return "game-html/game-update-list";
    }

    @PostMapping("/game-update-list")
    public String gameListUpdatePost (Model model, Game game){
        String name = game.getName();
        model.addAttribute("name", name);
        return "redirect:/game-update";
    }

    @GetMapping("/game-save")
    public String gameSaveGet(Model model) {
        List<Developer> developerList = developerService.getAll();
        List<Genre> all = genreService.findAll();
        List<Platform> platformList = platformService.findAll();
        List<Publisher> publisherList = publisherService.findAll();
        model.addAttribute("publisherList", publisherList);
        model.addAttribute("developerList", developerList);
        model.addAttribute("platformList", platformList);
        model.addAttribute("genres", all);
        return "game-html/game-save";
    }

    @PostMapping("/game-save")
    public String gameSavePost(GameDto gameDto, Model model) {
        Game game = new Game();
        Genre genre = new Genre();
        Publisher publisher = new Publisher();
        Developer developer = new Developer();
        Platform platform = new Platform();

        developer.setId(gameDto.getDeveloperId());
        publisher.setId(gameDto.getPublisherId());
        genre.setId(gameDto.getGenreId());


        game.setGenre(genre);
        game.setPublisher(publisher);
        game.setDeveloper(developer);
        game.setName(gameDto.getNameGame());

        gameService.save(game);
        String name = game.getName();
        model.addAttribute("gameInfo", game);
        model.addAttribute("name", name);
        return "redirect:/game-info/{name}";
    }

    @GetMapping("/findByNameGame")
    public String findByNameGameGet() {
        return "game-html/game-by-name";
    }

    @PostMapping("/findByNameGame")
    public String findByNamePost(String name, Model model) {
        model.addAttribute("name", name);
        return "redirect:/game-info/{name}";
    }

    @GetMapping("/game-info")
    public String gameInfoPost (Game game, Model model){
        String name = game.getName();
        model.addAttribute("name", name);
        return "redirect:/game-info/{name}";
    }

    @GetMapping("/game-info/{name}")
    public String findByNameGamePost(@PathVariable("name") String name, Model model) {

        Game byName = gameService.findByName(name);
        Set<ReviewGame> reviews = byName.getReviews();
        Set<Platform> platform = byName.getPlatform();
        model.addAttribute("game", byName);
        model.addAttribute("platformsList", platform);
        model.addAttribute("reviewsList", reviews);
        return "game-html/game-info";
    }

    @GetMapping("/game-update")
    public String gameUpdateGet (Game game, Model model){
        String name = game.getName();
        model.addAttribute("name", name);
        return "redirect:/game-update/{name}";
    }

    @GetMapping("/game-update/{name}")
    public String updateGameGet (Game game, Model model){
        List<Developer> developerList = developerService.getAll();
        List<Genre> all = genreService.findAll();
        List<Platform> platformList = platformService.findAll();
        List<Publisher> publisherList = publisherService.findAll();

        model.addAttribute("updateGame", game);
        model.addAttribute("publisherList", publisherList);
        model.addAttribute("developerList", developerList);
        model.addAttribute("platformList", platformList);
        model.addAttribute("genres", all);
        return "game-html/game-update";
    }

    @PostMapping("/game-update")
    public String updateGamePost (GameDto gameDto, Model model){
        Game game = new Game();
        Genre genre = new Genre();
        Publisher publisher = new Publisher();
        Developer developer = new Developer();
        Platform platform = new Platform();

        developer.setId(gameDto.getDeveloperId());
        publisher.setId(gameDto.getPublisherId());
        genre.setId(gameDto.getGenreId());


        game.setGenre(genre);
        game.setPublisher(publisher);
        game.setDeveloper(developer);
        game.setName(gameDto.getNameGame());

        gameService.update(game);
        String name = game.getName();
        model.addAttribute("name",name);
        return "redirect:/game-info/{name}";
    }
}
