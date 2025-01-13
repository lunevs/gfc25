package ru.ichtus.gfc.backend.mapper;

import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import ru.ichtus.gfc.backend.dto.confEvent.AddConfEventRequest;
import ru.ichtus.gfc.backend.dto.confEvent.ConfEventListResponse;
import ru.ichtus.gfc.backend.dto.confEvent.ConfEventResponse;
import ru.ichtus.gfc.backend.model.ConfEvent;

import java.util.List;

@DecoratedWith(ConfEventMapperDelegate.class)
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ConfEventMapper {

    ConfEvent requestToContEvent(AddConfEventRequest request);

    @Mapping(source = "eventId", target = "id")
    ConfEvent requestToContEvent(Integer eventId, AddConfEventRequest request);

    ConfEventResponse confEventToResponse(ConfEvent confEvent);

    default ConfEventListResponse confEventListToResponseList(List<ConfEvent> confEvents) {
        ConfEventListResponse listResponse = new ConfEventListResponse();
        listResponse.setConfEvents(confEvents.stream()
                .map(this::confEventToResponse).toList());
        return listResponse;
    }

}
