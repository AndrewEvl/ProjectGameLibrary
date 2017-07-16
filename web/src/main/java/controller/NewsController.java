package controller;

import entity.News;
import entity.reviews.NewsComment;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import service.NewsCommentsService;
import service.NewsService;

import java.util.List;
import java.util.Set;

/**
 * Created by Lino on 01.07.2017.
 */
@Controller
public class NewsController {

    private final NewsService newsService;
    private final NewsCommentsService newsCommentsService;

    @Autowired
    public NewsController(NewsService newsService, NewsCommentsService newsCommentsService) {
        this.newsService = newsService;
        this.newsCommentsService = newsCommentsService;
    }

    @ModelAttribute("news")
    public News news(){
        return new News();
    }

    @ModelAttribute("newsComment")
    public NewsComment newsComment(){
        return new NewsComment();
    }

    @GetMapping("/")
    public String homePage(Model model){
        List<News> newsList = newsService.getAll();
        model.addAttribute("newsList", newsList);
        return "home-page";
    }

    @GetMapping("/{id}")
    public String newsGet (@PathVariable ("id") Long id, Model model){
        News news = newsService.findById(id);
        Long newsId = news.getId();
        model.addAttribute("news",news);
        model.addAttribute("id", newsId);
        return "redirect:/news-full/{id}";
    }

    @GetMapping("/news-full/{id}")
    public String newsInfoGet (@PathVariable ("id") Long id, Model model){
        News news = newsService.findById(id);
        Set<NewsComment> newsCommentSet = news.getNewsCommentSet();
        model.addAttribute("newsCementsSet", newsCommentSet);
        model.addAttribute("news", news);
        return "news-html/news-full";
    }

    @PostMapping("/news-full")
    public String newsInfoPost (News news,NewsComment newsComment,Model model){

        newsCommentsService.save(newsComment);
//        model.addAttribute("id",id);
        return "redirect:/news-full/{id}";
    }
}
