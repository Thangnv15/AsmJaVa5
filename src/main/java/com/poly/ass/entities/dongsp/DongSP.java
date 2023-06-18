package com.poly.ass.entities.dongsp;


import com.poly.ass.request.dongsp.DongSPVM;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "DongSP")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DongSP {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "Id")
    private UUID id;

    @Column(name = "Ma")
    private String ma;

    @Column(name = "Ten")
    private String ten;

    public void loadFormVM(DongSPVM vm){
        this.setMa(vm.getMa());
        this.setTen(vm.getTen());
    }
}
