package com.example.springMemberEx.service;

import com.example.springMemberEx.dto.MemberDTO;
import com.example.springMemberEx.entity.MemberEntity;
import com.example.springMemberEx.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.lang.reflect.Member;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    public void save(MemberDTO memberDTO) {
        //1. dto => entity 변환
        //2. repository의 save 메서도 호출
        MemberEntity memberEntity = MemberEntity.toMemberEntity(memberDTO);
        System.out.println("memberEntity = " + memberEntity.getMemberName());
        memberRepository.save(memberEntity);
        // repository 의 save 메서드 호출(조건: entity 객체를 넘겨줘야함)
    }

    public MemberDTO login(MemberDTO memberDTO){
/*
        1. 회원이 입력한 이메일로 DB에서 조회
        2. DB에서 조회한 비밀번호가 사용자의 비밀번호와 일치하는지 판단
*/
        Optional<MemberEntity> byMemberEmail = memberRepository.findByMemberEmail(memberDTO.getMemberEmail());
        if(byMemberEmail.isPresent()){
            //조회 결과가 있다(해당 이메일을 가진 회원이 있다)
            MemberEntity memberEntity = byMemberEmail.get();
            if(memberEntity.getMemberPassword().equals(memberDTO.getMemberPassword())){
                //비밀번호가 일치
                // entity -> dto 변환 후 리턴
                MemberDTO dto = MemberDTO.toMemberDTO(memberEntity);
                return dto;

            }else {
                //비밀번호 불일치
                return null;
            }
        }else {
            //조회 결과가 없다(해당 이메일을 가진 회원이 없다)
            return null;
        }
    }
}
