package shc.study.studyroom;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import shc.study.studyroom.dto.User;

@SpringBootTest
class StudyroomApplicationTests {
    User user;
    @BeforeAll
    public void setUp(){
        //user= new User();
    }
    @Test
    void selectUserTest() {

        /*user.setUserName("심형철");
        user.setUserId("sim3412");
        user.setUserPwd("qwe1352422");
        user.setUserPhone("010-3345-8446");*/

    }

}
