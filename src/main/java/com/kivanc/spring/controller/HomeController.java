package com.kivanc.spring.controller;

import com.kivanc.spring.entity.BlogPost;
import com.kivanc.spring.service.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {


	@Autowired
	BlogPostService blogPostService;

	@GetMapping("/")
	public String showHome() {

		return "index";
	}

	@GetMapping("/blog")
	public String blog(Model theModel) {

		List<BlogPost> blogPostList = blogPostService.findAllBlogPosts();

		theModel.addAttribute("blogPosts",blogPostList);

		return "blog";
	}

	@GetMapping("/game")
	public String gamePage() {

		return "games/game";

	}

	@GetMapping("/whack-a-mole")
	public String whack_a_mole() {

		return "games/whack-a-mole";

	}
	@GetMapping("/connect-four")
	public String connect_four() {

		return "games/connect-four";

	}

	@GetMapping("/snake")
	public String snake() {

		return "games/snake";

	}

	@GetMapping("/space-invaders")
	public String space_invaders() {

		return "games/space-invaders";

	}
	@GetMapping("/frogger")
	public String frogger() {

		return "games/frogger";

	}

	@GetMapping("/tetris")
	public String tetris() {

		return "games/tetris";

	}

}










