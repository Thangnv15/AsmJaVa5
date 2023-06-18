package com.poly.ass.request.nhanvien;

import com.poly.ass.entities.cuahang.CuaHang;
import com.poly.ass.entities.nhanvien.NhanVien;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.sql.Date;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class NhanVienVM {
    @NotBlank(message = "Không được trống")
    @Length(max = 255, message = "Không vượt quá 255 kí tự")
    private String ma;

    @NotBlank(message = "Không được trống")
    @Length(max = 255, message = "Không vượt quá 255 kí tự")
    private String ten;

    @NotBlank(message = "Không được trống")
    @Length(max = 255, message = "Không vượt quá 255 kí tự")
    private String tenDem;

    @NotBlank(message = "Không được trống")
    @Length(max = 255, message = "Không vượt quá 255 kí tự")
    private String ho;

    @NotNull(message = "Không được trống")
    private String gioiTinh;


    //    @NotBlank(message = "Không được trống")
//    @Length(max = 255 ,message = "Không vượt quá 255 kí tự")
//    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date ngaySinh;

    @NotBlank(message = "Không được trống")
    @Length(max = 255, message = "Không vượt quá 255 kí tự")
    private String diaChi;

    @NotBlank(message = "Không được trống")
    @Length(max = 10, message = "không lớn hơn 10 số")
    @Pattern(regexp = "^\\d{10}$")
    private String sdt;

    @NotBlank(message = "Không được trống")
    @Length(min = 6, max = 12, message = "không quá 8 kí tự")
    private String matKhau;

    private UUID idCuaHang;

    private UUID idChucVu;

    //    @NotEmpty(message = "Trạng thái gì?")
    private int trangThai;

    public void loadFormDomain(NhanVien nv) {
        this.setMa(nv.getMa());
        this.setTen(nv.getTen());
        this.setTenDem(nv.getTenDem());
        this.setHo(nv.getHo());
        this.setGioiTinh(nv.getGioiTinh());
        this.setNgaySinh(Date.valueOf(String.valueOf(nv.getNgaySinh())));
        this.setDiaChi(nv.getDiaChi());
        this.setSdt(nv.getSdt());
        this.setMatKhau(nv.getMatKhau());
        this.setTrangThai(Integer.valueOf(nv.getTrangThai()));
    }
}
