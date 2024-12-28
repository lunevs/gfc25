package ru.ichtus.gfc.backend.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import ru.ichtus.gfc.backend.dto.room.AddRoomRequest;
import ru.ichtus.gfc.backend.dto.room.RoomResponse;
import ru.ichtus.gfc.backend.dto.room.RoomsListResponse;
import ru.ichtus.gfc.backend.model.Room;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RoomMapper {

    Room requestToRoom(AddRoomRequest request);

    @Mapping(source = "roomId", target = "id")
    Room requestToRoom(Integer roomId, AddRoomRequest request);

    RoomResponse roomToResponse(Room room);

    default RoomsListResponse roomsListToResponseList(List<Room> roomList) {
        RoomsListResponse roomsListResponse = new RoomsListResponse();
        roomsListResponse.setRooms(roomList.stream()
                .map(this::roomToResponse).toList());
        return roomsListResponse;
    }

}
