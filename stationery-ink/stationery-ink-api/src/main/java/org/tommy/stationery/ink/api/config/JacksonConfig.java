package org.tommy.stationery.ink.api.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * Created by kun7788 on 14. 12. 18..
 */
@Configuration
public class JacksonConfig {

    @Autowired
    private ObjectMapper objectMapper;


    @PostConstruct
    public void setup() {
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
    }
}
