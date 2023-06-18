package com.poly.ass.entities.cuahang;

import com.poly.ass.request.cuahang.CuaHangVM;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "CuaHang")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CuaHang {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "Id")
    private UUID id;

    @Column(name = "Ma")
    private String ma;


    @Column(name = "Ten")
    private String ten;

    @Column(name = "DiaChi")
    private String diaChi;

    @Column(name = "ThanhPho")
    private String thanhPho;

    @Column(name = "QuocGia")
    private String quocGia;

    public void loadFormVM(CuaHangVM vm){
        this.setMa(vm.getMa());
        this.setTen(vm.getTen());
        this.setDiaChi(vm.getDiaChi());
        this.setThanhPho(vm.getThanhPho());
        this.setQuocGia(vm.getQuocGia());
    }
}
