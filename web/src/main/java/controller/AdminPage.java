package controller;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by User on 15.07.2017.
 */
@Controller
public class AdminPage {

    @GetMapping("/adminPage")
    public String adminPage (){
        return "admin-page";
    }
}
