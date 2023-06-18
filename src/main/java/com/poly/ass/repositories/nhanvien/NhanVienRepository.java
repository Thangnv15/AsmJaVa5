package com.poly.ass.repositories.nhanvien;

import com.poly.ass.entities.nhanvien.NhanVien;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface NhanVienRepository extends JpaRepository<NhanVien, UUID> {
    @Query("select nv from NhanVien nv where nv.ten=:keyword or nv.ma=:keyword")
    List<NhanVien> search(String keyword, Pageable pageable);
}
