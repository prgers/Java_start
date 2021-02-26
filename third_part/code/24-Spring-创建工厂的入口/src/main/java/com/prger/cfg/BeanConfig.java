package com.prger.cfg;

import com.prger.domain.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.prger")
public class BeanConfig {
    @Bean
    public Person person() {
        return new Person();
    }
}
