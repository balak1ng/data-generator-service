package com.example.datageneratorservice.web.dto;

import com.example.datageneratorservice.model.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
/*
 Симуляция отправки каждые несколько секунд в очередь.
 */
public class DataTestOptionsDto {
    private int delayInSeconds;
    private Data.MeasurementType[] measurementTypes;
}

