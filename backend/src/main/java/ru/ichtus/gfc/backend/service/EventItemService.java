package ru.ichtus.gfc.backend.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.ichtus.gfc.backend.exception.EntityNotFoundException;
import ru.ichtus.gfc.backend.model.ConfEvent;
import ru.ichtus.gfc.backend.model.EventItem;
import ru.ichtus.gfc.backend.model.Participant;
import ru.ichtus.gfc.backend.repository.EventItemRepository;
import ru.ichtus.gfc.backend.utils.BeanUtils;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class EventItemService implements DefaultService<EventItem>  {

    private final EventItemRepository itemRepository;
//    private final ConfEventService eventService;
//    private final ParticipantService participantService;

    @Override
    public List<EventItem> findAll() {
        return itemRepository.findAll();
    }

    @Override
    public EventItem findById(Integer id) {
        return itemRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Event item not found!")
        );
    }

    @Override
    public EventItem save(EventItem item) {
        log.info(item.toString());
//        Participant participant = participantService.findById(item.getParticipant().getId());
//        ConfEvent confEvent = eventService.findById(item.getEvent().getId());
//        item.setEvent(confEvent);
//        item.setParticipant(participant);
//        log.info(item.toString());
        return itemRepository.save(item);
    }

    @Override
    public EventItem update(EventItem item) {
        EventItem existedItem = findById(item.getId());
        BeanUtils.copyNotNullProperties(item, existedItem);
        return itemRepository.save(existedItem);
    }

    @Override
    public void deleteById(Integer id) {
        itemRepository.deleteById(id);
    }
}
