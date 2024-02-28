package com.project.onoff.domain.team.api;

import com.project.onoff.domain.team.application.TeamService;
import com.project.onoff.domain.team.dto.request.TeamRequest.AddTeamMemberRequest;
import com.project.onoff.domain.team.dto.request.TeamRequest.CreateTeamRequest;
import com.project.onoff.domain.team.dto.response.TeamResponse.TeamListResponse;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teams/api/v1")
public class TeamApiController {

  private final TeamService teamService;

  @Autowired
  public TeamApiController(TeamService teamService) {
    this.teamService = teamService;
  }

  @PostMapping
  public void createTeam(@RequestBody CreateTeamRequest request) {
    teamService.createTeam(request);
  }

  @PatchMapping("/{memberId}")
  public void addTeamMember(@PathVariable Long memberId,
      @RequestBody AddTeamMemberRequest request) {
    teamService.addTeamMember(memberId, request);
  }

  @GetMapping
  public List<TeamListResponse> getTeamList() {
    return teamService.getTeamList();
  }

}
