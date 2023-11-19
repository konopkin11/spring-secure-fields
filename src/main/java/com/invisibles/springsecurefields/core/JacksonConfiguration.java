package com.invisibles.springsecurefields.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.PropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@Configuration
public class JacksonConfiguration {
    @Bean
    public ObjectMapper customSerializer() {
        ObjectMapper mapper = new ObjectMapper();
        SimpleFilterProvider filterProvider = new SimpleFilterProvider();
        PropertyFilter propertyFilter = new AllowedFilter();
        filterProvider.addFilter("AllowedFilter", propertyFilter);
        mapper.setFilterProvider(filterProvider);
        return mapper;
    }
}
