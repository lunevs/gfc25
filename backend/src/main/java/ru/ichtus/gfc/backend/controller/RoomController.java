package ru.ichtus.gfc.backend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ichtus.gfc.backend.dto.room.AddRoomRequest;
import ru.ichtus.gfc.backend.dto.room.RoomResponse;
import ru.ichtus.gfc.backend.dto.room.RoomsListResponse;
import ru.ichtus.gfc.backend.mapper.RoomMapper;
import ru.ichtus.gfc.backend.model.Room;
import ru.ichtus.gfc.backend.service.RoomService;

@RestController
@RequestMapping("/api/v1/room")
@RequiredArgsConstructor
public class RoomController {

    private final RoomService roomService;
    private final RoomMapper roomMapper;

    @GetMapping
    public ResponseEntity<RoomsListResponse> findAll() {
        return ResponseEntity.ok(roomMapper.roomsListToResponseList(roomService.findAll()));
    }

    @PostMapping
    public ResponseEntity<RoomResponse> addNewRoom(@RequestBody AddRoomRequest request) {
        Room newRoom = roomService.save(roomMapper.requestToRoom(request));
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(roomMapper.roomToResponse(newRoom));
    }

}
