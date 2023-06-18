package com.poly.ass.request.khachhang;

import com.poly.ass.entities.khachhang.KhachHang;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.sql.Date;

import static java.sql.Date.valueOf;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class KhachHangVM {

    @NotBlank(message = "Không được trống")
    @Length(max = 255 ,message = "Không vượt quá 255 kí tự")
    private String ma;

    @NotBlank(message = "Không được trống")
    @Length(max = 255 ,message = "Không vượt quá 255 kí tự")
    private String ten;


    @NotBlank(message = "Không được trống")
    @Length(max = 255 ,message = "Không vượt quá 255 kí tự")
    private String tenDem;

    @NotBlank(message = "Không được trống")
    @Length(max = 255 ,message = "Không vượt quá 255 kí tự")
    private String ho;


//    @NotBlank(message = "Không được trống")
//    @Length(max = 255 ,message = "Không vượt quá 255 kí tự")
//    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date ngaySinh;

    @NotBlank(message = "Không được trống")
    @Length(max = 10, message = "không lớn hơn 10 số")
    @Pattern(regexp = "^\\d{10}$")
    private String sdt;

    @NotBlank(message = "Không được trống")
    @Length(max = 255 ,message = "Không vượt quá 255 kí tự")
    private String diaChi;

    @NotBlank(message = "Không được trống")
    @Length(max = 255 ,message = "Không vượt quá 255 kí tự")
    private String thanhPho;

    @NotBlank(message = "Không được trống")
    @Length(max = 255 ,message = "Không vượt quá 255 kí tự")
    private String quocGia;


    @NotBlank(message = "Không được trống")
    @Length(min = 6,max = 12 , message = "không quá 8 kí tự")
    private String matKhau;

    public void loadFormDomain(KhachHang kh){
        this.setMa(kh.getMa());
        this.setTen(kh.getTen());
        this.setTenDem(kh.getTenDem());
        this.setHo(kh.getHo());
        this.setNgaySinh(valueOf(String.valueOf(kh.getNgaySinh())));
        this.setSdt(kh.getSdt());
        this.setDiaChi(kh.getDiaChi());
        this.setThanhPho(kh.getThanhPho());
        this.setQuocGia(kh.getQuocGia());
        this.setMatKhau(kh.getMatKhau());
    }
}
