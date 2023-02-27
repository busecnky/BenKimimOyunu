package com.busecnky.benkimimoyunu.service;

import com.busecnky.benkimimoyunu.repository.ISiralamaRepository;
import com.busecnky.benkimimoyunu.repository.entity.Siralama;
import com.busecnky.benkimimoyunu.utility.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class SiralamaService extends ServiceManager<Siralama, Long> {

    private final ISiralamaRepository siralamaRepository;

    public SiralamaService(ISiralamaRepository siralamaRepository){
        super(siralamaRepository);
        this.siralamaRepository = siralamaRepository;
    }
}
