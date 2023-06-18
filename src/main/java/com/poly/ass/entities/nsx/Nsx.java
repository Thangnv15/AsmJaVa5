package com.poly.ass.entities.nsx;

import com.poly.ass.request.mausac.MauSacVM;
import com.poly.ass.request.nsx.NsxVM;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "NSX")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Nsx {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "Id")
    private UUID id;

    @Column(name = "Ma")
    private String ma;

    @Column(name = "Ten")
    private String ten;

    public void loadFormVM(NsxVM vm) {
        this.setMa(vm.getMa());
        this.setTen(vm.getTen());
    }
}
