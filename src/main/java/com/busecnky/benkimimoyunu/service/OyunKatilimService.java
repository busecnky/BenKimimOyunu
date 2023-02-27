package com.busecnky.benkimimoyunu.service;


import com.busecnky.benkimimoyunu.repository.IOyunKatilimRepository;
import com.busecnky.benkimimoyunu.repository.entity.OyunKatilim;
import com.busecnky.benkimimoyunu.utility.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class OyunKatilimService extends ServiceManager<OyunKatilim, Long> {

    private final IOyunKatilimRepository oyunKatilimRepository;

    public OyunKatilimService(IOyunKatilimRepository oyunKatilimRepository){
        super(oyunKatilimRepository);
        this.oyunKatilimRepository = oyunKatilimRepository;
    }
}
