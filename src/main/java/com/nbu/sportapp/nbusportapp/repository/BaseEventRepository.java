package com.nbu.sportapp.nbusportapp.repository;

import com.nbu.sportapp.nbusportapp.entity.event.BaseEvent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BaseEventRepository extends JpaRepository<BaseEvent, Long> {

}
