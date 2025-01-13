package ru.ichtus.gfc.backend.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.ichtus.gfc.backend.exception.EntityNotFoundException;
import ru.ichtus.gfc.backend.model.ConfEvent;
import ru.ichtus.gfc.backend.model.Room;
import ru.ichtus.gfc.backend.repository.ConfEventRepository;
import ru.ichtus.gfc.backend.utils.BeanUtils;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ConfEventService implements DefaultService<ConfEvent> {

    private final ConfEventRepository confEventRepository;
    private final RoomService roomService;

    @Override
    public List<ConfEvent> findAll() {
        return confEventRepository.findAll();
    }

    @Override
    public ConfEvent findById(Integer id) {
        return confEventRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Conference event not found!")
        );
    }

    @Override
    public ConfEvent save(ConfEvent item) {
        Room room = roomService.findById(item.getRoom().getId());
        item.setRoom(room);
        return confEventRepository.save(item);
    }

    @Override
    public ConfEvent update(ConfEvent item) {
        ConfEvent existedEvent = findById(item.getId());
        BeanUtils.copyNotNullProperties(item, existedEvent);
        return confEventRepository.save(existedEvent);
    }

    @Override
    public void deleteById(Integer id) {
        confEventRepository.deleteById(id);
    }
}
