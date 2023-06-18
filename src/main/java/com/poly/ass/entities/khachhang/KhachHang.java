package com.poly.ass.entities.khachhang;

import com.poly.ass.request.khachhang.KhachHangVM;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.util.UUID;

import static java.sql.Date.valueOf;


@Entity
@Table(name = "KhachHang")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class KhachHang {
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

    @Column(name = "NgaySinh")
    private Date ngaySinh;

    @Column(name = "Sdt")
    private String sdt;

    @Column(name = "DiaChi")
    private String diaChi;

    @Column(name = "ThanhPho")
    private String thanhPho;

    @Column(name = "QuocGia")
    private String quocGia;

    @Column(name = "MatKhau")
    private String matKhau;

    public void loadFormVM(KhachHangVM vm){
        this.setMa(vm.getMa());
        this.setTen(vm.getTen());
        this.setTenDem(vm.getTenDem());
        this.setHo(vm.getHo());
        this.setNgaySinh(valueOf(String.valueOf(vm.getNgaySinh())));
        this.setSdt(vm.getSdt());
        this.setDiaChi(vm.getDiaChi());
        this.setThanhPho(vm.getThanhPho());
        this.setQuocGia(vm.getQuocGia());
        this.setMatKhau(vm.getMatKhau());
    }

}
