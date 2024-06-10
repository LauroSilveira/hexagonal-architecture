package com.correia.hexagonal.adapters.in.logging;

import com.correia.hexagonal.adapters.in.kafka.consumer.message.CustomerMessage;
import com.correia.hexagonal.adapters.model.CustomerDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
@Slf4j
@RequiredArgsConstructor
public class LoggingAspect {

    @Before("execution(* com.correia.hexagonal.adapters.in.rest.delegates.*.*(..))")
    public void loggingRequestRestController(JoinPoint joinPoint) {
        final var requestArgs = Arrays.stream(joinPoint.getArgs()).findFirst()
                .map(CustomerDto.class::cast)
                .orElse(null);
        log.info("Request to {} - parameters: {}", joinPoint.getSignature().toShortString(),
                requestArgs);
    }

    @Before("execution(* com.correia.hexagonal.adapters.in.kafka.consumer.ValidateDniConsumer*.*(..))")
    public void loggingRequestKafkaConsumer(JoinPoint joinPoint) {
        final var requestArgs = Arrays.stream(joinPoint.getArgs()).findFirst()
                .map(CustomerMessage.class::cast)
                .orElse(null);
        log.info("{} Received message: {}", joinPoint.getSignature().toShortString(), requestArgs);
    }
}
