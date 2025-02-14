package com.ohgiraffers.example.member.service;

import com.ohgiraffers.example.member.model.dto.SignupDTO;
import com.ohgiraffers.example.member.model.entity.Member;
import com.ohgiraffers.example.member.model.entity.RoleType;
import com.ohgiraffers.example.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private static final Logger log = LoggerFactory.getLogger(MemberService.class);
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    public void register(SignupDTO signupDTO) {

        Member member = Member.builder()
                .memberId(signupDTO.getMemberId())
                .password(passwordEncoder.encode(signupDTO.getPassword())) // 암호화
                .name(signupDTO.getName())
                .role(RoleType.valueOf(signupDTO.getRole())) // USER, ADMIN
                .build();

        Member savedMember = memberRepository.save(member);

        log.info("저장된 회원 번호 : {}", savedMember.getMemberNo());
    }
}
