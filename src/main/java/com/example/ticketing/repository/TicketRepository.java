package com.example.ticketing.repository;

import com.example.ticketing.model.Ticket;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.ConcurrentHashMap;

@Repository
// This is a simple in-memory repository for demonstration purposes.

public class TicketRepository {

    private final Map<Long, Ticket> tickets = new ConcurrentHashMap<>();
    private final AtomicLong sequence = new AtomicLong();

    public List<Ticket> findAll() {
        return new ArrayList<>(tickets.values());
    }

    public Optional<Ticket> findById(Long id) {
        return Optional.ofNullable(tickets.get(id));
    }

    public Ticket save(Ticket ticket) {
        if (ticket.getId() == null) {
            ticket.setId(sequence.incrementAndGet());
            ticket.setCreatedAt(Instant.now());
        }
        tickets.put(ticket.getId(), ticket);
        return ticket;
    }

    public void deleteById(Long id) {
        tickets.remove(id);
    }

}
