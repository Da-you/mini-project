package com.project.onoff;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class OnoffApplication {

  public static void main(String[] args) {
    SpringApplication.run(OnoffApplication.class, args);
  }

}
