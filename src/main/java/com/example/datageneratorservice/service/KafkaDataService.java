package com.example.datageneratorservice.service;

import com.example.datageneratorservice.model.Data;

public interface KafkaDataService {
    void send(Data data);
}
