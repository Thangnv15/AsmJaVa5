package com.poly.ass.controllers.nsx;

import com.poly.ass.entities.nsx.Nsx;
import com.poly.ass.repositories.nsx.NSXRepository;
import com.poly.ass.request.nsx.NsxVM;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("nsx")
public class NsxController {
    @Autowired
    private NSXRepository nsxRepo;

    @GetMapping("index")
    public String index(Model model) {
        model.addAttribute("nsx", nsxRepo.findAll());
        return "nsx/index";
    }

    @GetMapping("create")
    public String create(Model model, Nsx nsx) {
        model.addAttribute("vm", nsx);
        return "nsx/create";
    }

    @PostMapping("store")
    public String store(@Valid @ModelAttribute("vm")
                                Nsx nsx, BindingResult result) {
        if (result.hasErrors()) {
            return "/nsx/create";
        } else {
            this.nsxRepo.save(nsx);
        }
        return "redirect:/nsx/index";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") Nsx nsx) {
        this.nsxRepo.delete(nsx);
        return "redirect:/nsx/index";
    }

    @GetMapping("edit/{id}")
    public String edit(@PathVariable("id") Nsx nsx,
                       Model model, NsxVM vm) {
        vm.loadFormDomain(nsx);
        model.addAttribute("vm", vm);
        model.addAttribute("update", "/nsx/update/" + nsx.getId());
        return "/nsx/edit";
    }

    @PostMapping("update/{id}")
    public String update(@PathVariable("id") @Valid
                         @ModelAttribute("vm") Nsx nsx,
                         NsxVM vm, BindingResult result) {
        if (result.hasErrors()) {
            return "/nsx/edit";
        } else {
            nsx.loadFormVM(vm);
            this.nsxRepo.save(nsx);
        }
        return "redirect:/nsx/index";
    }
}
