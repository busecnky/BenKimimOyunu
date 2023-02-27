package com.busecnky.benkimimoyunu.service;


import com.busecnky.benkimimoyunu.dto.request.OyunCevapRequestDto;
import com.busecnky.benkimimoyunu.dto.request.OyunKatilanlarRequestDto;
import com.busecnky.benkimimoyunu.dto.response.ControlResponseDto;
import com.busecnky.benkimimoyunu.exceptions.BenKimimOyunuException;
import com.busecnky.benkimimoyunu.exceptions.ErrorType;
import com.busecnky.benkimimoyunu.mapper.IOyunMapper;
import com.busecnky.benkimimoyunu.mapper.IOyuncuMapper;
import com.busecnky.benkimimoyunu.repository.IOyunRepository;
import com.busecnky.benkimimoyunu.repository.IOyuncuRepository;
import com.busecnky.benkimimoyunu.repository.entity.Oyun;
import com.busecnky.benkimimoyunu.repository.entity.Oyuncu;
import com.busecnky.benkimimoyunu.repository.entity.Soru;
import com.busecnky.benkimimoyunu.utility.ServiceManager;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Service
public class OyunService extends ServiceManager<Oyun, Long> {

    private final IOyunRepository oyunRepository;
    private final IOyuncuRepository oyuncuRepository;
    @Autowired
    private SoruService soruService;

    public OyunService(IOyunRepository oyunRepository,IOyuncuRepository oyuncuRepository){
        super(oyunRepository);
        this.oyunRepository = oyunRepository;
        this.oyuncuRepository = oyuncuRepository;
    }
    @PostMapping()
    public ControlResponseDto oyunOyna(OyunCevapRequestDto dto) {
        Optional<Oyun> oyun = oyunRepository.findByUsername(dto.getUsername());
        Optional<Oyuncu> oyuncu = oyuncuRepository.findOptionalByUsername(dto.getUsername());

        if (oyun.isPresent()) {
            Optional<Soru> soru = soruService.findById(dto.getSoruid());
            if (!dto.getOyuncucevap().equalsIgnoreCase(soru.get().getDogruCevap())) {
                if(oyun.get().getHak() !=0){
                    oyun.get().setHak(oyun.get().getHak()-1);
                    oyun.get().setPuan(oyun.get().getHak());
                    update(oyun.get());
                    return new ControlResponseDto(true);
                }else{
                    return new ControlResponseDto(false);
                }

            } else {
                oyun.get().setOyuncucevap(dto.getOyuncucevap());
                oyuncu.get().setToplampuan(oyun.get().getPuan());
                update(oyun.get());
            }
        }
        return new ControlResponseDto(true);
    }

    public ControlResponseDto oyunOlustur(OyunKatilanlarRequestDto dto) {
        Oyun oyun = IOyunMapper.INSTANCE.toOyun(dto);

        oyun.setHak(5);
        save(oyun);
        return new ControlResponseDto(true);
    }


}

