package controller;

import entity.Genre;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import service.GenreService;

import java.util.List;

/**
 * Created by User on 04.07.2017.
 */
@Controller
public class GenreController {

    private final GenreService genreService;

    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }

    @ModelAttribute("genres")
    public List<Genre> genre (){
        List<Genre> genres = genreService.findAll();
        return genres;
    }

    public String allGenre (Model model){
        List<Genre> genres = genreService.findAll();
        model.addAttribute("genreList", genres);
        return "game-html/game-save";
    }
}
