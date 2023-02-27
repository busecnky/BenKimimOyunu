package com.busecnky.benkimimoyunu.mapper;

import com.busecnky.benkimimoyunu.dto.request.SoruOlusturRequestDto;
import com.busecnky.benkimimoyunu.repository.entity.Soru;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ISoruMapper {

    ISoruMapper INSTANCE = Mappers.getMapper(ISoruMapper.class);

    Soru fromSoruOlusturRequestDto(final SoruOlusturRequestDto dto);


}
