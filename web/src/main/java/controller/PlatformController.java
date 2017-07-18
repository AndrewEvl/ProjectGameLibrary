package controller;

import entity.Platform;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import service.PlatformService;

import java.util.List;

/**
 * Created by Lino on 18.07.2017.
 */
@Controller
public class PlatformController {

    private final PlatformService platformService;

    public PlatformController(PlatformService platformService) {
        this.platformService = platformService;
    }


    @ModelAttribute("platform")
    public Platform platform () {
        return new Platform();
    }

    @GetMapping("/platform-list")
    public String platformListGet (Model model){
        List<Platform> platformList = platformService.findAll();
        model.addAttribute("platformList", platformList);
        return "platform-html/platform-list";
    }

    @GetMapping("/platform-save")
    public String savePlatformGet (){
        return "platform-html/platform-save";
    }

    @PostMapping("/platform-save")
    public String savePlatformPost (Platform platform, Model model){
        platformService.save(platform);
        model.addAttribute("platform", platform);
        return "redirect:/platform-list";
    }
}
