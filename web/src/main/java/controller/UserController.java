package controller;

import entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import service.UserService;

/**
 * Created by Lino on 02.07.2017.
 */
@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ModelAttribute("user")
    public User user(){
        return new User();
    }

    @GetMapping("/login")
    public String loginForm(){
        return "user-html/login-user";
    }

    @PostMapping("/login")
    public String loginFormPost(){
        return "user-html/login-user";
    }

    @GetMapping("/user-save")
    public String saveForm(){
        return "user-html/user-save";
    }

    @PostMapping("/user-save")
    public String saveUserGet(User user, Model model){
        userService.save(user);
        model.addAttribute("user",user);
        model.addAttribute("userName",user.getNickName());
        return "redirect:/user-save";
    }
}
