package com.project.onoff.domain.member.domain.dto.request;

import com.project.onoff.domain.member.domain.Role;
import java.time.LocalDate;

public class MemberRequest {
  public static class CreateMemberRequest{
    private String name;
    private Role role;
    private LocalDate birthday;
    private LocalDate workStartDate;


    public String getName() {
      return name;
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
    protected CreateMemberRequest(){

    }

    protected CreateMemberRequest(String name, Role role, LocalDate birthday,
        LocalDate workStartDate) {
      this.name = name;
      this.role = role;
      this.birthday = birthday;
      this.workStartDate = workStartDate;
    }
  }

}
