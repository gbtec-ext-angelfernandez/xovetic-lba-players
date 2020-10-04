package com.gbtec.lba.players.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gbtec.lba.players.model.Player;
import com.gbtec.lba.players.repository.PlayerRepository;

/**
 * <p>
 * Players Service.
 * </p>
 */
@Service
public class PlayerService {

	@Autowired
	private PlayerRepository playerRepository;

	/**
	 * <p>
	 * Return all players information.
	 * </p>
	 * 
	 * @return Players list
	 */
	public List<Player> findAll() {
		return playerRepository.findAll();
	}

	/**
	 * <p>
	 * Return players information for a given team id.
	 * </p>
	 * 
	 * @param teamId Team id
	 * @return Players information
	 */
	public List<Player> findByTeamId(Integer teamId) {
		return playerRepository.findByTeamId(teamId);
	}

	/**
	 * <p>
	 * Return player information for a given Player id.
	 * </p>
	 * 
	 * @param abbreviation Player abbreviation
	 * @return Player information
	 */
	public Player findByPlayerId(Integer playerId) {
		return playerRepository.findByPlayerId(playerId);
	}

	/**
	 * <p>
	 * Get the total number of players in the league.
	 * </p>
	 * 
	 * @return
	 */
	public long count() {
		return playerRepository.count();
	}

	/**
	 * <p>
	 * Add a new player.
	 * </p>
	 * 
	 * @param Player Player instance
	 */
	public void insert(Player player) {
		playerRepository.save(player);
	}

}
