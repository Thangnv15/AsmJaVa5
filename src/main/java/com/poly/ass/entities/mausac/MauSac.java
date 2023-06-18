package com.poly.ass.entities.mausac;

import com.poly.ass.request.dongsp.DongSPVM;
import com.poly.ass.request.mausac.MauSacVM;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "MauSac")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MauSac {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "Id")
    private UUID id;

    @Column(name = "Ma")
    private String ma;

    @Column(name = "Ten")
    private String ten;

    public void loadFormVM(MauSacVM vm) {
        this.setMa(vm.getMa());
        this.setTen(vm.getTen());
    }
}
