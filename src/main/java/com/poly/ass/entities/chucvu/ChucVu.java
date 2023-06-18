package com.poly.ass.entities.chucvu;

import com.poly.ass.request.chucvu.ChucVuVM;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "ChucVu")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ChucVu {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "Id")
    private UUID id;

    @Column(name = "Ma")
    private String ma;

    @Column(name = "Ten")
    private String ten;

    public void loadFormVM(ChucVuVM vm){
        this.setMa(vm.getMa());
        this.setTen(vm.getTen());
    }
}
