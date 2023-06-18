package com.poly.ass.controllers.chitietsp;

import com.poly.ass.entities.chitietsp.ChiTietSP;
import com.poly.ass.entities.dongsp.DongSP;
import com.poly.ass.entities.mausac.MauSac;
import com.poly.ass.entities.nsx.Nsx;
import com.poly.ass.entities.sanpham.SanPham;
import com.poly.ass.repositories.chitietsp.ChiTietSPRepository;
import com.poly.ass.repositories.dongsp.DongSPRepository;
import com.poly.ass.repositories.mausac.MauSacRepository;
import com.poly.ass.repositories.nsx.NSXRepository;
import com.poly.ass.repositories.sanpham.SanPhamRepository;
import com.poly.ass.request.chitietsp.ChiTietSPVM;
import com.poly.ass.request.dongsp.DongSPVM;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("chi-tiet-sp")
public class ChiTietSPController {
    @Autowired
    private ChiTietSPRepository ctspRepo;

    @Autowired
    private DongSPRepository dongSPRepo;

    @Autowired
    private MauSacRepository msRepo;

    @Autowired
    private SanPhamRepository spRepo;

    @Autowired
    private NSXRepository nsxRepo;

    @GetMapping("index")
    private String index(@RequestParam(defaultValue = "0",name = "page") Integer number, Model model) {
        Pageable pageable = PageRequest.of(number, 4);
        Page<ChiTietSP> ctsp = ctspRepo.findAll(pageable);
        List<ChiTietSP> listCTSP = ctspRepo.findAll();
        model.addAttribute("chitietsp", ctsp);
        return "chi_tiet_sp/index";
    }

    @GetMapping("create")
    private String create(Model model, ChiTietSPVM vm) {
        model.addAttribute("listDSP",this.dongSPRepo.findAll());
        model.addAttribute("listNsx",this.nsxRepo.findAll());
        model.addAttribute("listSP",this.spRepo.findAll());
        model.addAttribute("listMS",this.msRepo.findAll());
        model.addAttribute("vm", vm);
        return "chi_tiet_sp/create";
    }

    @PostMapping("store")
    public String store(@Valid @ModelAttribute("vm")
                                ChiTietSP ctsp, ChiTietSPVM vm,
                        BindingResult result) {
        if (result.hasErrors()) {
            return "/chi_tiet_sp/create";
        } else {
            Nsx nsx = this.nsxRepo.findById(vm.getIdNsx()).get();
            ctsp.setNsx(nsx);

            SanPham sp = this.spRepo.findById(vm.getIdSP()).get();
            ctsp.setSanPham(sp);

            DongSP dsp = this.dongSPRepo.findById(vm.getIdDongSP()).get();
            ctsp.setDongSP(dsp);

            MauSac ms = this.msRepo.findById(vm.getIdMauSac()).get();
            ctsp.setMauSac(ms);

            this.ctspRepo.save(ctsp);
        }
        return "redirect:/chi-tiet-sp/index";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") ChiTietSP ctsp){
        this.ctspRepo.delete(ctsp);
        return "redirect:/chi-tiet-sp/index";
    }

    @GetMapping("edit/{id}")
    public String edit(@PathVariable("id") ChiTietSP ctsp,
                       Model model, ChiTietSPVM vm){
        vm.loadFormDomain(ctsp);
        model.addAttribute("vm",vm);
        model.addAttribute("update","/chi-tiet-sp/update/" +ctsp.getId());
        return "chi_tiet_sp/edit";
    }

    @PostMapping("update/{id}")
    public String update(@PathVariable("id") @Valid @ModelAttribute("vm")
                         ChiTietSP ctsp, ChiTietSPVM vm, BindingResult result){
        if(result.hasErrors()){
            return "chi_tiet_sp/edit";
        }else {
            ctsp.loadFormVM(vm);
            this.ctspRepo.save(ctsp);
        }
        return "redirect:/chi-tiet-sp/index";
    }
}
