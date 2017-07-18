package controller;

import entity.ForumTheme;
import entity.User;
import entity.reviews.ForumComments;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import service.ForumCommentsService;
import service.ForumThemService;
import service.UserService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * Created by Lino on 16.07.2017.
 */
@Controller
public class ForumController {

    private Long ID;

    private final ForumThemService forumThemService;
    private final ForumCommentsService forumCommentsService;
    private final UserService userService;

    public ForumController(ForumThemService forumThemService, ForumCommentsService forumCommentsService, UserService userService) {
        this.forumThemService = forumThemService;
        this.forumCommentsService = forumCommentsService;
        this.userService = userService;
    }

    @ModelAttribute("forumComments")
    public ForumComments forumComments() {
        return new ForumComments();
    }

    @ModelAttribute("forumTheme")
    public ForumTheme forumTheme() {
        return new ForumTheme();
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
        ID = id;
        Set<ForumComments> forumComments = byId.getForumComments();
        List<ForumComments> forumCommentsList = new ArrayList<>();
        forumCommentsList.addAll(forumComments);
        Collections.reverse(forumCommentsList);
        model.addAttribute("them", byId);
        model.addAttribute("commentsList", forumComments);
        return "forum-html/full-forum";
    }

    @GetMapping("/forum-add-comments")
    public String forumAddCommentsGet() {
        return "forum-html/forum-add-comments";
    }

    @PostMapping("/forum-add-comments")
    public String forumAddCommentsPost(ForumComments forumComments, Model model) {
        ForumTheme forumTheme = forumThemService.findById(ID);
        User nickname = userService.findByNickname(SecurityContextHolder.getContext().getAuthentication().getName());
        forumComments.setForumTheme(forumTheme);
        forumComments.setUser(nickname);
        forumCommentsService.save(forumComments);
        Long id = forumTheme.getId();
        model.addAttribute("id", id);
        return "redirect:/full-forum/{id}";
    }

    @GetMapping("/forum-add-theme")
    public String forumAddThemeGet() {
        return "forum-html/forum-add-theme";
    }

    @PostMapping("/forum-add-theme")
    public String forumAddThemePost(ForumTheme forumTheme, Model model) {
        forumThemService.save(forumTheme);
        Long id = forumTheme.getId();
        model.addAttribute("id", id);
        return "redirect:/full-forum/{id}";
    }

}
