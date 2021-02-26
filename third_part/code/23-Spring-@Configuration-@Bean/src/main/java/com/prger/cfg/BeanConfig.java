package com.prger.cfg;

import com.prger.domain.Job;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public Job job(){
        return new Job();
    }
}
