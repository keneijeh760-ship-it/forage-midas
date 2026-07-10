package com.jpmc.midascore.listener;

import com.jpmc.midascore.foundation.Transaction;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class Listener {

    @KafkaListener(topics = "${general.kafka-topic}")
    public void listen(@Payload Transaction transaction) {
        float amount = transaction.getAmount();



    }
}
