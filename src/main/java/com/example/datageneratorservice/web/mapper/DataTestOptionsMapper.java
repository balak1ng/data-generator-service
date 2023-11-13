package com.example.datageneratorservice.web.mapper;

import com.example.datageneratorservice.model.DataTestOptions;
import com.example.datageneratorservice.web.dto.DataTestOptionsDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DataTestOptionsMapper
        extends Mappable<DataTestOptions, DataTestOptionsDto> {
}
