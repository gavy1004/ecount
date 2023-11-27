package com.ecount.seller.login.web;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Controller
@RequiredArgsConstructor
public class LoginController {

    /**
     * @description 메인 화면
     * @return String
     */
    @GetMapping(value = {"/" , "login"})
    public String main(HttpServletRequest request) {
        return "cmm/login";
    }

    /**
     * @description 회원가입 화면
     * @return String
     */
    @GetMapping(value = {"/join"})
    public String join(HttpServletRequest request) {
        return "cmm/join";
    }

}
