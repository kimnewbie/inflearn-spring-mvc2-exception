package hello.exception.api;

import hello.exception.exception.UserException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * API 예외 컨트롤러
 */
@Slf4j
@RestController
public class ApiExceptionController {

    @GetMapping("/api/members/{id}")
    public MemberDto getMember(@PathVariable("id") String id){

        if(id.equals("ex")){
            throw new RuntimeException("A wrong id");
        }

        if(id.equals("bad")){
            throw new IllegalArgumentException("A wrong content");
        }

        if(id.equals("user-ex")){
            throw new UserException("User Error");
        }


        return new MemberDto(id, "hello " + id);
    }

    @Data
    @AllArgsConstructor
    static class MemberDto{
        private String memberId;
        private String name;
    }
}
