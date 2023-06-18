package com.poly.ass.entities.chitietsp;

import com.poly.ass.entities.dongsp.DongSP;
import com.poly.ass.entities.mausac.MauSac;
import com.poly.ass.entities.nsx.Nsx;
import com.poly.ass.entities.sanpham.SanPham;
import com.poly.ass.request.chitietsp.ChiTietSPVM;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "ChiTietSP")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ChiTietSP {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "Id")
    private UUID id;

    @Column(name = "NamBH")
    private int namBH;

    @Column(name = "MoTa")
    private String moTa;

    @Column(name = "SoLuongTon")
    private int soLuongTon;

    @Column(name = "GiaNhap")
    private Float giaNhap;

    @Column(name = "GiaBan")
    private Float giaBan;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdSP", referencedColumnName = "id")
    private SanPham sanPham;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdNsx", referencedColumnName = "id")
    private Nsx nsx;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdMauSac", referencedColumnName = "id")
    private MauSac mauSac;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdDongSP", referencedColumnName = "id")
    private DongSP dongSP;

    public void loadFormVM(ChiTietSPVM vm){
        this.setNamBH(Integer.valueOf(vm.getNamBH()));
        this.setMoTa(vm.getMoTa());
        this.setSoLuongTon(Integer.valueOf(vm.getSoLuongTon()));
        this.setGiaNhap(Float.valueOf(vm.getGiaNhap()));
        this.setGiaBan(Float.valueOf(vm.getGiaBan()));
    }
}
