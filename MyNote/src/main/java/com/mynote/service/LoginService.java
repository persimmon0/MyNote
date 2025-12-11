package com.mynote.service;

import com.mynote.model.LoginMapper;
import com.mynote.model.LoginModel;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class LoginService {

    @Autowired
    private LoginMapper loginMapper;

    /**
     * 檢查帳號密碼是否正確
     */
    public LoginModel login(String account, String password) {
        LoginModel user = loginMapper.findByAccount(account);
        if (user == null) {
            return null; // 帳號不存在
        }
        if (!user.getPassword().equals(password)) {
            return null; // 密碼錯誤
        }
        return user; // 登入成功
    }
}
