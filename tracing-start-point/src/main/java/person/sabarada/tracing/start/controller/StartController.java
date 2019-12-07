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

    // 1 - 2. end-point를 호출하기위한 DI, 맴버변수.
    @Autowired
    RestTemplate restTemplate;

    // 2. 로그 확인을 위한 맴버변수
    final Logger log = LoggerFactory.getLogger(StartController.class);

    @GetMapping("/ping")
    public String start() {

        log.info("###access start method");

        // 3. end-point를 직접 호출후 결과값을 String의 형태로 변환하여 forObject에 담는다.
        final String forObject = restTemplate.getForObject("http://localhost:8082/ping", String.class);

        log.info("###end-point`s return value : {}", forObject);
        return "pong";
    }

    // 1 - 1. end-point를 호출하가위한 Bean 생성
    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
