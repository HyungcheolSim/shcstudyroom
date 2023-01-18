package shc.study.studyroom.service;

import shc.study.studyroom.dto.Seat;

import java.util.LinkedHashMap;
import java.util.List;

public interface SeatService {
    List<LinkedHashMap<Object, Object>> selectAllSeat();

    Seat selectOneSeat(int seatIdx);

    Seat addSeat(Seat seat);
    Seat modSeat(Seat seat);
    Seat delSeat(int seatIdx);
}
