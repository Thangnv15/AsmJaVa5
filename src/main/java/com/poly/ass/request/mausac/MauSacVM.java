package com.poly.ass.request.mausac;

import com.poly.ass.entities.mausac.MauSac;
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
public class MauSacVM {
    @NotBlank(message = "không trống")
    @Length(max = 255, message = "không quá 255 kí tự")
    private String ma;

    @NotBlank(message = "không trống")
    @Length(max = 255, message = "không quá 255 kí tự")
    private String ten;

    public void loadFormDomain(MauSac ms){
        this.setMa(ms.getMa());
        this.setTen(ms.getTen());
    }
}
