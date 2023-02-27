package com.busecnky.benkimimoyunu.service;

import com.busecnky.benkimimoyunu.dto.request.SoruOlusturRequestDto;
import com.busecnky.benkimimoyunu.dto.response.ControlResponseDto;
import com.busecnky.benkimimoyunu.exceptions.BenKimimOyunuException;
import com.busecnky.benkimimoyunu.exceptions.ErrorType;
import com.busecnky.benkimimoyunu.mapper.IOyuncuMapper;
import com.busecnky.benkimimoyunu.mapper.ISoruMapper;
import com.busecnky.benkimimoyunu.repository.ISoruRepository;
import com.busecnky.benkimimoyunu.repository.entity.Oyuncu;
import com.busecnky.benkimimoyunu.repository.entity.Soru;
import com.busecnky.benkimimoyunu.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SoruService extends ServiceManager<Soru, Long> {

    private final ISoruRepository soruRepository;

    public SoruService(ISoruRepository soruRepository){
        super(soruRepository);
        this.soruRepository = soruRepository;
    }


    public ControlResponseDto soruOlustur(SoruOlusturRequestDto dto) {
        Soru soru = ISoruMapper.INSTANCE.fromSoruOlusturRequestDto(dto);
        Optional<Soru> soruKontrol = soruRepository.findOptionalByResimAndSoruicerik(dto.getResim(), dto.getSoruicerik());
        if (soruKontrol.isEmpty()) {
            save(soru);
            return new ControlResponseDto(true);
        } else {
            throw new BenKimimOyunuException(ErrorType.BAD_REQUEST_ERROR);
        }
    }



}
