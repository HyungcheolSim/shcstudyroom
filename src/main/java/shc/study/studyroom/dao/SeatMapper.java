package shc.study.studyroom.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import shc.study.studyroom.dto.Seat;

import java.util.LinkedHashMap;
import java.util.List;

@Repository
@Mapper
public interface SeatMapper {
    List<LinkedHashMap<Object,Object>> selectAllSeat();

    Seat selectSeatByIdx(int seatIdx);
    void insertSeat(Seat seat);
    void updateSeat(Seat seat);
    void deleteSeat(int seatIdx);
}
