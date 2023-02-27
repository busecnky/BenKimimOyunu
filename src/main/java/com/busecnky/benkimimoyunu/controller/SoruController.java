package com.busecnky.benkimimoyunu.controller;


import com.busecnky.benkimimoyunu.dto.request.SoruOlusturRequestDto;
import com.busecnky.benkimimoyunu.dto.response.ControlResponseDto;
import com.busecnky.benkimimoyunu.service.SoruService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.busecnky.benkimimoyunu.constants.EndPoints.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(VERSION+API+SORU)
public class SoruController {

    private final SoruService soruService;

    @PostMapping(SORUOLUSTUR)
    @CrossOrigin(origins = "*")
    public ResponseEntity<ControlResponseDto> soruOlustur(@RequestBody SoruOlusturRequestDto dto){
        return ResponseEntity.ok( soruService.soruOlustur(dto));
    }


}
