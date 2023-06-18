package com.poly.ass.controllers.cuahang;

import com.poly.ass.entities.cuahang.CuaHang;
import com.poly.ass.repositories.cuahang.CuaHangRepository;
import com.poly.ass.request.cuahang.CuaHangVM;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("cua-hang")
public class CuaHangController {

    @Autowired
    private CuaHangRepository chRepo;

//    @Autowired
//    @Qualifier("CH1")
//    private CuaHangVM vm;

    @GetMapping("index")
    public String index(Model model) {
        model.addAttribute("cuahang", chRepo.findAll());
        return "/cua_hang/index";
    }

    @GetMapping("create")
    public String create(Model model, CuaHangVM vm) {
        model.addAttribute("vm", vm);
        return "/cua_hang/create";
    }

    @PostMapping("store")
    public String store(@Valid @ModelAttribute("vm")
                                CuaHangVM vm,
                        BindingResult result) {
        if (result.hasErrors()) {
            return "cua_hang/create";
        } else {
            CuaHang ch = new CuaHang();
            ch.setMa(vm.getMa());
            ch.setTen(vm.getTen());
            ch.setDiaChi(vm.getDiaChi());
            ch.setThanhPho(vm.getThanhPho());
            ch.setQuocGia(vm.getQuocGia());
            this.chRepo.save(ch);
        }
        return "redirect:/cua-hang/index";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") CuaHang ch) {
        this.chRepo.delete(ch);
        return "redirect:/cua-hang/index";
    }

    @GetMapping("edit/{id}")
    public String edit(@PathVariable("id") CuaHang cuaHang, Model model, CuaHangVM vm) {
        vm.loadFormDomain(cuaHang);
        model.addAttribute("vm", vm);
        model.addAttribute("update", "/cua-hang/update/" + cuaHang.getId());
        return "/cua_hang/edit";
    }

    @PostMapping("update/{id}")
    public String update(
            @PathVariable("id") CuaHang cuaHang,
            @Valid @ModelAttribute("vm") CuaHangVM vm,
            BindingResult result
    ) {
        if (result.hasErrors()) {
            return "/cua_hang/edit";
        } else {
            cuaHang.loadFormVM(vm);
            this.chRepo.save(cuaHang);
        }
        return "redirect:/cua-hang/index";
    }

}
