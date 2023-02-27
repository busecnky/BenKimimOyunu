package com.busecnky.benkimimoyunu.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SoruOlusturRequestDto {

    private String resim;
    private String soruicerik;
    private String dogruCevap;
}
