package com.busecnky.benkimimoyunu.repository;

import com.busecnky.benkimimoyunu.repository.entity.Oyuncu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IOyuncuRepository extends JpaRepository<Oyuncu,Long> {

    Optional<Oyuncu> findOptionalByUsername(String username);
    Optional<Oyuncu> findOptionalByUsernameAndPassword(String username,String password);


}
