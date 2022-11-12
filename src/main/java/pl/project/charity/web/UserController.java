package pl.project.charity.web;

import lombok.Data;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.project.charity.domain.Institution;
import pl.project.charity.domain.User;
import pl.project.charity.models.Password;
import pl.project.charity.repository.ChangeTokenRepository;
import pl.project.charity.service.AuthorityService;
import pl.project.charity.service.DonationService;
import pl.project.charity.service.UserService;
import pl.project.charity.service.VerificationTokenService;

import javax.validation.Valid;
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

    @RequestMapping("/user/profil")
    public String userProfil(@AuthenticationPrincipal UserDetails userDetails, Model model) {
        String email = userDetails.getUsername();
        User user = userService.findByEmail(email);
        model.addAttribute("user", user);
        return "profil";
    }

    @RequestMapping("/user/changePassword/{id}")
    public String changePasswordForm(@PathVariable long id, Model model){
        User user=userService.findById(id);
        Password password=new Password();
        password.setEmail(user.getEmail());
        model.addAttribute("password",password);
        return "changePassword";
    }

    @GetMapping("/user/changePassword")
    public String changePassword(@Valid Password password, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "changePassword";
        }

        User user = userService.findByEmail(password.getEmail());

        if (!passwordEncoder.matches(password.getPassword(), user.getPassword())) {
            result.rejectValue("email", "error.password", "Błędne aktualne hasło");
            model.addAttribute("password", password);
            return "changePassword";
        }
        if (!password.getNewPassword().equals(password.getMatchingNewPassword())){
            result.rejectValue("email","error.password","Błąd potwierdzenia nowego hasła");
            model.addAttribute("password",password);
            return "changePassword";
        }
        user.setPassword(passwordEncoder.encode(password.getNewPassword()));
        userService.save(user);
        return "changePassword-confirmation";

    }

    @ModelAttribute("users")
    public List<User> users() {
        return userService.findAll();
    }
}

