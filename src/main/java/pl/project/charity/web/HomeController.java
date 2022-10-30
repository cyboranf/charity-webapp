package pl.project.charity.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.project.charity.service.CategoryService;
import pl.project.charity.service.DonationService;
import pl.project.charity.service.InstitutionService;


@Controller
public class HomeController {
    private final CategoryService categoryService;
    private final DonationService donationService;
    private final InstitutionService institutionService;

    public HomeController(CategoryService categoryService, DonationService donationService, InstitutionService institutionService) {
        this.categoryService = categoryService;
        this.donationService = donationService;
        this.institutionService = institutionService;
    }

    @RequestMapping("/")
    public String homeAction(Model model) {
        model.addAttribute("institutions", institutionService.findAll());
        model.addAttribute("quantity", donationService.quantityOfBags());
        model.addAttribute("donationsSum", donationService.quantityOfDonations());

        return "index";
    }
}
