package com.gbtec.lba.players.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.gbtec.lba.players.service.PlayerService;

/**
 * <p>
 * Players controller class.
 * </p>
 */
@Controller
public class PlayersController {

	@Autowired
	private PlayerService playerService;

	/**
	 * <p>
	 * Full list of players.
	 * </p>
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping(value = "/list")
	public String init(@ModelAttribute("model") ModelMap model) {
		model.addAttribute("playersList", playerService.findAll());
		return "index";
	}

}
