package com.campuslands.ong.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.NameTokenizers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {
    
    @Bean
    public ModelMapper modelMapper(){     

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                   .setSourceNameTokenizer(NameTokenizers.UNDERSCORE);
        
        return modelMapper;
    }
}
