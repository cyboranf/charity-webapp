package pl.project.charity.web;

import lombok.Data;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import pl.project.charity.domain.Institution;
import pl.project.charity.domain.User;
import pl.project.charity.repository.ChangeTokenRepository;
import pl.project.charity.service.AuthorityService;
import pl.project.charity.service.DonationService;
import pl.project.charity.service.UserService;
import pl.project.charity.service.VerificationTokenService;

import java.util.Collection;
import java.util.List;

@Controller
@Data
public class UserController {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final AuthorityService authorityService;
    private final VerificationTokenService verificationTokenService;
    private final ChangeTokenRepository changeTokenRepository;
    private final DonationService donationService;

    public UserController(UserService userService, PasswordEncoder passwordEncoder, AuthorityService authorityService, VerificationTokenService verificationTokenService, ChangeTokenRepository changeTokenRepository, DonationService donationService) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
        this.authorityService = authorityService;
        this.verificationTokenService = verificationTokenService;
        this.changeTokenRepository = changeTokenRepository;
        this.donationService = donationService;
    }

    @GetMapping("/user")
    public String User(@AuthenticationPrincipal UserDetails userDetails, Model model) {
        String email = userDetails.getUsername();
        String role = authorityService.findFirstBtEmail(email).getAuthority();
        String firstName = userService.findByEmail(email).getFirstName();
        model.addAttribute("firstname", firstName);

        if (role.equals("ADMIN")) {
            return "admin";
        }
        return "user";
    }

    @ModelAttribute("users")
    public List<User> users() {
        return userService.findAll();
    }
}

