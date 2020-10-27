package org.example.opnesource;

import com.google.gson.Gson;
import org.example.vo.MemberVO;
import org.json.JSONObject;

/**
 * gson 관련 테스트
 *
 * Gson 은 @SerializedName 을 사용하여서 매핑 값을 지정할 수 있는데, value 와 alternate 값이 있다.
 *
 * value 는 toJson() 에서 각 객체의 매핑 키 값을 의미한다.
 *
 * alternate 는 fromJson() 에서 각 객체가 Json String 의 키 값 과 매핑 될 키 값을 의미한다.
 *
 * 1. toJson() : VO 객체 -> Json String
 * 2. fromJson() : Json String -> VO 객체
 *
 *
 */
public class GsonTest {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        Gson gson = new Gson();

        String jsonStr = "{\n" +
                "    \"memberNo\": \"AAA\",\n" +
                "    \"name\": \"웰시코기\",\n" +
                "    \"member_team\": \"teamA\",\n" +
                "}";

        JSONObject jsonObject = new JSONObject(jsonStr);

        MemberVO memberVO = gson.fromJson(jsonObject.toString(), MemberVO.class);
        System.out.println(memberVO);


//        MemberVO memberVO = MemberVO.builder()
//                .memberSeq("AAA")
//                .memberName("NAME")
//                .memberTeam("TEAM")
//                .build();
//
//        String memberVOJsonStr = gson.toJson(memberVO);
//        System.out.println(memberVOJsonStr);
    }
}

