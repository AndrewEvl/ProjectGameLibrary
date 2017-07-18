package controller;

import entity.Publisher;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import service.PublisherService;

import java.util.List;

/**
 * Created by Lino on 18.07.2017.
 */
@Controller
public class PublisherController {

    private final PublisherService publisherService;

    public PublisherController(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    @ModelAttribute("publisher")
    public Publisher developer() {
        return new Publisher();
    }

    @GetMapping("/publisher-list")
    public String publisherListGet (Model model){
        List<Publisher> all = publisherService.findAll();
        model.addAttribute("publisherList", all);
        return "publisher-html/publisher-list";
    }

    @GetMapping(path = "/publisher-save")
    public String savePublisherForm() {
        return "publisher-html/publisher-save";
    }

    @PostMapping(path = "/publisher-save")
    public String savePublisher(Publisher publisher) {
        publisherService.save(publisher);
        return "redirect:/publisher-list";
    }
}
