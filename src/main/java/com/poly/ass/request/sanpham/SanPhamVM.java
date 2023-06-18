package com.poly.ass.request.sanpham;

import com.poly.ass.entities.nsx.Nsx;
import com.poly.ass.entities.sanpham.SanPham;
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
public class SanPhamVM {

    @NotBlank(message = "không trống")
    @Length(max = 255, message = "không quá 255 kí tự")
    private String ma;

    @NotBlank(message = "không trống")
    @Length(max = 255, message = "không quá 255 kí tự")
    private String ten;

    public void loadFormDomain(SanPham sp) {
        this.setMa(sp.getMa());
        this.setTen(sp.getTen());
    }
}
