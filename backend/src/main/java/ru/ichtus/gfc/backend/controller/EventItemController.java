package ru.ichtus.gfc.backend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ichtus.gfc.backend.dto.eventItem.AddEventItemRequest;
import ru.ichtus.gfc.backend.dto.eventItem.EventItemListResponse;
import ru.ichtus.gfc.backend.dto.eventItem.EventItemResponse;
import ru.ichtus.gfc.backend.mapper.EventItemMapper;
import ru.ichtus.gfc.backend.model.EventItem;
import ru.ichtus.gfc.backend.service.EventItemService;

@RestController
@RequestMapping("/api/v1/event_item")
@RequiredArgsConstructor
public class EventItemController {

    private final EventItemService itemService;
    private final EventItemMapper itemMapper;

    @GetMapping
    public ResponseEntity<EventItemListResponse> findAll() {
        return ResponseEntity.ok(itemMapper.eventItemListToResponse(itemService.findAll()));
    }

    @PostMapping
    public ResponseEntity<EventItemResponse> addNewEventItem(@RequestBody AddEventItemRequest request) {
        EventItem eventItem = itemService.save(itemMapper.requestToEventItem(request));
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(itemMapper.eventItemToResponse(eventItem));
    }
}
