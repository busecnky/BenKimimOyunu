package com.busecnky.benkimimoyunu.controller;

import com.busecnky.benkimimoyunu.dto.request.OyunCevapRequestDto;
import com.busecnky.benkimimoyunu.dto.request.OyunKatilanlarRequestDto;
import com.busecnky.benkimimoyunu.dto.response.ControlResponseDto;
import com.busecnky.benkimimoyunu.exceptions.BenKimimOyunuException;
import com.busecnky.benkimimoyunu.exceptions.ErrorType;
import com.busecnky.benkimimoyunu.service.OyunService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.busecnky.benkimimoyunu.constants.EndPoints.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(VERSION+API+OYUN)
public class OyunController {

    private final OyunService oyunService;

    @PostMapping(SAVE)
    public ResponseEntity<ControlResponseDto> oyunOlustur(@RequestBody OyunKatilanlarRequestDto dto){
        oyunService.oyunOlustur(dto);
        return ResponseEntity.ok(ControlResponseDto.builder().control(true).build());
    }

    @PostMapping(OYUNOYNA)
    public ResponseEntity<ControlResponseDto> oyunOyna(@RequestBody OyunCevapRequestDto dto){
        if (oyunService.oyunOyna(dto).isControl()){
            return ResponseEntity.ok(oyunService.oyunOyna(dto));
        }else{
            throw new BenKimimOyunuException(ErrorType.HAKKINIZ_KALMAMISTIR);
        }


    }
}
