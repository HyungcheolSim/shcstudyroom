package shc.study.studyroom.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shc.study.studyroom.dto.Ticket;
import shc.study.studyroom.service.TicketService;

import java.util.LinkedHashMap;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/ticket")
public class TicketController {

    private final TicketService ticketService;

    @GetMapping
    public ResponseEntity<List<LinkedHashMap<Object, Object>>> getTickets() {
        return ResponseEntity.ok().body(ticketService.selectEveryTicket());
    }

    @GetMapping("/neticket")
    public  ResponseEntity<List<LinkedHashMap<Object, Object>>> getUnExpiredTickets() {
        return ResponseEntity.ok().body( ticketService.selectUnExpiredTicket());
    }

    @GetMapping("/uticket")
    public  ResponseEntity<List<LinkedHashMap<Object, Object>>> getUsedTickets() {
        return ResponseEntity.ok().body( ticketService.selectUsedTicket());
    }

    @GetMapping("/{ticketIdx}")
    public  ResponseEntity<Ticket> getOneTickets(@PathVariable int ticketIdx) {
        return ResponseEntity.ok().body(ticketService.selectOneTicket(ticketIdx));
    }

    @PostMapping
    public ResponseEntity<Ticket> insert(@RequestBody Ticket ticket) {
        return ResponseEntity.ok().body( ticketService.addTicket(ticket));
    }

    @PutMapping
    public ResponseEntity<Ticket> update(@RequestBody Ticket ticket) {
        return ResponseEntity.ok().body( ticketService.modTicket(ticket));
    }

    @PatchMapping("/{ticketIdx}")
    public  ResponseEntity<Ticket> delete(@PathVariable int ticketIdx) {
        return ResponseEntity.ok().body( ticketService.delTicket(ticketIdx));
    }
}
