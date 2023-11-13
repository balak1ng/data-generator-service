package com.example.datageneratorservice.service.impl;

import com.example.datageneratorservice.model.Data;
import com.example.datageneratorservice.service.KafkaDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import reactor.kafka.sender.KafkaSender;
import reactor.kafka.sender.SenderRecord;

@Service
@RequiredArgsConstructor
public class KafkaDataServiceImpl implements KafkaDataService {
    private final KafkaSender<String, Object> sender;

    @Override
    public void send(Data data) {
        String topic = switch (data.getMeasurementType()) {
            case TEMPERATURE -> "data-temperature";
            case PRECIPITATION -> "data-precipitation";
            case WIND -> "data-wind";
        };
        // Позволяет выполнять операции независимо. Реактивный асинхронный подход.
        sender.send(
                        Mono.just(
                                SenderRecord.create(topic,
                                        0,
                                        System.currentTimeMillis(),
                                        String.valueOf(data.hashCode()),
                                        data,
                                        null
                                )
                        )
                )
                .subscribe();

    }
}
