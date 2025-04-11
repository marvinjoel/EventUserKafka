package com.UserActivityConsumer.listener;

import com.UserActivityConsumer.DTO.User;
import com.UserActivityConsumer.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Log4j2
@Component
@RequiredArgsConstructor
public class StringConsumerListener {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @KafkaListener(topics = "actividad-usuario", containerFactory = "strContainerFactory")
    public void listener(User userDto){
        if (userDto != null){
            userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
            com.UserActivityConsumer.user.User userEntity = User.Converter.convertDtoToEntity(userDto);
            userRepository.save(userEntity);
            log.info("Recibiendo un usuario {}", userDto);
        }else {
            log.warn("Error al deserializar el mensaje del tópico actividad-usuario");
        }
    }
}
