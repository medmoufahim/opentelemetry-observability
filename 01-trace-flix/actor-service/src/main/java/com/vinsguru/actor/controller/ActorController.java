package com.vinsguru.actor.controller;

import com.vinsguru.actor.dto.ActorDto;
import com.vinsguru.actor.service.ActorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class ActorController {

    private static final Logger log = LoggerFactory.getLogger(ActorController.class);

    private final ActorService actorService;

    public ActorController(ActorService actorService) {
        this.actorService = actorService;
    }

    @GetMapping("/api/actors/{id}")
    public ResponseEntity<ActorDto> getActor(@PathVariable Integer id, @RequestHeader Map<String, String> headers) {
        log.info("Request Headers: {}", headers);
        return this.actorService.getActor(id)
                                .map(ResponseEntity::ok)
                                .orElseGet(() -> ResponseEntity.notFound().build());
    }

}
