package ru.ichtus.gfc.backend.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import ru.ichtus.gfc.backend.dto.confEvent.AddConfEventRequest;
import ru.ichtus.gfc.backend.model.ConfEvent;
import ru.ichtus.gfc.backend.model.Room;
import ru.ichtus.gfc.backend.service.RoomService;

public abstract class ConfEventMapperDelegate implements ConfEventMapper {

    @Autowired
    private RoomService roomService;

    @Override
    public ConfEvent requestToContEvent(AddConfEventRequest request) {
        ConfEvent confEvent = new ConfEvent();
        confEvent.setEventStart(request.getEventStart());
        confEvent.setEventEnd(request.getEventEnd());
        confEvent.setTitle(request.getTitle());
        confEvent.setRoom(roomService.findById(request.getRoomId()));
        return confEvent;
    }

    @Override
    public ConfEvent requestToContEvent(Integer eventId, AddConfEventRequest request) {
        ConfEvent confEvent = requestToContEvent(request);
        confEvent.setId(eventId);
        return confEvent;
    }

}
