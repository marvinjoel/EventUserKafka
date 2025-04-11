package com.UserActivityConsumer.config;

import com.UserActivityConsumer.DTO.User;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.*;
import org.springframework.kafka.support.serializer.ErrorHandlingDeserializer;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
@RequiredArgsConstructor
public class StringConsumerConfig {

    private final KafkaProperties kafkaProperties;

    @Bean
    public ConsumerFactory<String, User> consumerFactory() {
        Map<String, Object> configs = new HashMap<>();
        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaProperties.getBootstrapServers());
        configs.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);

        JsonDeserializer<User> jsonDeserializer = new JsonDeserializer<>(User.class, false);
        jsonDeserializer.addTrustedPackages("com.UserActivityConsumer.DTO");
        ErrorHandlingDeserializer<User> errorHandlingDeserializer = new ErrorHandlingDeserializer<>(jsonDeserializer);

        configs.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, errorHandlingDeserializer);
        configs.put(ConsumerConfig.GROUP_ID_CONFIG, "grupo-1");
        return new DefaultKafkaConsumerFactory<>(configs, new StringDeserializer(), errorHandlingDeserializer);
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, User> strContainerFactory(ConsumerFactory<String, User> consumerFactory) {
        var factory = new ConcurrentKafkaListenerContainerFactory<String, User>();
        factory.setConsumerFactory(consumerFactory);
        return factory;
    }
}
