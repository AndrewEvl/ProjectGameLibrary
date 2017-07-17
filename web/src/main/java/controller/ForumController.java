package controller;

import entity.ForumTheme;
import entity.reviews.ForumComments;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import service.ForumCommentsService;
import service.ForumThemService;

import java.util.List;
import java.util.Set;

/**
 * Created by Lino on 16.07.2017.
 */
@Controller
public class ForumController {

    private final ForumThemService forumThemService;
    private final ForumCommentsService forumCommentsService;

    public ForumController(ForumThemService forumThemService, ForumCommentsService forumCommentsService) {
        this.forumThemService = forumThemService;
        this.forumCommentsService = forumCommentsService;
    }

    @GetMapping("/forum-theme-list")
    public String forumThemeListGet(Model model) {
        List<ForumTheme> themeList = forumThemService.findAll();
        model.addAttribute("themeList", themeList);
        return "forum-html/forum-theme-list";
    }

    @PostMapping("/forum-theme-list")
    public String forumThemeListPost(Model model, ForumTheme forumTheme) {
        Long id = forumTheme.getId();
        model.addAttribute("id", id);
        return "redirect:/full-forum{id}";
    }

    @GetMapping("/full-forum")
    public String fullForumGet(ForumTheme forumTheme, Model model) {
        Long id = forumTheme.getId();
        model.addAttribute("id", id);
        return "redirect:/full-forum/{id}";
    }

    @GetMapping("/full-forum/{id}")
    public String fullForumIdGet(@PathVariable("id") Long id, Model model) {
        ForumTheme byId = forumThemService.findById(id);
        Set<ForumComments> forumComments = byId.getForumComments();
        model.addAttribute("them", byId);
        model.addAttribute("commentsList", forumComments);
        return "forum-html/full-forum";
    }

}
