package shc.study.studyroom.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import shc.study.studyroom.dto.Ticket;

import java.util.LinkedHashMap;
import java.util.List;

@Repository
@Mapper
public interface TicketMapper {
    // 모든 티켓 조회
    List<LinkedHashMap<Object,Object>> selectAllTicket();
    //만료되지 않은 티켓만 조회
    List<LinkedHashMap<Object,Object>> selectNotExpiredTicket();
    //사용중인 티켓 조회
    List<LinkedHashMap<Object,Object>> selectUsedTicket();
    //단일 티켓 조회
    Ticket selectTicketByIdx(int ticketIdx);
    // 티켓 등록
    void insertTicket(Ticket ticket);
    //티켓 수정
    void updateTicket(Ticket ticket);
    //티켓 삭제(만료)
    void deleteTicket(int ticketIdx);


}
