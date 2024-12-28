package ru.ichtus.gfc.backend.service;

import lombok.RequiredArgsConstructor;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;
import ru.ichtus.gfc.backend.exception.EntityNotFoundException;
import ru.ichtus.gfc.backend.model.Participant;
import ru.ichtus.gfc.backend.repository.ParticipantRepository;
import ru.ichtus.gfc.backend.utils.BeanUtils;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ParticipantService implements DefaultService<Participant> {

    private final ParticipantRepository participantRepository;

    @Override
    public List<Participant> findAll() {
        return participantRepository.findAll();
    }

    @Override
    public Participant findById(Integer id) {
        return participantRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Participant not found!")
        );
    }

    @Override
    public Participant save(Participant item) {
        String code = DigestUtils.sha256Hex(item.getName().concat(item.getSurname()));
        item.setCode(code);
        return participantRepository.save(item);
    }

    @Override
    public Participant update(Participant item) {
        Participant existedParticipant = findById(item.getId());
        BeanUtils.copyNotNullProperties(item, existedParticipant);
        return participantRepository.save(item);
    }

    @Override
    public void deleteById(Integer id) {
        participantRepository.deleteById(id);
    }
}
