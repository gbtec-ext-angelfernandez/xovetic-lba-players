package com.gbtec.lba.players;

import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gbtec.lba.players.model.Player;
import com.gbtec.lba.players.service.PlayerService;

@Component
public class PlayersInitializer implements ApplicationListener<ContextRefreshedEvent> {

	private static final Logger LOG = LoggerFactory.getLogger(PlayersInitializer.class);

	private static final String DEFAULT_PLAYERS_FILE_LOCATION = "assets/default-players.json";

	@Autowired
	private PlayerService playerService;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		LOG.info("Players startup");

		long totalPlayers = playerService.count();
		LOG.info("Total players: {}", totalPlayers);

		if (totalPlayers == 0) {
			insertDefaultPlayers();
		}
	}

	private void insertDefaultPlayers() {
		List<Player> players = readDefaultPlayers();

		LOG.info("Reading default players file");

		for (Player player : players) {
			if (playerService.findByPlayerId(player.getPlayerId()) == null) {
				LOG.info("Adding '{} {}' to players table", player.getFirstName(), player.getLastName());
				playerService.insert(player);
			}
		}
	}

	private List<Player> readDefaultPlayers() {

		List mapList = new ArrayList<>();

		try {
			ObjectMapper mapper = new ObjectMapper();

			mapList = mapper.readValue(
					new InputStreamReader(new ClassPathResource(DEFAULT_PLAYERS_FILE_LOCATION).getInputStream(),
							StandardCharsets.UTF_8),
					List.class);
		} catch (IOException e) {
			LOG.error("", e);
		}
		return convertToPlayers(mapList);
	}

	private List<Player> convertToPlayers(List mapList) {
		List<Player> result = new ArrayList<>();

		for (Object mapElement : mapList) {
			if (mapElement instanceof Map) {
				Map data = (Map) mapElement;

				Player newPlayer = new Player();
				newPlayer.setTeamId(Integer.valueOf(data.get("teamId").toString()));
				newPlayer.setPlayerId(Integer.valueOf(data.get("playerId").toString()));
				newPlayer.setFirstName(data.get("firstName").toString());
				newPlayer.setLastName(data.get("lastName").toString());
				result.add(newPlayer);
			}
		}
		return result;
	}
}