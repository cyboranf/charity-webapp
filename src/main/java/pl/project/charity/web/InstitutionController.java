package pl.project.charity.web;

import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.project.charity.domain.Donation;
import pl.project.charity.domain.Institution;
import pl.project.charity.service.DonationService;
import pl.project.charity.service.InstitutionService;

import javax.validation.Valid;
import java.util.Collection;
import java.util.List;

@Data
@Controller
public class InstitutionController {
    private final InstitutionService institutionService;
    private final DonationService donationService;

    @RequestMapping("/admin/institutions")
    public String getInstitution(){
        return "institutions";
    }
    @GetMapping("/admin/institutions/add")
    public String addInstitutions(Model model){
        model.addAttribute("institution",new Institution());
        return "addInstitution";
    }

    @PostMapping("/admin/institution/add")
    public String saveInstitution(@Valid Institution institution, BindingResult result){
        if (result.hasErrors()){
            return "addInstitution";
        }
        institutionService.save(institution);
        return "redirect:/admin/institutions";
    }

    @RequestMapping("/admin/institution/del/{id}")
    public String deleteInstitution(@PathVariable long id){
        List<Donation> donationList=donationService.donationByInstitutionId(id);
        if (donationList.size()>0){
            return "noInstitutionDelete";
        }
        Institution institution=institutionService.findById(id);
        institutionService.delete(institution);
        return "redirect:/admin/institutions";
    }

    @RequestMapping("/admin/institution/edit")
    public String editInstitution(@Valid Institution institution, BindingResult result){
        if (result.hasErrors()){
            return "editInstitution";
        }
        institutionService.save(institution);
        return "redirect:/admin/institutions";
    }

    @ModelAttribute
    public Collection<Institution> institutions(){
        return institutionService.findAll();
    }
}
