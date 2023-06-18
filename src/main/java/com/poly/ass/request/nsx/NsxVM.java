package com.poly.ass.request.nsx;

import com.poly.ass.entities.mausac.MauSac;
import com.poly.ass.entities.nsx.Nsx;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class NsxVM {
    @NotBlank(message = "không trống")
    @Length(max = 255, message = "không quá 255 kí tự")
    private String ma;

    @NotBlank(message = "không trống")
    @Length(max = 255, message = "không quá 255 kí tự")
    private String ten;

    public void loadFormDomain(Nsx nsx){
        this.setMa(nsx.getMa());
        this.setTen(nsx.getTen());
    }
}
