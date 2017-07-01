package controller;

import entity.Developer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import service.DeveloperService;

/**
 * Created by Lino on 25.06.2017.
 */
@Controller
public class DeveloperController {

    private final DeveloperService developerService;

    @Autowired
    public DeveloperController (DeveloperService developerService){
        this.developerService = developerService;
    }

    @GetMapping(path = "/developer")
    public String sendIdForm(){
        return "developer-form";
    }

    @PostMapping(path = "/developer")
    public String findByIdDeveloper (Developer developer, Model model){
        Long id = developer.getId();
        model.addAttribute("id",id);
        return "redirect:/developer-info/{id}";
    }

    @GetMapping(path = "/developer-info/{id}")
    public String showInfoDeveloper (@PathVariable("id") Long devId, Model model){
        Developer developer = developerService.findById(devId);
        model.addAttribute("developer", developer);
        return "developer-info";
    }

}
