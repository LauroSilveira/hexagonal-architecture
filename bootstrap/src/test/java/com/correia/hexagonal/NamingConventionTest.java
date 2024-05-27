package com.correia.hexagonal;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

@AnalyzeClasses(packages = {"com.correia.hexagonal.adapters", "com.correia.hexagonal.application",
        "com.correia.hexagonal.domain"})
public class NamingConventionTest {


    @ArchTest
    public static final ArchRule controllers_reside_only_controller_package = classes()
            .that()
            .haveNameMatching(".*Controller")
            .should()
            .resideInAPackage("..adapters.in.rest.controller")
            .as("Controller's classes must reside in package adapters.in.rest.controller");

    @ArchTest
    public static final ArchRule consumer_reside_only_consumer_package = classes()
            .that()
            .haveNameMatching(".*Consumer")
            .should()
            .resideInAPackage("..adapters.in.kafka.consumer")
            .as("Consumer classes must reside in package adapters.in.kafka.consumer");

    @ArchTest
    public static final ArchRule adapters_reside_only_adapters_out_package = classes()
            .that()
            .haveNameMatching(".*Adapter")
            .should()
            .resideInAPackage("..adapters.out")
            .as("Adapter's classes must reside in package adapters.out");

    @ArchTest
    public static final ArchRule kafka_configuration_reside_only_kafka_config_package = classes()
            .that()
            .haveSimpleNameStartingWith("Kafka")
            .and()
            .haveSimpleNameEndingWith("Config")
            .should()
            .resideInAPackage("..adapters.in.kafka.config")
            .as("Kafka's classes configuration must reside in package adapters.int.kafka.config");

    @ArchTest
    public static final ArchRule configuration_class_application_reside_only_application_package = classes()
            .that()
            .resideInAPackage("..application.config")
            .should()
            .haveSimpleNameEndingWith("Config")
            .as("Package for Only configuration classes of application module");

    @ArchTest
    public static final ArchRule mappers_reside_only_mappers_package = classes()
            .that()
            .haveNameMatching(".*Mapper")
            .should()
            .resideInAnyPackage("..adapters.in.kafka.consumer.mapper", "..adapters.in.rest.controller.mapper",
                    "..adapters.out.feign.client.mapper", "..adapters.out.repository.mapper")
            .as("Mappers classes must reside in package mappers");
}
