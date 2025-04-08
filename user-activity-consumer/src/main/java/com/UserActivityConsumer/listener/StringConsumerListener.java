package com.UserActivityConsumer.listener;

import com.UserActivityConsumer.user.User;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class StringConsumerListener {

    @KafkaListener(groupId = "grupo-1", topics = "actividad-usuario", containerFactory = "strContainerFactory")
    public void listener(User user){
        log.info("Recibiendo un usuario {}", user);
    }
}
