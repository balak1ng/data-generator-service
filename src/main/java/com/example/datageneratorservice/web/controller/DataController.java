package com.example.datageneratorservice.web.controller;

import com.example.datageneratorservice.model.Data;
import com.example.datageneratorservice.model.DataTestOptions;
import com.example.datageneratorservice.service.KafkaDataService;
import com.example.datageneratorservice.service.TestDataService;
import com.example.datageneratorservice.web.dto.DataDto;
import com.example.datageneratorservice.web.dto.DataTestOptionsDto;
import com.example.datageneratorservice.web.mapper.DataMapper;
import com.example.datageneratorservice.web.mapper.DataTestOptionsMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/data")
@RequiredArgsConstructor
public class DataController {
    private final KafkaDataService kafkaDataService;
    private final TestDataService testDataService;
    private final DataMapper dataMapper;
    private final DataTestOptionsMapper dataTestOptionsMapper;

    @PostMapping("/send")
    public void send(@RequestBody DataDto dto) {
        Data data = dataMapper.toEntity(dto);
        kafkaDataService.send(data);
    }

    @PostMapping("/test/send")
    public void testSend(@RequestBody DataTestOptionsDto testOptionsDto) {
        DataTestOptions testOptions = dataTestOptionsMapper.toEntity(testOptionsDto);
        testDataService.sendMessages(testOptions);
    }
}
