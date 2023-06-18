package com.poly.ass.request.cuahang;

import com.poly.ass.entities.cuahang.CuaHang;
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
public class CuaHangVM {

    @NotBlank(message = "không để trống")
    @Length(max = 255, message = "không quá 255 kí tự")
    private String ma;

    @NotBlank(message = "không để trống")
    @Length(max = 255, message = "không quá 255 kí tự")
    private String ten;

    @NotBlank(message = "không để trống")
    @Length(max = 255, message = "không quá 255 kí tự")
    private String diaChi;

    @NotBlank(message = "không để trống")
    @Length(max = 255, message = "không quá 255 kí tự")
    private String thanhPho;

    @NotBlank(message = "không để trống")
    @Length(max = 255, message = "không quá 255 kí tự")
    private String quocGia;

    public void loadFormDomain(CuaHang domainModel) {
        this.setMa(domainModel.getMa());
        this.setTen(domainModel.getTen());
        this.setDiaChi(domainModel.getDiaChi());
        this.setThanhPho(domainModel.getThanhPho());
        this.setQuocGia(domainModel.getQuocGia());
    }
}
