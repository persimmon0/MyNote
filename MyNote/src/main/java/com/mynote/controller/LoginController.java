package com.mynote.controller;

import com.mynote.model.LoginModel;
import com.mynote.service.LoginService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    // 處理登入 POST
    @PostMapping("/login")
    @ResponseBody
    public String login(
            @RequestParam String account,
            @RequestParam String password,
            HttpSession session
    ) {
        LoginModel user = loginService.login(account, password);

        if (user == null) {
            return "fail";
        }

        // session 中記錄使用者資訊
        session.setAttribute("user", user);

        return "ok";
    }
}
