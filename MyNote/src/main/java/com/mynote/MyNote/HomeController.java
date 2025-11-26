package com.mynote.MyNote;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping
	public String ahowHomePage(Model model)
	{
		model.addAttribute("title","Welcome to our mynote");
		model.addAttribute("about","I love java");
		return "home";
	}
}
