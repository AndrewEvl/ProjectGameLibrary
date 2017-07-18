package controller;

import dto.NewsCommentsDto;
import dto.NewsDto;
import entity.News;
import entity.reviews.NewsComment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import service.NewsService;

import java.util.List;

/**
 * Created by Lino on 01.07.2017.
 */
@Controller
public class NewsController {

    private News NEWS;

    private final NewsService newsService;

    @Autowired
    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @ModelAttribute("news")
    public News news() {
        return new News();
    }

    @ModelAttribute("newsDto")
    public NewsDto newsDto() {
        return new NewsDto();
    }

    @ModelAttribute("newsCommentsDto")
    public NewsCommentsDto newsCommentsDto() {
        return new NewsCommentsDto();
    }

    @ModelAttribute("newsComment")
    public NewsComment newsComment() {
        return new NewsComment();
    }

    @GetMapping("/")
    public String homePage(Model model) {
        List<News> newsList = newsService.getAll();
        model.addAttribute("newsList", newsList);
        return "home-page";
    }

    @GetMapping("/{id}")
    public String newsGet(@PathVariable("id") Long id, Model model) {
        News news = newsService.findById(id);
        Long newsId = news.getId();
        model.addAttribute("newsid", news);
        model.addAttribute("id", newsId);
        return "redirect:/news-update/{id}";
    }

    @GetMapping("/news-add")
    public String newsAddGet() {
        return "news-html/news-add";
    }

    @PostMapping("/news-add")
    public String newsAddPost(News news) {
        newsService.save(news);
        return "redirect:/adminPage";
    }

    @GetMapping("/news-update/{id}")
    public String newsInfoGet(@PathVariable("id") Long id, Model model) {
        News news = newsService.findById(id);
        NEWS = news;
        model.addAttribute("news", news);
        model.addAttribute("id", id);
        return "news-html/news-update";
    }

    @PostMapping("/news-update")
    public String newsUpdatePost(NewsDto newsDto) {
        News news = new News();
        news.setId(NEWS.getId());
        news.setVersion(NEWS.getVersion());
        news.setName(newsDto.getNameNews());
        news.setText(newsDto.getTextNews());
        newsService.update(news);
        return "redirect:/news-update-list";
    }

    @GetMapping("/news-update-list")
    public String newsUpdateGet(Model model) {
        List<News> newsList = newsService.getAll();
        model.addAttribute("newsList", newsList);
        return "news-html/news-update-list";
    }

    @GetMapping("/news-update-list/{id}")
    public String newsUpGet(@PathVariable("id") Long id, Model model) {
        News news = newsService.findById(id);
        Long newsId = news.getId();
        model.addAttribute("news", news);
        model.addAttribute("id", newsId);
        return "redirect:/news-update/{id}";
    }


}
