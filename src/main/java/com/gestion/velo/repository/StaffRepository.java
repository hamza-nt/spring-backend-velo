package com.gestion.velo.repository;

import com.gestion.velo.entity.Staff;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffRepository extends JpaRepository<Staff, Integer> {
    Staff findByEmail(String email);
}
