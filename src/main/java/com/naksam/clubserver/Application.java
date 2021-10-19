package com.naksam.clubserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(exclude = {HibernateJpaAutoConfiguration.class})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
