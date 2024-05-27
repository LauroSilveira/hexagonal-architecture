package com.correia.hexagonal.adapters.out;


import com.correia.hexagonal.application.out.SendDniValidationPort;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

//Adapter (implementation) of SendDniValidationPort

@Component
public class SendDniValidationAdapter implements SendDniValidationPort {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public SendDniValidationAdapter(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void send(final String dni) {
        this.kafkaTemplate.send("topic-dni-validation", dni);
    }
}
