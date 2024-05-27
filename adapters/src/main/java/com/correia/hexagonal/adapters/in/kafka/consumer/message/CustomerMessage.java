package com.correia.hexagonal.adapters.in.kafka.consumer.message;

public record CustomerMessage(String id, String name, String dni, String zipCode, boolean isValidDni) {
}
