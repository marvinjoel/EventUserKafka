package com.userActivityProducer.services;

import com.userActivityProducer.DTO.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class StringProducerService {

    private final KafkaTemplate<String, User> kafkaTemplate;

    public void sendMessage(User user){
        kafkaTemplate.send("actividad-usuario", user).whenComplete((result, ex)->{
            if (ex != null){
                log.error("Error al enviar el mensaje: {}", ex.getMessage());
            }
            log.info("Mensaje enviado con exito: {}", result.getProducerRecord().value());
            log.info("Particion {}, Offset {}", result.getRecordMetadata().partition(), result.getRecordMetadata().offset());

        });
    }
}
