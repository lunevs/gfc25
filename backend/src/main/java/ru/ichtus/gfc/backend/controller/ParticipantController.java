package ru.ichtus.gfc.backend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ichtus.gfc.backend.dto.participant.AddParticipantRequest;
import ru.ichtus.gfc.backend.dto.participant.ParticipantResponse;
import ru.ichtus.gfc.backend.dto.participant.ParticipantsListResponse;
import ru.ichtus.gfc.backend.mapper.ParticipantMapper;
import ru.ichtus.gfc.backend.model.Participant;
import ru.ichtus.gfc.backend.service.ParticipantService;

@RestController
@RequestMapping("/api/v1/participant")
@RequiredArgsConstructor
public class ParticipantController {

    private final ParticipantService participantService;
    private final ParticipantMapper participantMapper;

    @GetMapping
    public ResponseEntity<ParticipantsListResponse> findAll() {
        return ResponseEntity.ok(participantMapper.participantListToResponseList(participantService.findAll()));
    }

    @PostMapping
    public ResponseEntity<ParticipantResponse> addNewParticipant(@RequestBody AddParticipantRequest request) {
        Participant participant = participantService.save(participantMapper.requestToParticipant(request));
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(participantMapper.participantToResponse(participant));
    }


}
