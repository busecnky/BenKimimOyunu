package com.busecnky.benkimimoyunu.controller;


import com.busecnky.benkimimoyunu.dto.request.OyuncuCreateRequestDto;
import com.busecnky.benkimimoyunu.dto.response.ControlResponseDto;
import com.busecnky.benkimimoyunu.dto.response.OyuncuFindResponseDto;
import com.busecnky.benkimimoyunu.dto.response.OyuncuResponseDto;
import com.busecnky.benkimimoyunu.repository.entity.Oyuncu;
import com.busecnky.benkimimoyunu.service.OyuncuService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.busecnky.benkimimoyunu.constants.EndPoints.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(VERSION+API+OYUNCU)
public class OyuncuController {

    private final OyuncuService oyuncuService;
    @PostMapping(OYUNCUREGISTER)
    @CrossOrigin(origins = "*")
    public ResponseEntity<ControlResponseDto> registerOyuncu(@RequestBody OyuncuCreateRequestDto dto){
        return ResponseEntity.ok(oyuncuService.save(dto));
    }

    @PostMapping(OYUNCULOGIN)
    @CrossOrigin(origins = "*")
    public ResponseEntity<ControlResponseDto> loginOyuncu(@RequestBody OyuncuCreateRequestDto dto){
        return ResponseEntity.ok(oyuncuService.login(dto));
    }

    @GetMapping(FINDBYUSERNAME)
    @CrossOrigin(origins = "*")
    public ResponseEntity<OyuncuFindResponseDto> findByUsername(@RequestBody OyuncuCreateRequestDto dto){
        return ResponseEntity.ok(oyuncuService.findByUsername(dto));
    }

    @GetMapping(FINDALL)
    @CrossOrigin(origins = "*")
    public ResponseEntity<List<OyuncuResponseDto>> findallOyuncu(){
        return ResponseEntity.ok(oyuncuService.findAllOyuncuDto());
    }






}
