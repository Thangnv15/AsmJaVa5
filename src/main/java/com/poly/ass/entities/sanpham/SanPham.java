package com.poly.ass.entities.sanpham;

import com.poly.ass.request.nsx.NsxVM;
import com.poly.ass.request.sanpham.SanPhamVM;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "SanPham")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SanPham {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "Id")
    private UUID id;

    @Column(name = "Ma")
    private String ma;

    @Column(name = "Ten")
    private String ten;

    public void loadFormVM(SanPhamVM vm) {
        this.setMa(vm.getMa());
        this.setTen(vm.getTen());
    }
}
