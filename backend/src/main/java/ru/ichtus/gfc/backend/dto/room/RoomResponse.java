package ru.ichtus.gfc.backend.dto.room;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class RoomResponse {

    Integer id;
    Integer capacity;
    String name;
    String code;

}
