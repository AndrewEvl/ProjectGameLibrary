package controller;

import dto.GameCollectionDto;
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

import java.util.List;
import java.util.Set;

/**
 * Created by Lino on 02.07.2017.
 */
@Controller
public class GameController {

    private String NAME;
    private final GameService gameService;
    private final GenreService genreService;
    private final PublisherService publisherService;
    private final DeveloperService developerService;
    private final PlatformService platformService;
    private final GameCollectionService gameCollectionService;

    public GameController(GameService gameService, GenreService genreService, PublisherService publisherService, DeveloperService developerService, PlatformService platformService, GameCollectionService gameCollectionService) {
        this.gameService = gameService;
        this.genreService = genreService;
        this.publisherService = publisherService;
        this.developerService = developerService;
        this.platformService = platformService;
        this.gameCollectionService = gameCollectionService;
    }

    @ModelAttribute("gameCollection")
    public GameCollection gameCollection() {
        return new GameCollection();
    }

    @ModelAttribute("game")
    public Game game() {
        return new Game();
    }

    @ModelAttribute("gameDto")
    public GameDto gameDto() {
        return new GameDto();
    }

    @ModelAttribute("gameCollectionDto")
    public GameCollectionDto gameCollectionDto() {
        return new GameCollectionDto();
    }

    @GetMapping("/game-list")
    public String gameListGet(Model model) {
        List<Game> gameList = gameService.listGame();
        List<GameCollection> collectionList = gameCollectionService.findAll();
        model.addAttribute("gameCollectionAll", collectionList);
        model.addAttribute("allGames", gameList);
        return "game-html/game-list";
    }

    @PostMapping("/game-list")
    public String gameListPost(Model model, Game game) {
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
    public String gameListUpdatePost(Model model, Game game) {
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

    @GetMapping("/game-collection-save")
    public String gameCollectionSaveGet(Model model) {
        List<Developer> developerList = developerService.getAll();
        List<Genre> all = genreService.findAll();
        List<Platform> platformList = platformService.findAll();
        List<Publisher> publisherList = publisherService.findAll();
        model.addAttribute("publisherList", publisherList);
        model.addAttribute("developerList", developerList);
        model.addAttribute("platformList", platformList);
        model.addAttribute("genres", all);
        return "game-html/game-collection-save";
    }

    @PostMapping("/game-collection-save")
    public String gameCollectionSavePost(GameCollectionDto gameCollectionDto, Model model) {
        GameCollection gameCollection = new GameCollection();
        Genre genre = new Genre();
        Publisher publisher = new Publisher();
        Developer developer = new Developer();
        Platform platform = new Platform();

        developer.setId(gameCollectionDto.getDeveloperId());
        publisher.setId(gameCollectionDto.getPublisherId());
        genre.setId(gameCollectionDto.getGenreId());

        gameCollection.setGenre(genre);
        gameCollection.setPublisher(publisher);
        gameCollection.setDeveloper(developer);
        gameCollection.setName(gameCollectionDto.getNameGame());
        gameCollection.setArtBook(gameCollectionDto.getArtbook());
        gameCollection.setFigure(gameCollectionDto.getFigure());
        gameCollection.setOst(gameCollectionDto.getOst());
        gameCollection.setOther(gameCollectionDto.getOther());

        gameCollectionService.save(gameCollection);
        Long id = gameCollection.getId();
        model.addAttribute("gameInfo", gameCollection);
        model.addAttribute("id", id);
        return "redirect:/game-info-collection/{id}";
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
    public String gameInfoPost(Game game, Model model) {
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

    @GetMapping("/game-info-collection")
    public String gameCollectionInfoGet(GameCollection gameCollection, Model model) {
        Long id = gameCollection.getId();
        model.addAttribute("id", id);
        return "redirect:/game-info-collection/{id}";
    }

    @GetMapping("/game-info-collection/{id}")
    public String gameCollectionInfoIdPost(@PathVariable("id") Long id, Model model) {
        GameCollection byId = gameCollectionService.findById(id);
        Set<ReviewGame> reviews = byId.getReviews();
        Set<Platform> platform = byId.getPlatform();
        model.addAttribute("game", byId);
        model.addAttribute("platformsList", platform);
        model.addAttribute("reviewsList", reviews);
        return "game-html/game-info-collection";
    }

    @GetMapping("/game-update")
    public String gameUpdateGet(Game game, Model model) {
        String name = game.getName();
        NAME = name;
        model.addAttribute("name", name);
        return "redirect:/game-update/{name}";
    }

    @GetMapping("/game-update/{name}")
    public String updateGameGet(Game game, Model model) {
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
    public String updateGamePost(GameDto gameDto, Model model) {
        Game game = new Game();
        Genre genre = new Genre();
        Publisher publisher = new Publisher();
        Developer developer = new Developer();
        Platform platform = new Platform();

        developer.setId(gameDto.getDeveloperId());
        publisher.setId(gameDto.getPublisherId());
        genre.setId(gameDto.getGenreId());


        game.setName(NAME);
        game.setGenre(genre);
        game.setPublisher(publisher);
        game.setDeveloper(developer);
        game.setName(gameDto.getNameGame());

        gameService.update(game);
        String name = game.getName();
        model.addAttribute("name", name);
        return "redirect:/game-info/{name}";
    }
}
