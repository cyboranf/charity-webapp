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
import java.security.Principal;
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
    public String donationForm(Model model) {
        model.addAttribute("donation", new Donation());
        return "form";
    }

    @PostMapping("/add")
    public String procesDonationForm(@Valid Donation donation, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("donation", donation);
            return "form";
        }
        donationService.save(donation);
        return "formConfirmation";
    }



    @ModelAttribute("categories")
    public List<Category> categories() {
        return categoryService.findAll();
    }

    @ModelAttribute("institutions")
    public List<Institution> institutions() {
        return institutionService.findAll();
    }



}
