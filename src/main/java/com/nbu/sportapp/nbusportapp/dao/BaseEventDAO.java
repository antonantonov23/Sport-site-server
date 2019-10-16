package com.nbu.sportapp.nbusportapp.dao;

import java.util.List;

import com.nbu.sportapp.nbusportapp.entity.event.BaseEvent;
import com.nbu.sportapp.nbusportapp.repository.BaseEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


// DATA ACCESS OBJECT
@Service
public class BaseEventDAO {

    @Autowired
    private BaseEventRepository baseEventRepository;

    /* to save an baseEvent in DB */

    public BaseEvent save(BaseEvent baseEvent) {
        return this.baseEventRepository.save(baseEvent);
    }

    /* search all baseEvents */

    public List<BaseEvent> findAll() {
        return this.baseEventRepository.findAll();
    }

    /* get an baseEvent */

    public BaseEvent findOne(Long baseEventId) {
        return this.baseEventRepository.findOne(baseEventId);
    }

    /* delete an baseEvent */

    public void delete(BaseEvent baseEvent) {
        this.baseEventRepository.delete(baseEvent);
    }
}
