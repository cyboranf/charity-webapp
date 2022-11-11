package pl.project.charity.web;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.project.charity.domain.User;
import pl.project.charity.domain.VerificationToken;
import pl.project.charity.service.UserService;
import pl.project.charity.service.VerificationTokenService;

import javax.validation.Valid;
import java.util.List;

@Controller
public class LoginController {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final VerificationTokenService verificationTokenService;

    public LoginController(UserService userService, PasswordEncoder passwordEncoder, VerificationTokenService verificationTokenService) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
        this.verificationTokenService = verificationTokenService;
    }


    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String addUser(@Valid @ModelAttribute("user") User user,
                          BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("user", user);
            return "register";
        }
        if (userService.findByEmail(user.getEmail()) != null) {
            result.rejectValue("email", "error.user", "Taki Email już istnieje");
            model.addAttribute("user", user);
            return "register";
        }
        if (!user.getPassword().equals(user.getMatchingPassword())) {
            result.rejectValue("password", "error.user", "Podane hasłą są różne");
            model.addAttribute("user", user);
            return "register";
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setEnabled(false);
        user.setAccess(true);
        userService.save(user);
        return "user";
    }

    @GetMapping("registerConfirm")
    public String registerConfirm(@RequestParam("token") String token) {
        VerificationToken verificationToken = verificationTokenService.findFirstByToken(token);
        userService.confirmUser(verificationToken.getToken());
        return "register-confirmation";
    }

    @ModelAttribute("users")
    public List<User> users() {
        return userService.findAll();
    }


}
