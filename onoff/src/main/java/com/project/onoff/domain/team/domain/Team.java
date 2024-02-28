package com.project.onoff.domain.team.domain;

import com.project.onoff.domain.member.domain.Member;
import com.project.onoff.domain.member.domain.Role;
import com.project.onoff.global.utils.BaseTimeEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Teams")
public class Team extends BaseTimeEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(unique = true, nullable = false, name = "team_name")
  private String teamName;
  private int memberCount;

  private String manger;

  protected Team() {
  }

  protected Team(Long id, String teamName, int memberCount) {
    this.id = id;
    this.teamName = teamName;
    this.memberCount = memberCount;
  }

  public static Team of(String teamName) {
    Team team = new Team();
    team.teamName = teamName;
    team.memberCount = 0;
    return team;
  }

  public Long getId() {
    return id;
  }

  public String getTeamName() {
    return teamName;
  }

  public int getMemberCount() {
    return memberCount;
  }

  public String getManger() {
    return manger;
  }

  public void addTeamMember(Member member) {
    member.addTeam(this);
    if (member.getRole() == Role.MANGER) {
      this.manger = member.getName();
    }
    this.memberCount++;
  }
}
