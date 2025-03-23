package com.hrportal.repository;

import com.hrportal.model.Hr;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HrRepository extends JpaRepository<Hr, Long> {
    Optional<Hr> findByEmail(String email);
}
