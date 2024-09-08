package com.edomew.dnd.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class AuthListener {

    @KafkaListener(topics = "auth-topic", groupId = "dnd-group")
    public void listen(String jwt) {
        // Логика обработки JWT
        System.out.println("Received JWT: " + jwt);
        authorizeUser(jwt);
    }

    private void authorizeUser(String jwt) {
        // Логика авторизации пользователя по полученному JWT
        // Например, сохранить JWT в контексте безопасности
    }
}