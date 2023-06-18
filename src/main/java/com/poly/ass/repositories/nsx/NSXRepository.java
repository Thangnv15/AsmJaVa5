package com.poly.ass.repositories.nsx;

import com.poly.ass.entities.nsx.Nsx;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface NSXRepository extends JpaRepository<Nsx, UUID> {
}
