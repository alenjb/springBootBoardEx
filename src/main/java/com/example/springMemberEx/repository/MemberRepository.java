package com.example.springMemberEx.repository;

import com.example.springMemberEx.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


// JpaRepository<MemberEntity, Long>  -> MemberEntity 자리에는 어떤 Entity를 사용할건지 Long 자리에는 PK값의 형태가 무엇인지
public interface MemberRepository extends JpaRepository<MemberEntity, Long> {
    //이메일로 회원 정보 조회(select * from member_table where member_email =?)
    //Optional은 null을 감지하고 JPA에서 사용함
    Optional<MemberEntity> findByMemberEmail(String memberEmail);
}
