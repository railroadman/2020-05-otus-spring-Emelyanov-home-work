package ru.otus.web;

import lombok.SneakyThrows;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonAutoConfiguration;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableEurekaClient
@EnableDiscoveryClient
@SpringBootApplication
@EnableMongoRepositories
@EnableConfigurationProperties
@RibbonClient(name = "book-service", configuration = RibbonAutoConfiguration.class)
public class WebServiceApplication {

  @SneakyThrows
  public static void main(String[] args) {
    SpringApplication.run(WebServiceApplication.class, args);
  }
}

