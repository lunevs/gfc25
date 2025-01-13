package ru.ichtus.gfc.backend.dto.confEvent;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConfEventListResponse {

    List<ConfEventResponse> confEvents = new ArrayList<>();

}
