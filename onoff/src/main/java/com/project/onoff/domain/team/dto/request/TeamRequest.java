package com.project.onoff.domain.team.dto.request;

import com.project.onoff.domain.team.domain.Team;

public class TeamRequest {
  public static class CreateTeamRequest{

    private String teamName;

    public String getTeamName() {
      return teamName;
    }

    protected CreateTeamRequest() {
    }

    protected CreateTeamRequest(String teamName) {
      this.teamName = teamName;
    }

  }
  public static class AddTeamMemberRequest{
    String teamName;

    protected AddTeamMemberRequest() {
    }

    protected AddTeamMemberRequest(String teamName) {
      this.teamName = teamName;
    }

    public String getTeamName() {
      return teamName;
    }
  }


}
