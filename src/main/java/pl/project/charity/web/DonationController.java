package pl.project.charity.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.project.charity.domain.Category;
import pl.project.charity.domain.Donation;
import pl.project.charity.domain.Institution;
import pl.project.charity.service.CategoryService;
import pl.project.charity.service.DonationService;
import pl.project.charity.service.InstitutionService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/donation")
@SessionAttributes("donation")
public class DonationController {
    private final DonationService donationService;
    private final CategoryService categoryService;
    private final InstitutionService institutionService;

    public DonationController(DonationService donationService, CategoryService categoryService, InstitutionService institutionService) {
        this.donationService = donationService;
        this.categoryService = categoryService;
        this.institutionService = institutionService;
    }


    @GetMapping("/add")
    public String showForm() {
        return "form1";
    }

    @PostMapping("/add2")
    public String postForm2(@ModelAttribute Donation donations) {
        return "form2";
    }

    @PostMapping("/add3")
    public String postForm3(@ModelAttribute Donation donations){
        return "form3";
    }




    @ModelAttribute("categories")
    public List<Category> categories() {
        return categoryService.findAll();
    }

    @ModelAttribute("institutions")
    public List<Institution> institutions() {
        return institutionService.findAll();
    }

    @ModelAttribute("donation")
    public Donation donationSession() {
        return new Donation();
    }


}
