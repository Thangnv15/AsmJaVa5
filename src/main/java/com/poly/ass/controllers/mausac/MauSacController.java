package com.poly.ass.controllers.mausac;


import com.poly.ass.entities.mausac.MauSac;
import com.poly.ass.repositories.mausac.MauSacRepository;
import com.poly.ass.request.mausac.MauSacVM;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("mau-sac")
public class MauSacController {
    @Autowired
    private MauSacRepository msRepo;

    @GetMapping("index")
    public String index(Model model) {
        model.addAttribute("mausac", msRepo.findAll());
        return "/mau_sac/index";
    }

    @GetMapping("create")
    public String create(Model model, MauSac ms) {
        model.addAttribute("vm", ms);
        return "/mau_sac/create";
    }

    @PostMapping("store")
    public String store(@Valid @ModelAttribute("vm")
                                MauSac ms, BindingResult result
    ) {
        if (result.hasErrors()) {
            return "/mau_sac/create";
        } else {
            this.msRepo.save(ms);
        }
        return "redirect:/mau-sac/index";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") MauSac ms) {
        this.msRepo.delete(ms);
        return "redirect:/mau-sac/index";
    }

    @GetMapping("edit/{id}")
    public String edit(@PathVariable("id") MauSac ms,
                       Model model, MauSacVM vm) {
        vm.loadFormDomain(ms);
        model.addAttribute("vm", vm);
        model.addAttribute("update", "/mau-sac/update/" + ms.getId());
        return "mau_sac/edit";
    }

    @PostMapping("update/{id}")
    public String update(@PathVariable("id") MauSac ms,
                         @Valid @ModelAttribute("vm") MauSacVM vm,
                         BindingResult result){
        if(result.hasErrors()){
            return "/mau_sac/edit";
        }else {
            ms.loadFormVM(vm);
            this.msRepo.save(ms);
        }
        return "redirect:/mau-sac/index";
    }
}
