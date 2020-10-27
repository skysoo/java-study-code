package org.example.vo;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;


@Getter
@EqualsAndHashCode(callSuper = false)
public class LombokVO extends PeriodCreate{
    private final String memberSeq;
    private final String memberName;
    private final String memberTeam;

    @Builder
    public LombokVO(String memberSeq, String memberName, String memberTeam, String createDt, String createTm) {
        super(createDt, createTm);
        this.memberSeq = memberSeq;
        this.memberName = memberName;
        this.memberTeam = memberTeam;
    }
}
