package com.depromeet.unibet.domain.member;

import lombok.*;

import javax.persistence.*;

@Getter @Entity
@Table(name = "member")
@Builder(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "memberId")
    private Long memberId;

    @Column(name = "studentId", unique = true, nullable = false)
    private Long studentId;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "name")
    private String name;

    @Column(name="univ_name")
    private String univName;

    @Column(name="univ_major")
    private String univMajor;

    @Builder
    public Member(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }
}

