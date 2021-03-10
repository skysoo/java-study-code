package com.example.springdemo.restful;

import com.example.springdemo.config.CacheConfig;
import com.example.springdemo.dao.ServiceDao;
import com.example.springdemo.dto.MemberDTO;
import com.example.springdemo.utility.response.DefaultResponse;
import com.example.springdemo.utility.response.ResponseHandler;
import lombok.extern.log4j.Log4j2;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 *
 * RESTful 한 API 설계?
 * 1. URI 는 자원을 나타낼 수 있어야 한다.
 * 2. URI 에는 insert/delete 와 같은 행위와 관련된 용어가 들어가면 안된다.
 * 3. URI 에서 / 는 계층 구조를 나타낸다.
 * 4. URI 에서 복수는 Collection 을 단수는 Document 를 의미하도록 작성하는 것이 좋다.
 * 5. 리턴 값은 단순 Object 값보다는 상태 코드, 메세지 등의 정보를 같이 담아서 리턴하는 것이 좋다.
 *
 * @see CacheConfig#cacheManager()
 * @see com.example.springdemo.config.CacheType
 * @see DefaultResponse
 * @see ResponseHandler#createResponse(Object, HttpServletRequest)
 **/
@Log4j2
@org.springframework.web.bind.annotation.RestController
public class RestController {
    private final ServiceDao<MemberDTO> memberDTOServiceDao;
    private final ResponseHandler responseHandler;

    public RestController(ServiceDao<MemberDTO> memberDTOServiceDao, ResponseHandler responseHandler) {
        this.memberDTOServiceDao = memberDTOServiceDao;
        this.responseHandler = responseHandler;
    }

    /**
     * 전체 조회 결과와 같이 많은 데이터를 읽어오는 로직에 캐시를 사용하면 좋으나, 해당 값이 변하지 않는다(적어도 캐시의 갱신 시간 내에)는 전제 조건이 필요하다.
     * 즉, 대량의 고정된 값을 읽어올 때 사용하면 성능의 이점이 있으나,
     * 값이 자주 변경되는 로직이라면 값 불일치 문제가 발생할 가능성이 많으므로 사용하지 않는 것이 좋다.
     **/
    @Cacheable(cacheNames = "userList")
    @GetMapping("/users")
    public ResponseEntity<DefaultResponse<Object>> selectUserByAll(HttpServletRequest request) {
        List<MemberDTO> memberList = null;
        try {
            memberList = memberDTOServiceDao.findAll();
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return ResponseEntity.ok().body(responseHandler.createResponse(memberList, request));
    }

    @Cacheable(cacheNames = "userInfo")
    @GetMapping("/users/{id}")
    public ResponseEntity<DefaultResponse<Object>> selectUserById(@PathVariable String id,
                                                                 HttpServletRequest request){
        MemberDTO member = null;
        try {
            member = memberDTOServiceDao.findById(id).get();
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return ResponseEntity.ok().body(responseHandler.createResponse(member, request));
    }

    @PostMapping("/users")
    public ResponseEntity<DefaultResponse<Object>> insertUserByName(@RequestBody MemberDTO memberDTO,
                                                              HttpServletRequest request){
        MemberDTO model = null;
        try {
            model = memberDTOServiceDao.save(memberDTO);
        }  catch (Exception e) {
            log.error(e.getMessage());
        }
        return ResponseEntity.ok().body(responseHandler.createResponse(model, request));
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<DefaultResponse<Object>> updateUserById(@PathVariable String id,
                                                                     @RequestBody MemberDTO oldMember,
                                                                     HttpServletRequest request){
        MemberDTO updateMember = null;
        try {
            MemberDTO newMember = MemberDTO.builder()
                    .id(id)
                    .name(oldMember.getName())
                    .age(oldMember.getAge())
                    .teamId(oldMember.getTeamId())
                    .build();
            updateMember = memberDTOServiceDao.update(newMember);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return ResponseEntity.ok().body(responseHandler.createResponse(updateMember,request));
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<DefaultResponse<Object>> deleteUserById(@PathVariable String id,
                                                                  HttpServletRequest request){
        boolean isDelete = false;
        try {
            memberDTOServiceDao.deleteById(id);
            isDelete = true;
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return ResponseEntity.ok().body(responseHandler.createResponse(isDelete,request));
    }

}
