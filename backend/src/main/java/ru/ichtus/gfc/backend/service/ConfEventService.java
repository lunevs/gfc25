package ru.ichtus.gfc.backend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ichtus.gfc.backend.exception.EntityNotFoundException;
import ru.ichtus.gfc.backend.model.ConfEvent;
import ru.ichtus.gfc.backend.repository.ConfEventRepository;
import ru.ichtus.gfc.backend.utils.BeanUtils;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ConfEventService implements DefaultService<ConfEvent> {

    private final ConfEventRepository confEventRepository;

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
