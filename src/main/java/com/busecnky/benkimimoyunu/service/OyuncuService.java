package com.busecnky.benkimimoyunu.service;


import com.busecnky.benkimimoyunu.dto.request.OyuncuCreateRequestDto;
import com.busecnky.benkimimoyunu.dto.response.ControlResponseDto;
import com.busecnky.benkimimoyunu.dto.response.OyuncuFindResponseDto;
import com.busecnky.benkimimoyunu.dto.response.OyuncuResponseDto;
import com.busecnky.benkimimoyunu.exceptions.BenKimimOyunuException;
import com.busecnky.benkimimoyunu.exceptions.ErrorType;
import com.busecnky.benkimimoyunu.mapper.IOyuncuMapper;
import com.busecnky.benkimimoyunu.repository.IOyuncuRepository;
import com.busecnky.benkimimoyunu.repository.entity.Oyuncu;
import com.busecnky.benkimimoyunu.utility.ServiceManager;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OyuncuService extends ServiceManager<Oyuncu, Long> {

    private final IOyuncuRepository oyuncuRepository;

    public OyuncuService(IOyuncuRepository oyuncuRepository){
        super(oyuncuRepository);
        this.oyuncuRepository = oyuncuRepository;
    }

    public ControlResponseDto save(OyuncuCreateRequestDto dto) {
        Oyuncu oyuncu = IOyuncuMapper.INSTANCE.fromOyuncuCreateRequestDto(dto);
        Optional<Oyuncu> oyuncuKontrol = oyuncuRepository.findOptionalByUsername(dto.getUsername());
        if(oyuncuKontrol.isEmpty()) {
            save(oyuncu);
            return new ControlResponseDto(true);
        }else{
            throw new BenKimimOyunuException(ErrorType.BAD_REQUEST_ERROR);
        }
    }

    public ControlResponseDto login(OyuncuCreateRequestDto dto) {
        Optional<Oyuncu> oyuncu = oyuncuRepository.findOptionalByUsernameAndPassword(dto.getUsername(), dto.getPassword());
        if (oyuncu.isPresent()){
            return new ControlResponseDto(true);
        }
        else{
            throw new BenKimimOyunuException(ErrorType.KULLANICI_BULUNAMADI);
        }
    }

    public List<OyuncuResponseDto> findAllOyuncuDto() {
        List<OyuncuResponseDto> result = new ArrayList<>();

        findAll().forEach(x->{


            result.add(IOyuncuMapper.INSTANCE.oyuncuResponseDtoFromOyuncu(x));
        });
        return result;


    }

    public OyuncuFindResponseDto findByUsername(OyuncuCreateRequestDto dto) {
        Optional<Oyuncu> oyuncuFind = oyuncuRepository.findOptionalByUsername(dto.getUsername());
        OyuncuFindResponseDto oyuncuFindResponseDto = IOyuncuMapper.INSTANCE
                .oyuncuFindResponseDtoFromOyuncu(oyuncuFind.get());
        return oyuncuFindResponseDto;


    }
}
