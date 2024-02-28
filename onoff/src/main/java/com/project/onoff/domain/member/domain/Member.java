package com.project.onoff.domain.member.domain;

import com.project.onoff.domain.team.domain.Team;
import com.project.onoff.global.utils.BaseTimeEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "members")
public class Member extends BaseTimeEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(nullable = false, name = "team_name")
  private String name;
  @Enumerated(EnumType.STRING)
  private Role role;
  @Column(nullable = false)
  private LocalDate birthday;
  @Column(nullable = false)
  private LocalDate workStartDate;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "team_id")
  private Team team;

  protected Member() {
  }

  protected Member(String name, Role role, LocalDate birthday, LocalDate workStartDate,
      Team team) {
    this.name = name;
    this.role = role;
    this.birthday = birthday;
    this.workStartDate = workStartDate;
    this.team = team;
  }

  public static Member of(String name, Role role, LocalDate birthday, LocalDate workStartDate) {
    Member member = new Member();
    member.name = name;
    member.role = role;
    member.birthday = birthday;
    member.workStartDate = workStartDate;
    return member;
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public LocalDate getBirthday() {
    return birthday;
  }

  public LocalDate getWorkStartDate() {
    return workStartDate;
  }

  public Role getRole() {
    return role;
  }

  public Team getTeam() {
    return team;
  }

  public void addTeam(Team team) {
    this.team = team;
  }
}
