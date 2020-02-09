package com.depromeet.unibet.domain.member;

import com.depromeet.unibet.domain.member.dto.MemberRequestDto;
import com.depromeet.unibet.exception.BusinessException;
import com.depromeet.unibet.exception.ErrorCode;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    private MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Member signInMember(MemberRequestDto memberRequestDto) {
        Member member = Member
                .builder()
                .studentId((memberRequestDto.getStudentId()))
                .email(memberRequestDto.getEmail())
                .name(memberRequestDto.getName())
                .password(memberRequestDto.getPassword())
                .univName(memberRequestDto.getUnivName())
                .univMajor(memberRequestDto.getUnivMajor())
                .build();
        member = memberRepository.save(member);
        return member;
    }

    public Member getMember(Long memberId) {
        return memberRepository.findById(memberId).orElseThrow(() -> new BusinessException(ErrorCode.INVALID_INPUT_VALUE));
    }
}
