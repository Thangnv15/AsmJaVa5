package com.poly.ass.request.dongsp;

import com.poly.ass.entities.dongsp.DongSP;
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
public class DongSPVM {

    @NotBlank(message = "không trống")
    @Length(max = 255, message = "không quá 255 kí tự")
    private String ma;

    @NotBlank(message = "không trống")
    @Length(max = 255, message = "không quá 255 kí tự")
    private String ten;

    public void loadFormDomain(DongSP dsp){
        this.setMa(dsp.getMa());
        this.setTen(dsp.getTen());
    }
}
