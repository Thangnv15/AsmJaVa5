package com.poly.ass.repositories.chitietsp;

import com.poly.ass.entities.chitietsp.ChiTietSP;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ChiTietSPRepository extends JpaRepository<ChiTietSP, UUID> {
}
