package com.example.datageneratorservice.config;

import com.jcabi.xml.XML;
import com.jcabi.xml.XMLDocument;
import lombok.SneakyThrows;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {
    @Bean
    @SneakyThrows
    public XML producerXML() {
        return new XMLDocument(
                getClass().getResourceAsStream("/kafka/producer.xml")
                        .readAllBytes()
        );
    }
}
