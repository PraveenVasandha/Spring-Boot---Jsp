package com.aequalis.company.teamleader.mapper;

import com.aequalis.company.teamleader.dao.TlDao;
import com.aequalis.company.teamleader.dto.TlDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface TlMapper {

    TlMapper TL_MAPPER= Mappers.getMapper(TlMapper.class);

    @Mapping(target = "id",source = "teamLeadeId")
    @Mapping(target = "name",source = "teamLeaderName")
    TlDto tlDto(TlDao tlDao);

    @Mapping(target = "teamLeadeId",source = "id")
    @Mapping(target = "teamLeaderName",source = "name")
    TlDao tlDao(TlDto tlDto);


    List<TlDto> tlDtoList(List<TlDao> tlDaoList);

    List<TlDao> tlDaoList(List<TlDto> tlDtoList);

}
