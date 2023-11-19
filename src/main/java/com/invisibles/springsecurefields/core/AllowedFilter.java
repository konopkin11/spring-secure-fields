package com.invisibles.springsecurefields.core;

import java.util.List;
import org.springframework.security.core.context.SecurityContextHolder;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.PropertyWriter;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;

public class AllowedFilter extends SimpleBeanPropertyFilter {
    @Override
    public void serializeAsField(Object pojo, JsonGenerator jgen,
                                 SerializerProvider prov,
                                 PropertyWriter writer) throws Exception {
        if (includeField(writer)) {
            writer.serializeAsField(pojo, jgen, prov);
        }
    }

    private boolean includeField(PropertyWriter writer) {
        if (writer.getAnnotation(Allowed.class) == null) {
            return true;
        }
        List<String> classValue = List.of(writer.getAnnotation(Allowed.class).authorities());
        if (classValue.isEmpty()) return false;
        List<String> authorities = new java.util.ArrayList<>(SecurityContextHolder.getContext().getAuthentication().getAuthorities().stream().map(c -> c.getAuthority()).toList());
        authorities.retainAll(classValue);
        return !authorities.isEmpty();

    }

}
