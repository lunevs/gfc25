package ru.ichtus.gfc.backend.dto.room;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomsListResponse {

    List<RoomResponse> rooms;

}
