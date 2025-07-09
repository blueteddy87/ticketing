package com.example.ticketing.service;

import com.example.ticketing.model.Ticket;
import com.example.ticketing.repository.TicketRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service

public class TicketService {

    private final TicketRepository repository;

    public TicketService(TicketRepository repository) {
        this.repository = repository;
    }

    public List<Ticket> getAll() {
        return repository.findAll();
    }

    public Ticket getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Ticket o ID " + id + " nie istnieje"));
    }

    public Ticket create(Ticket ticket) {
        ticket.setStatus(Ticket.Status.OPEN); // domyślny status
        return repository.save(ticket);
    }

    public Ticket updateStatus(Long id, Ticket.Status newStatus) {
        Ticket ticket = getById(id);
        ticket.setStatus(newStatus);
        return repository.save(ticket);
    }

    public void delete(Long id) {
        if (repository.findById(id).isEmpty()) {
            throw new NoSuchElementException("Nie można usunąć – zgłoszenie nie istnieje");
        }
        repository.deleteById(id);
    }
}
