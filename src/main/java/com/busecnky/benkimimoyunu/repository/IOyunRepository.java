package com.busecnky.benkimimoyunu.repository;

import com.busecnky.benkimimoyunu.repository.entity.Oyun;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IOyunRepository extends JpaRepository<Oyun,Long> {
    Optional<Oyun> findByUsername(String username);
}
