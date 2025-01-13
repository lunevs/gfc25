package ru.ichtus.gfc.backend.dto.confEvent;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.ichtus.gfc.backend.dto.room.RoomResponse;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConfEventResponse {

    Integer id;
    Instant eventStart;
    Instant eventEnd;
    String title;
    RoomResponse room;
}
