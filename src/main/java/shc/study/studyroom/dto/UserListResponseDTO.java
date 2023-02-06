package shc.study.studyroom.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class UserListResponseDTO {
    private final List<User> userList;
}
