package com.busecnky.benkimimoyunu.repository;

import com.busecnky.benkimimoyunu.repository.entity.Siralama;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICevapRepository extends JpaRepository<Siralama,Long> {
}
