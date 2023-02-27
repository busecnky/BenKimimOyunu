package com.busecnky.benkimimoyunu.controller;

import com.busecnky.benkimimoyunu.service.SiralamaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.busecnky.benkimimoyunu.constants.EndPoints.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(VERSION+API+SIRALAMA)
public class SiralamaController {
    private final SiralamaService siralamaService;


}
