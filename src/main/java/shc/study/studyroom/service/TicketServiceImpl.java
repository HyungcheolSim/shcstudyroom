package shc.study.studyroom.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import shc.study.studyroom.dao.TicketMapper;
import shc.study.studyroom.dto.Ticket;

import java.util.LinkedHashMap;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService {

    private final TicketMapper ticketMapper;

    @Override
    public List<LinkedHashMap<Object, Object>> selectEveryTicket() {
        return ticketMapper.selectAllTicket();
    }

    @Override
    public List<LinkedHashMap<Object, Object>> selectUnExpiredTicket() {
        return ticketMapper.selectNotExpiredTicket();
    }

    @Override
    public List<LinkedHashMap<Object, Object>> selectUsedTicket() {
        return ticketMapper.selectUsedTicket();
    }

    @Override
    public Ticket selectOneTicket(int ticketIdx) {
        return ticketMapper.selectTicketByIdx(ticketIdx);
    }

    @Override
    public Ticket addTicket(Ticket ticket) {
        ticketMapper.insertTicket(ticket);
        return ticketMapper.selectTicketByIdx(ticket.getTicketIdx());
    }

    @Override
    public Ticket modTicket(Ticket ticket) {
        ticketMapper.updateTicket(ticket);
        return ticket;
    }

    @Override
    public Ticket delTicket(int ticketIdx) {
        ticketMapper.deleteTicket(ticketIdx);
        return ticketMapper.selectTicketByIdx(ticketIdx);
    }
}
