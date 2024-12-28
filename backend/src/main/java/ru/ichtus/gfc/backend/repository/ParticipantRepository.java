package ru.ichtus.gfc.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ichtus.gfc.backend.model.Participant;

public interface ParticipantRepository extends JpaRepository<Participant, Integer> {
}
