package com.project.onoff.domain.team.repository;

import com.project.onoff.domain.team.domain.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team,Long> {

  Team findByTeamName(String teamName);
}
