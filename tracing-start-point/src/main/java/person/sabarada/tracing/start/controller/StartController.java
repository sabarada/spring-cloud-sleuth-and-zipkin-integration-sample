package person.sabarada.tracing.start.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class StartController {

    @Autowired
    RestTemplate restTemplate;

    final Logger log = LoggerFactory.getLogger(StartController.class);

    @GetMapping("/ping")
    public String start() {

        log.info("###access start method");

        final String forObject = restTemplate.getForObject("http://localhost:8082/ping", String.class);

        log.info("###end-point`s return value : {}", forObject);
        return "pong";
    }

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

}
