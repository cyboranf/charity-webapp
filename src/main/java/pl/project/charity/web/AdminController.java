package pl.project.charity.web;

import lombok.Data;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.project.charity.domain.Authority;
import pl.project.charity.domain.Donation;
import pl.project.charity.domain.User;
import pl.project.charity.repository.ChangeTokenRepository;
import pl.project.charity.service.AuthorityService;
import pl.project.charity.service.DonationService;
import pl.project.charity.service.UserService;
import pl.project.charity.service.VerificationTokenService;

import java.util.List;

@Data
@Controller
public class AdminController {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final AuthorityService authorityService;
    private final VerificationTokenService verificationTokenService;
    private final ChangeTokenRepository changeTokenRepository;
    private final DonationService donationService;


    public AdminController(UserService userService, PasswordEncoder passwordEncoder, AuthorityService authorityService, VerificationTokenService verificationTokenService, ChangeTokenRepository changeTokenRepository, DonationService donationService) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
        this.authorityService = authorityService;
        this.verificationTokenService = verificationTokenService;
        this.changeTokenRepository = changeTokenRepository;
        this.donationService = donationService;
    }

    @RequestMapping("/admin/userAccess/{id}")
    public String userAccess(@PathVariable long id) {
        User user = userService.findById(id);
        boolean access = user.isAccess();
        access = !access;
        user.setAccess(access);
        userService.save(user);
        return "redirect/user";
    }

    @RequestMapping("/admin/userAuthority/{id}")
    public String userAuthority(@PathVariable long id, @AuthenticationPrincipal UserDetails userDetails) {
        String email = userDetails.getUsername();
        User user = userService.findByEmail(email);
        if (user.getId() == id) {
            return "noDelete";
        }
        user = userService.findById(id);
        Authority authority = authorityService.findFirstBtEmail(user.getEmail());
        String authorityName = authority.getAuthority();
        if (authorityName.equals("ADMIN")) {
            authorityName = "USER";
        } else {
            authorityName = "ADMIN";
        }
        authority.setAuthority(authorityName);
        authorityService.save(authority);
        return "redirect:/user";
    }

    @RequestMapping("/admin/userDelete/{id}")
    public String userDelete(@PathVariable long id, @AuthenticationPrincipal UserDetails userDetails) {
        String email=userDetails.getUsername();
        User user=userService.findByEmail(email);
        if (user.getId() == id) {
            return "noDelete";
        }
        List<Donation> donationList=donationService.myDonations(id);
        if (donationList.size()>0){
            return "noDelete";
        }
        user=userService.findById(id);
        userService.delete(user);
        Authority authority=authorityService.findFirstBtEmail(user.getEmail());
        authorityService.delete(authority);
        return "redirect:/user";
    }
}
