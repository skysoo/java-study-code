package org.example.opnesource;

import org.example.vo.LombokVO;

public class LombokTest {
    public static void main(String[] args) {
        /**
         * @EqualsAndHashCode(callSuper = true) : 부모 클래스까지 포함하여 비교
         *
         * @EqualsAndHashCode(callSuper = false) : 부로 클래스는 제외하고 비교
         **/
        LombokVO lombokVO1 = LombokVO.builder()
                .memberSeq("1")
                .memberName("NAME")
                .memberTeam("TEAM")
                .createDt("2020")
                .createTm("1201")
                .build();

        LombokVO lombokVO2 = LombokVO.builder()
                .memberSeq("1")
                .memberName("NAME")
                .memberTeam("TEAM")
                .createDt("2020")
                .createTm("12011")
                .build();

        System.out.println("lombokVO1: " +lombokVO1);
        System.out.println("lombokVO2: " +lombokVO2);

        System.out.println(lombokVO1.equals(lombokVO2));
    }
}
