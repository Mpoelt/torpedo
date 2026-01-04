package org.example.configuration;

import org.example.init.PlayerInit;
import org.example.service.ConsoleService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PlayerInitBeenConfig {

    @Bean
    public PlayerInit creatPlayerInitBean(ConsoleService consoleService){
        return new PlayerInit(consoleService);
    }

}
