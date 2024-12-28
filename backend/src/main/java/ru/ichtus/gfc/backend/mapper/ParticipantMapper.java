package ru.ichtus.gfc.backend.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import ru.ichtus.gfc.backend.dto.participant.AddParticipantRequest;
import ru.ichtus.gfc.backend.dto.participant.ParticipantResponse;
import ru.ichtus.gfc.backend.dto.participant.ParticipantsListResponse;
import ru.ichtus.gfc.backend.model.Participant;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ParticipantMapper {

    Participant requestToParticipant(AddParticipantRequest request);

    @Mapping(source = "participantId", target = "id")
    Participant requestToParticipant(Integer participantId, AddParticipantRequest request);

    ParticipantResponse participantToResponse(Participant participant);

    default ParticipantsListResponse participantListToResponseList(List<Participant> participants) {
        ParticipantsListResponse listResponse = new ParticipantsListResponse();
        listResponse.setParticipants(participants.stream()
                .map(this::participantToResponse).toList());
        return listResponse;
    }

}
