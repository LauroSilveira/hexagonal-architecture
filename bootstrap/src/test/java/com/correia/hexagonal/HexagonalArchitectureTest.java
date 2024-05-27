package com.correia.hexagonal;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.library.Architectures;

@AnalyzeClasses(packages = {"com.correia.hexagonal.adapters", "com.correia.hexagonal.application", "com.correia.hexagonal.domain"})
public class HexagonalArchitectureTest {

    @ArchTest
    public static final ArchRule hexagonal_architecture_test = Architectures.layeredArchitecture()
            .consideringAllDependencies()
            .layer("Domain").definedBy("com.correia.hexagonal.domain..")
            .layer("Adapters").definedBy("com.correia.hexagonal.adapters..")
            .layer("Application").definedBy("com.correia.hexagonal.application..")
            .whereLayer("Domain").mayOnlyBeAccessedByLayers("Adapters", "Application")
            .whereLayer("Application").mayOnlyBeAccessedByLayers("Adapters", "Domain")
            .whereLayer("Adapters").mayOnlyBeAccessedByLayers("Domain", "Application");

}
