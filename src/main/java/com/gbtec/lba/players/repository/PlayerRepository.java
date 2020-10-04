package com.gbtec.lba.players.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gbtec.lba.players.model.Player;

@Repository
public interface PlayerRepository extends CrudRepository<Player, Serializable> {
	
	List<Player> findAll();
	
	Player findByPlayerId(Integer playerId);
	
	List<Player> findByTeamId(Integer teamId);

}
