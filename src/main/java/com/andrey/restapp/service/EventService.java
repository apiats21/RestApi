package com.andrey.restapp.service;

import com.andrey.restapp.model.Event;

import java.util.List;

public interface EventService {
    public Event getById(Long id);

    public Event create(Event event);

    public List<Event> getAll();

    public  Event update(Event event);

    public void delete(Long id);
}
