package person.sabarada.tracing.end.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EndController {

    final Logger log = LoggerFactory.getLogger(EndController.class);

    @GetMapping("/ping")
    public String end() {
        log.info("###access end method");
        return "pong";
    }
}
