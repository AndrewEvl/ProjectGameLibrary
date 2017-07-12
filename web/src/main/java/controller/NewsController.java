package controller;

import entity.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import service.NewsService;

import java.util.List;

/**
 * Created by Lino on 01.07.2017.
 */
@Controller
public class NewsController {

    private  final NewsService newsService;

    @Autowired
    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @ModelAttribute("news")
    public News news(){
        return new News();
    }

    @GetMapping("/")
    public String homePage(Model model){
        List<News> newsList = newsService.getAll();
        model.addAttribute("newsList", newsList);
        return "home-page";
    }

}
