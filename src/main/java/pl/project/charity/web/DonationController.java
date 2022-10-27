package pl.project.charity.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.project.charity.domain.Donation;
import pl.project.charity.service.CategoryService;
import pl.project.charity.service.DonationService;
import pl.project.charity.service.InstitutionService;

@Controller
@RequestMapping("/donation/add")
public class DonationController {
    private final DonationService donationService;
    private final CategoryService categoryService;
    private final InstitutionService institutionService;

    public DonationController(DonationService donationService, CategoryService categoryService, InstitutionService institutionService) {
        this.donationService = donationService;
        this.categoryService = categoryService;
        this.institutionService = institutionService;
    }

    @GetMapping("")
    public String showForm(Model model) {
        model.addAttribute("categories",categoryService.findAll());
        return "form1";
    }


}
