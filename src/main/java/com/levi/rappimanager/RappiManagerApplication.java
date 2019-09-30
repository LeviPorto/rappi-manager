package com.levi.rappimanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class RappiManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(RappiManagerApplication.class, args);
    }

}
