package com.example.springMemberEx.service;

import com.example.springMemberEx.dto.MemberDTO;
import com.example.springMemberEx.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    public void save(MemberDTO memberDTO) {

    }
}
