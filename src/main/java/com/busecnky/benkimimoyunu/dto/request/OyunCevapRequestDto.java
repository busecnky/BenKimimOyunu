package com.busecnky.benkimimoyunu.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OyunCevapRequestDto {
    private Long soruid;
    private String username;
    private String oyuncucevap;
}
