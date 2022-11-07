package pl.project.charity.web;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.project.charity.domain.User;
import pl.project.charity.service.UserService;

import javax.validation.Valid;

@Controller
public class LoginController {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    public LoginController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("user", new User());
        return "login";
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
        return "login";
    }


}
