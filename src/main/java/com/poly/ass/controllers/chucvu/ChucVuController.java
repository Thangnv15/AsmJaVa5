package com.poly.ass.controllers.chucvu;

import com.poly.ass.entities.chucvu.ChucVu;
import com.poly.ass.entities.nhanvien.NhanVien;
import com.poly.ass.repositories.chucvu.ChucVuRepository;
import com.poly.ass.repositories.nhanvien.NhanVienRepository;
import com.poly.ass.request.chucvu.ChucVuVM;
import com.poly.ass.request.nhanvien.NhanVienVM;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("chuc-vu")
public class ChucVuController {
    @Autowired
    private ChucVuRepository cvRepo;

    @GetMapping("index")
    public String index(Model model) {
        model.addAttribute("chucvu", cvRepo.findAll());
        return "/chuc_vu/index";
    }

    @GetMapping("create")
    public String create(Model model, ChucVuVM vm) {
        model.addAttribute("vm", vm);
        return "/chuc_vu/create";
    }

    @PostMapping("store")
    public String store(@Valid @ModelAttribute("vm")
                                ChucVuVM vm,
                        BindingResult result) {
        if (result.hasErrors()) {
            return "/chuc_vu/create";
        } else {
            ChucVu cv = new ChucVu();
            cv.setMa(vm.getMa());
            cv.setTen(vm.getTen());
            this.cvRepo.save(cv);
        }
        return "redirect:/chuc-vu/index";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") ChucVu cv) {
        this.cvRepo.delete(cv);
        return "redirect:/chuc-vu/index";
    }

    @GetMapping("edit/{id}")
    public String edit(@PathVariable("id") ChucVu chucVu,
                       Model model, ChucVuVM vm) {
        vm.loadFormDomain(chucVu);
        model.addAttribute("vm", vm);
        model.addAttribute("update", "/chuc-vu/update/" + chucVu.getId());
        return "/chuc_vu/edit";
    }

    @PostMapping("update/{id}")
    public String update(
            @PathVariable("id") ChucVu chucVu,
            @Valid @ModelAttribute("vm") ChucVuVM vm,
            BindingResult result
    ) {
        if (result.hasErrors()) {
            return "/chuc_vu/edit";
        } else {
            chucVu.loadFormVM(vm);
            this.cvRepo.save(chucVu);
        }
        return "redirect:/chuc-vu/index";
    }

}
