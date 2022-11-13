package pl.project.charity.web;

import org.apache.tomcat.jni.Local;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.project.charity.domain.Category;
import pl.project.charity.domain.Donation;
import pl.project.charity.domain.Institution;
import pl.project.charity.domain.User;
import pl.project.charity.service.CategoryService;
import pl.project.charity.service.DonationService;
import pl.project.charity.service.InstitutionService;
import pl.project.charity.service.UserService;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/donation")
@SessionAttributes("donation")
public class DonationController {
    private final DonationService donationService;
    private final CategoryService categoryService;
    private final InstitutionService institutionService;

    private final UserService userService;

    public DonationController(DonationService donationService, CategoryService categoryService, InstitutionService institutionService, UserService userService) {
        this.donationService = donationService;
        this.categoryService = categoryService;
        this.institutionService = institutionService;
        this.userService = userService;
    }


    @GetMapping("/add")
    public String donationForm(Model model, @AuthenticationPrincipal UserDetails userDetails) {
        String email = userDetails.getUsername();
        User user = userService.findByEmail(email);
        if (!user.isAccess()) {
            return "noAccess";
        }
        model.addAttribute("donation", new Donation());
        return "form";
    }

    @PostMapping("/add")
    public String procesDonationForm(@Valid Donation donation, BindingResult result,
                                     Model model, @AuthenticationPrincipal UserDetails userDetails) {
        if (result.hasErrors()) {
            model.addAttribute("donation", donation);
            return "form";
        }
        String email = userDetails.getUsername();
        User user = userService.findByEmail(email);
        donation.setUser(user);
        donation.setReceived(false);
        donationService.save(donation);

        return "formConfirmation";
    }

    @GetMapping("/donations")
    public String myDonations(@AuthenticationPrincipal UserDetails userDetails, Model model) {
        String email = userDetails.getUsername();
        User user = userService.findByEmail(email);
        List<Donation> myDonations = donationService.myDonations(user.getId());
        model.addAttribute("myDonations", myDonations);
        return "donations";
    }

    @GetMapping("/donationDetails/{id}")
    public String donationDetails(@PathVariable Long id, Model model) {
        Donation donation = donationService.findById(id);
        model.addAttribute("donation", donation);
        return "donationDetails";
    }

    @GetMapping("/donation/confirmation/{id}")
    public String donationConfirmation(@PathVariable Long id) {
        Donation donation = donationService.findById(id);
        LocalDate localDate = LocalDate.now();
        donation.setConfirmDate(localDate);
        donation.setReceived(true);
        donationService.save(donation);
        return "redirect:/donations";
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
