package shc.study.studyroom.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shc.study.studyroom.dto.Seat;
import shc.study.studyroom.service.SeatService;

import java.util.LinkedHashMap;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/seat")
public class SeatController {
    private final SeatService seatService;

    @GetMapping
    public ResponseEntity<List<LinkedHashMap<Object, Object>>> getSeats() {
        return ResponseEntity.ok().body(seatService.selectAllSeat());
    }

    @GetMapping("/{seatIdx}")
    public ResponseEntity<Seat> getSeatId(@PathVariable int seatIdx) {
        return ResponseEntity.ok().body(seatService.selectOneSeat(seatIdx));
    }

    @PostMapping
    public ResponseEntity<Seat> insert(@RequestBody Seat seat) {
        return ResponseEntity.ok().body(seatService.addSeat(seat));
    }

    @PutMapping
    public ResponseEntity<Seat> update(@RequestBody Seat seat) {
        return ResponseEntity.ok().body(seatService.modSeat(seat));
    }

    @DeleteMapping("/{seatIdx}")
    public ResponseEntity<Seat> delete(@PathVariable int seatIdx) {
        return ResponseEntity.ok().body(seatService.delSeat(seatIdx));
    }
}
