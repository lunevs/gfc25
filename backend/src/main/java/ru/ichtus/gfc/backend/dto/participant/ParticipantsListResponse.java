package ru.ichtus.gfc.backend.dto.participant;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParticipantsListResponse {

    List<ParticipantResponse> participants = new ArrayList<>();

}
