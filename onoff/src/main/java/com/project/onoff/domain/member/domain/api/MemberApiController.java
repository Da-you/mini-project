package com.project.onoff.domain.member.domain.api;

import com.project.onoff.domain.member.domain.application.MemberService;
import com.project.onoff.domain.member.domain.dto.request.MemberRequest.CreateMemberRequest;
import com.project.onoff.domain.member.domain.dto.response.MemberResponse.MemberListResponse;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/members/api/v1")
public class MemberApiController {

  private final MemberService memberService;

  @Autowired
  public MemberApiController(MemberService memberService) {
    this.memberService = memberService;
  }

  @PostMapping
  public void createMember(@RequestBody CreateMemberRequest request) {
    memberService.createMember(request);
  }

  @GetMapping
  public List<MemberListResponse> getMembers() {
    return memberService.getMemberList();
  }


}
