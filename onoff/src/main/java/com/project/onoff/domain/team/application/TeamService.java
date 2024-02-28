package com.project.onoff.domain.team.application;

import com.project.onoff.domain.member.domain.Member;
import com.project.onoff.domain.member.repository.MemberRepository;
import com.project.onoff.domain.team.domain.Team;
import com.project.onoff.domain.team.dto.request.TeamRequest.AddTeamMemberRequest;
import com.project.onoff.domain.team.dto.request.TeamRequest.CreateTeamRequest;
import com.project.onoff.domain.team.dto.response.TeamResponse.TeamListResponse;
import com.project.onoff.domain.team.repository.TeamRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TeamService {

  private final TeamRepository teamRepository;
  private final MemberRepository memberRepository;

  @Autowired
  public TeamService(TeamRepository teamRepository, MemberRepository memberRepository) {
    this.teamRepository = teamRepository;
    this.memberRepository = memberRepository;
  }

  public void createTeam(CreateTeamRequest request) {
    Team team = Team.of(request.getTeamName());
    teamRepository.save(team);
  }

  public void addTeamMember(Long memberId, AddTeamMemberRequest request) {
    Member member = memberRepository.findById(memberId).orElseThrow(() ->
        new IllegalArgumentException("존재하지 안는 멤버 입니다."));
    Team team = teamRepository.findByTeamName(request.getTeamName());

    team.addTeamMember(member);

  }

  @Transactional(readOnly = true)
  public List<TeamListResponse> getTeamList() {
    List<Team> teams = teamRepository.findAll();

    return teams.stream().map(team -> new TeamListResponse(
        team.getTeamName(), team.getManger(), team.getMemberCount())
    ).collect(Collectors.toList());
  }
}
