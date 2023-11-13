package com.example.datageneratorservice.service;

import com.example.datageneratorservice.model.DataTestOptions;

public interface TestDataService {
    void sendMessages(DataTestOptions testOptions);
}
