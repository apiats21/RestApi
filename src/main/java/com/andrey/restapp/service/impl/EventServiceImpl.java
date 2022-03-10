package com.andrey.restapp.service.impl;

import com.andrey.restapp.model.Event;
import com.andrey.restapp.repository.EventRepository;
import com.andrey.restapp.repository.hibernate.HibernateEventRepositoryImpl;
import com.andrey.restapp.service.EventService;

import java.util.List;

public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository = new HibernateEventRepositoryImpl();

    @Override
    public Event getById(Long id) { return eventRepository.getById(id); }

    @Override
    public Event create(Event event) { return eventRepository.save(event); }

    @Override
    public List<Event> getAll() { return eventRepository.getAll(); }

    @Override
    public Event update(Event event) { return eventRepository.update(event); }

    @Override
    public void delete(Long id) { eventRepository.deleteById(id); }
}
