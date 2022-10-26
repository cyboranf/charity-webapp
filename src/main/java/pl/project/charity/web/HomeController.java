package pl.project.charity.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class HomeController {


    @RequestMapping("/")
    public ModelAndView homeAction(Model model){
        return new ModelAndView("index");
    }
}
