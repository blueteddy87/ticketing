package com.example.ticketing;

import com.example.ticketing.model.Ticket;
import com.example.ticketing.model.Ticket.Status;
import com.example.ticketing.repository.TicketRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TicketServiceTest {

    @Test
    void testSaveAndFindById() {
        TicketRepository repository = new TicketRepository();

        Ticket ticket = new Ticket();
        ticket.setTitle("Testowe zgłoszenie");
        ticket.setDescription("Opis");
        ticket.setStatus(Status.OPEN);

        Ticket saved = repository.save(ticket);
        assertNotNull(saved.getId());

        Ticket found = repository.findById(saved.getId()).orElse(null);
        assertNotNull(found);
        assertEquals("Testowe zgłoszenie", found.getTitle());
    }
}
// This test class verifies the functionality of saving and retrieving a ticket.
// It checks that a ticket can be saved and then retrieved by its ID, ensuring
// the repository is working correctly.