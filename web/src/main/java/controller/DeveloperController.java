package controller;

import entity.Developer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import service.DeveloperService;

import java.util.List;

/**
 * Created by Lino on 25.06.2017.
 */
@Controller
public class DeveloperController {

    private final DeveloperService developerService;

    @Autowired
    public DeveloperController(DeveloperService developerService) {
        this.developerService = developerService;
    }

    @ModelAttribute("developer")
    public Developer developer() {
        return new Developer();
    }

    @GetMapping(path = "/developer")
    public String sendIdForm() {
        return "developer-html/developer-form";
    }

    @PostMapping(path = "/developer")
    public String findByIdDeveloper(Long id, Model model) {
        model.addAttribute("devId", id);
        return "redirect:/developer-info/{devId}";
    }

    @GetMapping(path = "/developer-info/{devId}")
    public String showInfoDeveloper(@PathVariable("devId") Long devId, Model model) {
        Developer developer = developerService.findById(devId);
        model.addAttribute("developerId", developer);
        return "developer-html/developer-info";
    }

    @GetMapping(path = "/developer-save")
    public String saveDeveloperForm (){
        return "developer-html/developer-save";
    }

    @PostMapping(path = "/developer-save")
    public String saveDeveloper(String name, Model model){
        Developer developer = new Developer();
        developer.setName(name);
        developerService.save(developer);
        Long id = developer.getId();
        model.addAttribute("developer",developer);
        model.addAttribute("devId", id);
        return "redirect:/developer-info/{devId}";
    }

    @GetMapping("/all-developers")
    public String allDevelopers (Model model){
        List<Developer> developers = developerService.getAll();
        model.addAttribute("allDevelopers", developers);
        return "developer-html/developer-all";
    }
}
