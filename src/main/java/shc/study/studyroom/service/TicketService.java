package shc.study.studyroom.service;

import shc.study.studyroom.dto.Ticket;

import java.util.LinkedHashMap;
import java.util.List;

public interface TicketService {
    // 모든 티켓 조회
    List<LinkedHashMap<Object,Object>> selectEveryTicket();
    //만료되지 않은 티켓만 조회
    List<LinkedHashMap<Object,Object>> selectUnExpiredTicket();
    //사용중인 티켓 조회
    List<LinkedHashMap<Object,Object>> selectUsedTicket();
    //단일 티켓 조회
    Ticket selectOneTicket(int ticketIdx);
    Ticket addTicket(Ticket ticket);
    //티켓 수정
    Ticket modTicket(Ticket ticket);
    //티켓 삭제(만료)
    Ticket delTicket(int ticketIdx);
}
