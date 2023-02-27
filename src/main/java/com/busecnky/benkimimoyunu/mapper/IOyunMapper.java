package com.busecnky.benkimimoyunu.mapper;

import com.busecnky.benkimimoyunu.dto.request.OyunCevapRequestDto;
import com.busecnky.benkimimoyunu.dto.request.OyunKatilanlarRequestDto;
import com.busecnky.benkimimoyunu.repository.entity.Oyun;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IOyunMapper {

    IOyunMapper INSTANCE = Mappers.getMapper(IOyunMapper.class);

    Oyun toOyun(final OyunKatilanlarRequestDto oyunKatilanlarRequestDto);
    Oyun toOyun(final OyunCevapRequestDto oyunCevapRequestDto);
}
