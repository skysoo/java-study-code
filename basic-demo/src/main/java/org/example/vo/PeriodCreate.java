package org.example.vo;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
public class PeriodCreate {
    private final String createDt;
    private final String createTm;

    public PeriodCreate(String createDt, String createTm) {
        this.createDt = createDt;
        this.createTm = createTm;
    }
}
