package shc.study.studyroom.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import shc.study.studyroom.enums.SeatStatus;
import shc.study.studyroom.enums.SeatType;

@Getter
@Setter
@AllArgsConstructor
public class Seat {
    private int seatIdx;
    private SeatType seatType;
    private SeatStatus seatStatus;
}
