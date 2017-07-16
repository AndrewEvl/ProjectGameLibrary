package controller;

import entity.Genre;
import entity.Role;
import entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import service.UserService;
import sun.plugin.liveconnect.SecurityContextHelper;

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

//    @PostMapping("/login")
//    public String loginFormPost(String name, String password,Model model){
//        userService.loadUserByUsername(name);
//        return "user-html/login-user";
//    }

    @GetMapping("/user-save")
    public String saveForm(){
        return "user-html/user-save";
    }

//    @GetMapping("/user")
//    public String getUser(Model model){
//        User user = userService.findByNickName(SecurityContextHelper.getContext().getAuthentication().getName());
//        model.addAttribute("user",user);
//        return "user-html/login-user";
//    }

    @PostMapping("/user-save")
    public String saveUserGet(User user, Model model){
        Role role = new Role();
        role.setId(2L);
        user.setRole(role);
        userService.save(user);
        model.addAttribute("user",user);
        model.addAttribute("userName",user.getNickName());
        return "redirect:/user-save";
    }
}
