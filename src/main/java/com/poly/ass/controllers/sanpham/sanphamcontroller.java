package com.poly.ass.controllers.sanpham;


import com.poly.ass.entities.sanpham.SanPham;
import com.poly.ass.repositories.sanpham.SanPhamRepository;
import com.poly.ass.request.sanpham.SanPhamVM;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("san-pham")
public class sanphamcontroller {
    @Autowired
    private SanPhamRepository sp;
    @GetMapping("index")
    public String index(Model model) {
        model.addAttribute("sanpham", sp.findAll());
        return "/san_pham/index";
    }
    @GetMapping("create")
    public String create(Model model, SanPham ms) {
        model.addAttribute("vm", ms);
        return "/san_pham/create";
    }
    @PostMapping("store")
    public String store(@Valid @ModelAttribute("vm")
                                    SanPham ms, BindingResult result
    ) {
        if (result.hasErrors()) {
            return "/san_pham/create";
        } else {
            this.sp.save(ms);
        }
        return "redirect:/san-pham/index";
    }
    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") SanPham ms) {
        this.sp.delete(ms);
        return "redirect:/san-pham/index";
    }
    @GetMapping("edit/{id}")
    public String edit(@PathVariable("id") SanPham ms,
                       Model model, SanPhamVM vm) {
        vm.loadFormDomain(ms);
        model.addAttribute("vm", vm);
        model.addAttribute("update", "/san_pham/update/" + ms.getId());
        return "san_pham/edit";
    }
    @PostMapping("update/{id}")
    public String update(@PathVariable("id") SanPham ms,
                         @Valid @ModelAttribute("vm") SanPhamVM vm,
                         BindingResult result){
        if(result.hasErrors()){
            return "/san_pham/edit";
        }else {
            ms.loadFormVM(vm);
            this.sp.save(ms);
        }
        return "redirect:/san-pham/index";
    }
}
