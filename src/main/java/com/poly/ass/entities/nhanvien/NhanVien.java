package com.poly.ass.entities.nhanvien;

import com.poly.ass.entities.chucvu.ChucVu;
import com.poly.ass.entities.cuahang.CuaHang;
import com.poly.ass.request.nhanvien.NhanVienVM;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.util.UUID;

import static java.sql.Date.*;

@Entity
@Table(name = "NhanVien")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class NhanVien {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "Id")
    private UUID id;

    @Column(name = "Ma")
    private String ma;

    @Column(name = "Ten")
    private String ten;

    @Column(name = "TenDem")
    private String tenDem;

    @Column(name = "Ho")
    private String ho;

    @Column(name = "GioiTinh")
    private String gioiTinh;

    @Column(name = "NgaySinh")
    private Date ngaySinh;

    @Column(name = "DiaChi")
    private String diaChi;


    @Column(name = "Sdt")
    private String sdt;

    @Column(name = "MatKhau")
    private String matKhau;

    @Column(name = "TrangThai")
    private Integer trangThai;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdCH" , referencedColumnName = "id")
    private CuaHang cuaHang;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdCV",referencedColumnName = "id")
    private ChucVu chucVu;

    public void loadFormVM(NhanVienVM vm) {
        this.setMa(vm.getMa());
        this.setTen(vm.getTen());
        this.setTenDem(vm.getTenDem());
        this.setHo(vm.getHo());
        this.setGioiTinh(vm.getGioiTinh());
        this.setNgaySinh(valueOf(String.valueOf(vm.getNgaySinh())));
        this.setDiaChi(vm.getDiaChi());
        this.setSdt(vm.getSdt());
        this.setMatKhau(vm.getMatKhau());
        this.setTrangThai(Integer.valueOf(vm.getTrangThai()));
    }
}

