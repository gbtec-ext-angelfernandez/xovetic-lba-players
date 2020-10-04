package com.gbtec.lba.players.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * <p>
 * Java bean handling the LBA players information.
 * </p>
 */
@Entity
@Table(name = "player", schema = "players", uniqueConstraints = { @UniqueConstraint(columnNames = { "player_id" }) })
public class Player {

	@Id
	@Column(name = "player_id")
	private Integer playerId;
	
	@Column(name = "team_id")
	private Integer teamId;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	public Integer getPlayerId() {
		return playerId;
	}

	public void setPlayerId(Integer playerId) {
		this.playerId = playerId;
	}

	public Integer getTeamId() {
		return teamId;
	}

	public void setTeamId(Integer teamId) {
		this.teamId = teamId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
