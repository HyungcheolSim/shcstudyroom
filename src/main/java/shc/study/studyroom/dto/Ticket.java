package shc.study.studyroom.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import shc.study.studyroom.enums.Expired;
import shc.study.studyroom.enums.TicketType;

import java.time.*;
@Getter
@Setter
@AllArgsConstructor
public class Ticket {
    int ticketIdx;
    TicketType ticketType;
    int ticketUserIdx;
    LocalDate ticketSdate;
    LocalDate ticketEdate;
    LocalTime ticketTime;
    Expired ticketExpired;
    LocalDate ticketExpiredDt;
    int ticketSeatIdx;
}
