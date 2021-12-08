package com.sign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class AutoSignApplication {

  public static void main(String[] args) {
    SpringApplication.run(AutoSignApplication.class, args);
  }

}
