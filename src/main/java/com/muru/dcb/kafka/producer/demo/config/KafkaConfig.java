package com.muru.dcb.kafka.producer.demo.config;

import com.muru.dcb.kafka.producer.demo.model.Book;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.Map;

@Configuration
public class KafkaConfig {
    @Autowired
    private ProducerFactory<String, Book> producerFactory;

    public DefaultKafkaProducerFactory<String, Book> defaultKafkaProducerFactory() {
        Map<String, Object> config = producerFactory.getConfigurationProperties();
        JsonSerializer<Book> jsonSerializer = new JsonSerializer<>();
        jsonSerializer.noTypeInfo();
        return new DefaultKafkaProducerFactory<>(config, new StringSerializer(), jsonSerializer);
    }

    @Bean
    public KafkaTemplate<String, Book> kafkaTemplate() {
        return new KafkaTemplate<>(defaultKafkaProducerFactory());
    }
}
