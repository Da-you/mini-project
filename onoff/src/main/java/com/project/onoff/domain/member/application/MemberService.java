package com.project.onoff.domain.member.application;

import com.project.onoff.domain.member.domain.Member;
import com.project.onoff.domain.member.dto.request.MemberRequest.CreateMemberRequest;
import com.project.onoff.domain.member.dto.response.MemberResponse.MemberListResponse;
import com.project.onoff.domain.member.repository.MemberRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MemberService {

  private final MemberRepository memberRepository;

  @Autowired
  public MemberService(MemberRepository memberRepository) {
    this.memberRepository = memberRepository;
  }

  public void createMember(CreateMemberRequest request) {
    Member member = Member.of(request.getName(), request.getRole(),
        request.getBirthday(), request.getWorkStartDate());
    memberRepository.save(member);
  }

  @Transactional(readOnly = true)
  public List<MemberListResponse> getMemberList() {
    List<Member> members = memberRepository.findAll();
    return members.stream().map(
        member -> new MemberListResponse(member.getName(), member.getTeam().getTeamName(),
            member.getRole(), member.getBirthday(), member.getWorkStartDate())).collect(
        Collectors.toList());
  }

}
