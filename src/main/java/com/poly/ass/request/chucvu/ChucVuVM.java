package com.poly.ass.request.chucvu;

import com.poly.ass.entities.chucvu.ChucVu;
import jakarta.persistence.Column;
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
public class ChucVuVM {

    @NotBlank(message = "Không được trống")
    @Length(max = 255 ,message = "Không vượt quá 255 kí tự")
    private String ma;

    @NotBlank(message = "Không được trống")
    @Length(max = 255 ,message = "Không vượt quá 255 kí tự")
    private String ten;

    public void loadFormDomain(ChucVu cv){
        this.setMa(cv.getMa());
        this.setTen(cv.getTen());
    }
}
