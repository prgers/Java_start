package com.prger.domain;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties("jdbc")
@Component
@Data
public class Jdbc {

    private String url;
    private String username;
    private String password;
}
