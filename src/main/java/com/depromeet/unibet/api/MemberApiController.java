package com.depromeet.unibet.api;

import com.depromeet.unibet.domain.member.Member;
import com.depromeet.unibet.domain.member.MemberService;
import com.depromeet.unibet.domain.member.dto.MemberRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api")
public class MemberApiController {

    private MemberService memberService;
    private PasswordEncoder passwordEncoder;

    public MemberApiController(MemberService memberService, PasswordEncoder passwordEncoder) {
        this.memberService = memberService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/sign-up")
    public ResponseEntity saveMember(@RequestBody @Validated MemberRequestDto memberRequestDto) {
        memberRequestDto.encodedPassword(this.passwordEncoder);
        Member member = memberService.signInMember(memberRequestDto);
        return ResponseEntity.ok().build();
    }
}