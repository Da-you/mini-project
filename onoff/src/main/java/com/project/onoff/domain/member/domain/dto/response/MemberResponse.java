package com.project.onoff.domain.member.domain.dto.response;

import com.project.onoff.domain.member.domain.Role;
import java.time.LocalDate;

public class MemberResponse {
  public static class MemberListResponse{
    private String name;
    private String teamName;
    private Role role;
    private LocalDate birthday;
    private LocalDate workStartDate;

    public String getName() {
      return name;
    }

    public String getTeamName() {
      return teamName;
    }

    public Role getRole() {
      return role;
    }

    public LocalDate getBirthday() {
      return birthday;
    }

    public LocalDate getWorkStartDate() {
      return workStartDate;
    }

    public MemberListResponse(String name, String teamName, Role role, LocalDate birthday,
        LocalDate workStartDate) {
      this.name = name;
      this.teamName = teamName;
      this.role = role;
      this.birthday = birthday;
      this.workStartDate = workStartDate;
    }

    protected MemberListResponse() {
    }
  }

}
