package com.busecnky.benkimimoyunu.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OyuncuResponseDto {

    String username;
    int toplampuan;
    int hak;
}
