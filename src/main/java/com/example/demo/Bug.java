package com.example.demo;

import java.util.Map;

class Bug {
    /**
     * This field is used to trigger a bug introduced by
     * Spring-Context 6.2.0, likely
     * <a href="https://github.com/spring-projects/spring-framework/commit/357dbc035438e6ca718fd03f9facd6a64b2545c5">this commit...</a>
     * </br>
     * Specifically, when spring-validation is activated, {@link org.springframework.validation.beanvalidation.BeanValidationBeanRegistrationAotProcessor}
     * will attempt to
     * <a href="https://github.com/spring-projects/spring-framework/blob/v6.2.0/spring-context/src/main/java/org/springframework/validation/beanvalidation/BeanValidationBeanRegistrationAotProcessor.java#L157">recursively process</a>
     * any generic types referenced by Iterable/List/Optional fields.
     * If above fields reference the class by itself, which is a common pattern in enum classes, it'll cause spring-aot to {@link StackOverflowError}.
     */
    private static Map<String, Bug> BUG = Map.of();
}