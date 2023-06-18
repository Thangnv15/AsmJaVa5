package com.poly.ass.controllers.dongsp;


import com.poly.ass.entities.chucvu.ChucVu;
import com.poly.ass.entities.dongsp.DongSP;
import com.poly.ass.repositories.dongsp.DongSPRepository;

import com.poly.ass.request.chucvu.ChucVuVM;
import com.poly.ass.request.dongsp.DongSPVM;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("dong-sp")
public class DongSPController {
    @Autowired
    private DongSPRepository dongSPRepo;

    @GetMapping("index")
    public String index(Model model) {
        model.addAttribute("dongsp", dongSPRepo.findAll());
        return "/dong_sp/index";
    }

    @GetMapping("create")
    public String create(Model model, DongSP dsp) {
        model.addAttribute("vm", dsp);
        return "/dong_sp/create";
    }

    @PostMapping("store")
    public String store(@Valid @ModelAttribute("vm")
                                DongSP dsp,
                        BindingResult result) {
        if (result.hasErrors()) {
            return "/dong_sp/create";
        } else {
//            ChucVu cv = new ChucVu();
//            cv.setMa(vm.getMa());
//            cv.setTen(vm.getTen());
            this.dongSPRepo.save(dsp);
        }
        return "redirect:/dong-sp/index";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") DongSP dsp) {
        this.dongSPRepo.delete(dsp);
        return "redirect:/dong-sp/index";
    }

    @GetMapping("edit/{id}")
    public String edit(@PathVariable("id") DongSP dsp,
                       Model model , DongSPVM vm) {
        vm.loadFormDomain(dsp);
        model.addAttribute("vm", vm);
        model.addAttribute("update", "/dong-sp/update/" + dsp.getId());
        return "/dong_sp/edit";
    }

    @PostMapping("update/{id}")
    public String update(
            @PathVariable("id") DongSP dongSP,
            @Valid @ModelAttribute("vm") DongSPVM vm,
                    BindingResult result
    ) {
        if (result.hasErrors()) {
            return "/dong_sp/edit";
        } else {
            dongSP.loadFormVM(vm);
            this.dongSPRepo.save(dongSP);
        }
        return "redirect:/dong-sp/index";
    }

}
