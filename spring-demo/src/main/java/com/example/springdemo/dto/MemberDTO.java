package com.example.springdemo.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "`MEMBER`", schema = "`MYBATISTEST`")
@NoArgsConstructor
public class MemberDTO {
    @Id
    @Column(name = "`MEMBER_SEQ`")
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private String id;
    @Column(name = "`NAME`")
    private String name;
    @Column(name = "`AGE`")
    private int age;
    @Column(name = "`TEAM_SEQ`")
    private String teamId;

    @Builder
    public MemberDTO(String id, String name, int age, String teamId) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.teamId = teamId;
    }
}
