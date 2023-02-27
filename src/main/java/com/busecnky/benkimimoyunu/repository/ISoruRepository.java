package com.busecnky.benkimimoyunu.repository;

import com.busecnky.benkimimoyunu.repository.entity.Soru;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ISoruRepository extends JpaRepository<Soru,Long> {

    Optional<Soru> findOptionalByResimAndSoruicerik(String resim, String soruicerik);
}
