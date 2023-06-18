package com.poly.ass.controllers.khachhang;

import com.poly.ass.entities.khachhang.KhachHang;
import com.poly.ass.repositories.khachhang.KhachHangRepository;
import com.poly.ass.request.khachhang.KhachHangVM;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("khach-hang")
public class KhachHangController {

    @Autowired
    private KhachHangRepository khRepo;

    @GetMapping("index")
    public String index(Model model) {
        model.addAttribute("khachhang", khRepo.findAll());
        return "khach_hang/index";
    }

    @GetMapping("create")
    public String create(Model model, KhachHang kh) {
        model.addAttribute("vm", kh);
        return "khach_hang/create";
    }

    @PostMapping("store")
    public String store(@Valid @ModelAttribute("vm")
                                KhachHang kh, BindingResult result) {
        if (result.hasErrors()) {
            return "khach_hang/create";
        } else {
            this.khRepo.save(kh);
        }
        return "redirect:/khach-hang/index";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") KhachHang kh) {
        this.khRepo.delete(kh);
        return "redirect:/khach-hang/index";
    }

    @GetMapping("edit/{id}")
    public String edit(@PathVariable("id") Model model,
                       KhachHang kh,KhachHangVM vm
                       ) {
        vm.loadFormDomain(kh);
        model.addAttribute("vm", vm);
        model.addAttribute("update", "/khach-hang/update/" + kh.getId());
        return "/khach_hang/edit";
    }

    @PostMapping("update/{id}")
    public String update(@Valid @PathVariable("id") KhachHang kh,
                         @ModelAttribute("vm") KhachHangVM vm,
                         BindingResult result) {
        if (result.hasErrors()) {
            return "/khach_hang/edit";
        } else {
            kh.loadFormVM(vm);
            this.khRepo.save(kh);
        }
        return "redirect:/khach-hang/index";
    }
}
