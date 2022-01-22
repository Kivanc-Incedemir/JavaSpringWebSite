package com.kivanc.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/")
	public String showHome() {

		return "index";
	}

	@GetMapping("/game")
	public String gamePage() {

		return "games/game";

	}

	@GetMapping("/whack-a-mole")
	public String whack_a_mole() {

		return "games/whack-a-mole";

	}

}










