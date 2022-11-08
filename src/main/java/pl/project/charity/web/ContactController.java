package pl.project.charity.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContactController {
    @GetMapping("/contact")
    public String showContact(){
        return "contact";
    }
}
