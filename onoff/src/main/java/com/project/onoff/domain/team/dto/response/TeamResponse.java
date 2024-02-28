package com.project.onoff.domain.team.dto.response;

public class TeamResponse {

  public static class TeamListResponse {

    private String teamName;
    private String manger;
    private int memberCount;

    protected TeamListResponse() {
    }

    public TeamListResponse(String teamName, String manger, int memberCount) {
      this.teamName = teamName;
      this.manger = manger;
      this.memberCount = memberCount;
    }

    public String getTeamName() {
      return teamName;
    }

    public String getManger() {
      return manger;
    }

    public int getMemberCount() {
      return memberCount;
    }
  }

}
