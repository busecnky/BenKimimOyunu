package com.busecnky.benkimimoyunu.mapper;


import com.busecnky.benkimimoyunu.dto.request.OyuncuCreateRequestDto;
import com.busecnky.benkimimoyunu.dto.response.OyuncuFindResponseDto;
import com.busecnky.benkimimoyunu.dto.response.OyuncuResponseDto;
import com.busecnky.benkimimoyunu.repository.entity.Oyuncu;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IOyuncuMapper {

    IOyuncuMapper INSTANCE = Mappers.getMapper(IOyuncuMapper.class);

    Oyuncu fromOyuncuCreateRequestDto(final OyuncuCreateRequestDto dto);

    OyuncuResponseDto oyuncuResponseDtoFromOyuncu(final Oyuncu oyuncu);
    OyuncuFindResponseDto  oyuncuFindResponseDtoFromOyuncu(final Oyuncu oyuncu);
}
