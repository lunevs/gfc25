package ru.ichtus.gfc.backend.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ichtus.gfc.backend.dto.confEvent.AddConfEventRequest;
import ru.ichtus.gfc.backend.dto.confEvent.ConfEventListResponse;
import ru.ichtus.gfc.backend.dto.confEvent.ConfEventResponse;
import ru.ichtus.gfc.backend.mapper.ConfEventMapper;
import ru.ichtus.gfc.backend.model.ConfEvent;
import ru.ichtus.gfc.backend.service.ConfEventService;

@RestController
@RequestMapping("/api/v1/conf_event")
@RequiredArgsConstructor
public class ConfEventController {

    private final ConfEventService eventService;
    private final ConfEventMapper eventMapper;

    @GetMapping
    public ResponseEntity<ConfEventListResponse> findAll() {
        return ResponseEntity.ok(eventMapper.confEventListToResponseList(
                eventService.findAll()
        ));
    }

    @PostMapping
    public ResponseEntity<ConfEventResponse> addNewConfEvent(@RequestBody AddConfEventRequest request) {
        ConfEvent confEvent = eventService.save(eventMapper.requestToContEvent(request));
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(eventMapper.confEventToResponse(confEvent));
    }
}
