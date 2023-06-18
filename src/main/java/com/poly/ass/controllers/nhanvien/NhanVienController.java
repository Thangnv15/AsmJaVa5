package com.poly.ass.controllers.nhanvien;

import com.poly.ass.entities.chucvu.ChucVu;
import com.poly.ass.entities.cuahang.CuaHang;
import com.poly.ass.entities.nhanvien.NhanVien;
import com.poly.ass.repositories.chucvu.ChucVuRepository;
import com.poly.ass.repositories.cuahang.CuaHangRepository;
import com.poly.ass.repositories.nhanvien.NhanVienRepository;
import com.poly.ass.request.cuahang.CuaHangVM;
import com.poly.ass.request.nhanvien.NhanVienVM;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@Controller
@RequestMapping("nhan-vien")
public class NhanVienController {
    @Autowired
    private NhanVienRepository nvRepo;

    @Autowired
    private ChucVuRepository cvRepo;

    @Autowired
    private CuaHangRepository chRepo;

    @GetMapping("index")
    public String index(@RequestParam(defaultValue = "0", name = "page") Integer number, Model model) {

        Pageable pageable = PageRequest.of(number, 4);
        Page<NhanVien> nhanVienPage = nvRepo.findAll(pageable);
        model.addAttribute("nhanvien", nhanVienPage);
        return "/nhan_vien/index";
    }

    @GetMapping("search")
    public String search(@RequestParam(defaultValue = "", required = false) String keyword, Model model) {
        Pageable pageable = PageRequest.of(0, 2);
        List<NhanVien> nv = nvRepo.search(keyword, pageable);
        model.addAttribute("nhanvien", nv);
        return "nhan_vien/index";
    }

    @GetMapping("create")
    public String create(Model model, NhanVienVM vm) {
        model.addAttribute("listCH", this.chRepo.findAll());
        model.addAttribute("listCV", this.cvRepo.findAll());
        model.addAttribute("vm", vm);
        return "/nhan_vien/create";
    }

    @PostMapping("store")
    public String store(@Valid @ModelAttribute("vm")
                                NhanVienVM vm,
                        BindingResult result) {
        if (result.hasErrors()) {
            return "/nhan_vien/create";
        } else {
            NhanVien nv = new NhanVien();
            nv.setMa(vm.getMa());
            nv.setTen(vm.getTen());
            nv.setTenDem(vm.getTenDem());
            nv.setHo(vm.getHo());
            nv.setGioiTinh(vm.getGioiTinh());
            nv.setNgaySinh(vm.getNgaySinh());
            nv.setDiaChi(vm.getDiaChi());
            nv.setSdt(vm.getSdt());
            nv.setMatKhau(vm.getMatKhau());
            nv.setTrangThai(vm.getTrangThai());

            CuaHang ch = this.chRepo.findById(vm.getIdCuaHang()).get();
            nv.setCuaHang(ch);

            ChucVu cv = this.cvRepo.findById(vm.getIdChucVu()).get();
            nv.setChucVu(cv);

            this.nvRepo.save(nv);
        }
        return "redirect:/nhan-vien/index";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") NhanVien nv) {
        this.nvRepo.delete(nv);
        return "redirect:/nhan-vien/index";
    }

    @GetMapping("edit/{id}")
    public String edit(@PathVariable("id") NhanVien nhanVien,
                       Model model, NhanVienVM vm) {
        vm.loadFormDomain(nhanVien);
        model.addAttribute("vm", vm);
        model.addAttribute("update", "/nhan-vien/update/" + nhanVien.getId());
        return "/nhan_vien/edit";
    }

    @PostMapping("update/{id}")
    public String update(
            @PathVariable("id") NhanVien nhanVien,
            @Valid @ModelAttribute("vm") NhanVienVM vm,
            BindingResult result
    ) {
        if (result.hasErrors()) {
            return "/nhan_vien/edit";
        } else {
            nhanVien.loadFormVM(vm);
            this.nvRepo.save(nhanVien);
        }
        return "redirect:/nhan-vien/index";
    }


}
