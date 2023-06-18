package com.poly.ass.request.chitietsp;

import com.poly.ass.entities.chitietsp.ChiTietSP;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ChiTietSPVM {

    @NotBlank(message = "Không để trống")
    @Length(message = "Năm BH > 2000 & <=2200")
    private int namBH;

    @NotBlank(message = "Không để trống")
    @Length(max = 255, message = "Không vượt quá 255 kí tự")
    private String moTa;

    @NotBlank(message = "Không để trống")
    @PositiveOrZero
    private int soLuongTon;

    @NotBlank(message = "Không để trống")
    @PositiveOrZero
    private Float giaNhap;

    @NotBlank(message = "Không để trống")
    @PositiveOrZero
    private Float giaBan;

    private UUID idSP;

    private UUID idMauSac;

    private UUID idDongSP;

    private UUID idNsx;

    public void loadFormDomain(ChiTietSP ctsp) {
        this.setNamBH(Integer.valueOf(ctsp.getNamBH()));
        this.setMoTa(ctsp.getMoTa());
        this.setSoLuongTon(Integer.valueOf(ctsp.getSoLuongTon()));
        this.setGiaNhap(Float.valueOf(ctsp.getGiaNhap()));
        this.setGiaBan(Float.valueOf(ctsp.getGiaBan()));
    }
}
