package com.mynote.MyNote;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

//	@GetMapping("/")
//	public String ahowHomePage()
//	{
//		return "home";
//	}

	//首頁(login)
    @GetMapping("/")
    public String HomePage() {
        return "login";
    }

	//login.html
    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    //notes.html
    @GetMapping("/notes")
    public String showNotesPage() {
        return "notes";
    }
}
