package com.alex.utils;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;

import java.beans.Introspector;

public class PackageBeanNameGenerator implements BeanNameGenerator {
    public String generateBeanName(BeanDefinition definition, BeanDefinitionRegistry registry) {
        return Introspector.decapitalize(definition.getBeanClassName());
    }
}