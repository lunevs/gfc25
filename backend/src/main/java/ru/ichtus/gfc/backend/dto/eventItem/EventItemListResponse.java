package ru.ichtus.gfc.backend.dto.eventItem;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventItemListResponse {

    List<EventItemResponse> items = new ArrayList<>();

}
