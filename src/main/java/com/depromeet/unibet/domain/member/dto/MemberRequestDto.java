package com.depromeet.unibet.domain.member.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MemberRequestDto {

    @NotNull
    private Long studentId;
    @NotNull
    private String password;
    @NotNull
    private String name;
    @NotNull
    private String email;
    @NotNull
    private String univName;
    @NotNull
    private String univMajor;

    public MemberRequestDto(@NotNull Long studentId, @NotNull String password) {
        this.studentId = studentId;
        this.password = password;
    }

    public MemberRequestDto(@NotNull Long studentId, @NotNull String password, @NotNull String name, @NotNull String email, @NotNull String univName, @NotNull String univMajor) {
        this.studentId = studentId;
        this.password = password;
        this.name = name;
        this.email = email;
        this.univName = univName;
        this.univMajor = univMajor;
    }

    public void encodedPassword(PasswordEncoder passwordEncoder) {
        this.password = passwordEncoder.encode(password);
    }
}