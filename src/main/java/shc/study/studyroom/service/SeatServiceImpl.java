package shc.study.studyroom.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import shc.study.studyroom.dao.SeatMapper;
import shc.study.studyroom.dto.Seat;

import java.util.LinkedHashMap;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SeatServiceImpl implements SeatService {


    private final SeatMapper seatMapper;

    @Override
    public List<LinkedHashMap<Object, Object>> selectAllSeat() {
        return seatMapper.selectAllSeat();
    }

    @Override
    public Seat selectOneSeat(int seatIdx) {
        return seatMapper.selectSeatByIdx(seatIdx);
    }

    @Override
    public Seat addSeat(Seat seat) {
        seatMapper.insertSeat(seat);
        return seatMapper.selectSeatByIdx(seat.getSeatIdx());
    }

    @Override
    public Seat modSeat(Seat seat) {
        seatMapper.updateSeat(seat);
        return seat;
    }

    @Override
    public Seat delSeat(int seatIdx) {
        seatMapper.deleteSeat(seatIdx);
        return seatMapper.selectSeatByIdx(seatIdx);
    }
}
