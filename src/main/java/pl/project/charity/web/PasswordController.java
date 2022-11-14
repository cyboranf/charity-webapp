package pl.project.charity.web;

import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.project.charity.models.Password;
import pl.project.charity.service.PasswordService;
import pl.project.charity.service.ResetTokenService;
import pl.project.charity.service.UserService;

import javax.naming.Binding;
import javax.validation.Valid;

@Data
@Controller
public class PasswordController {
    private final ResetTokenService resetTokenService;
    private final PasswordEncoder encoder;
    private final PasswordService passwordService;
    private final UserService userService;

    @GetMapping("/password")
    public String resetPasswordForm(@ModelAttribute("password")Password password){
        return "password";
    }
    @PostMapping("/password")
    public String emailToRestPassword(@Valid Password password, BindingResult result, Model model){
        if(result.hasErrors()){
            return "password";
        }
        if (userService.findByEmail(password.getEmail())==null){
            result.rejectValue("email", "error.user","Taki email już istnieje");
            model.addAttribute("password",password);
            return "password";
        }
        //wysylanie maila
        return "passwordSendMail";
    }
    @PostMapping("passwordReset")
    public String saveNewPassword(@Valid Password password,BindingResult result){
        if (result.hasErrors()){
            return "resetPassword";
        }
        if (!password.getNewPassword().equals(password.getMatchingNewPassword())){
            result.rejectValue("password","error.user","Wpisane hasła są rózne");
            return "resetPassword";
        }
        password.setNewPassword(encoder.encode(password.getNewPassword()));
        passwordService.update(password);
        return "resetPasswordConfirm";
    }


}
