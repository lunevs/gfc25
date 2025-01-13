package ru.ichtus.gfc.backend.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import ru.ichtus.gfc.backend.dto.eventItem.AddEventItemRequest;
import ru.ichtus.gfc.backend.dto.eventItem.EventItemResponse;
import ru.ichtus.gfc.backend.model.ConfEvent;
import ru.ichtus.gfc.backend.model.EventItem;
import ru.ichtus.gfc.backend.model.Participant;
import ru.ichtus.gfc.backend.model.dictionary.ParticipationType;
import ru.ichtus.gfc.backend.service.ConfEventService;
import ru.ichtus.gfc.backend.service.ParticipantService;

public abstract class EventItemMapperDelegate implements EventItemMapper {

    @Autowired
    private ParticipantService participantService;

    @Autowired
    private ConfEventService eventService;

    @Autowired
    private ConfEventMapper eventMapper;

    @Autowired
    private ParticipantMapper participantMapper;

    @Override
    public EventItem requestToEventItem(AddEventItemRequest request) {
        ConfEvent confEvent = eventService.findById(request.getEventId());
        Participant participant = participantService.findById(request.getParticipantId());
        return EventItem.builder()
                .title(request.getTitle())
                .role(ParticipationType.valueOf(request.getRole()))
                .event(confEvent)
                .participant(participant)
                .build();
    }

    @Override
    public EventItem requestToEventItem(Integer itemId, AddEventItemRequest request) {
        EventItem eventItem = requestToEventItem(request);
        eventItem.setId(itemId);
        return eventItem;
    }

    @Override
    public EventItemResponse eventItemToResponse(EventItem eventItem) {
        return EventItemResponse.builder()
                .title(eventItem.getTitle())
                .event(eventMapper.confEventToResponse(eventItem.getEvent()))
                .participant(participantMapper.participantToResponse(eventItem.getParticipant()))
                .role(eventItem.getRole())
                .item_id(eventItem.getId())
                .build();
    }
}
