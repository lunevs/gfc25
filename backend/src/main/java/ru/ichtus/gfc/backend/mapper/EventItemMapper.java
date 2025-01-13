package ru.ichtus.gfc.backend.mapper;

import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import ru.ichtus.gfc.backend.dto.eventItem.AddEventItemRequest;
import ru.ichtus.gfc.backend.dto.eventItem.EventItemListResponse;
import ru.ichtus.gfc.backend.dto.eventItem.EventItemResponse;
import ru.ichtus.gfc.backend.model.EventItem;

import java.util.List;

@DecoratedWith(EventItemMapperDelegate.class)
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EventItemMapper {

    EventItem requestToEventItem(AddEventItemRequest request);

    @Mapping(source = "itemId", target = "id")
    EventItem requestToEventItem(Integer itemId, AddEventItemRequest request);

    EventItemResponse eventItemToResponse(EventItem eventItem);

    default EventItemListResponse eventItemListToResponse(List<EventItem> eventItems) {
        EventItemListResponse listResponse = new EventItemListResponse();
        listResponse.setItems(eventItems.stream()
                .map(this::eventItemToResponse).toList());
        return listResponse;
    }
}
