package org.example.vo;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class MemberVO {
    @SerializedName(value = "MEMBER_SEQ", alternate = {"memberSeq", "memberNo"})
    private final String memberSeq;
    @SerializedName(value = "MEMBER_NAME", alternate = {"memberName", "name"})
    private final String memberName;
    @SerializedName(value = "memberTeam", alternate = "member_team")
    private final String memberTeam;

    @Builder
    public MemberVO(String memberSeq, String memberName, String memberTeam) {
        this.memberSeq = memberSeq;
        this.memberName = memberName;
        this.memberTeam = memberTeam;
    }
}
