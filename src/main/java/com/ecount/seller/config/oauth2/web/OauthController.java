package com.ecount.seller.config.oauth2.web;

import com.ecount.seller.config.oauth2.service.OauthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.UnsupportedEncodingException;
@Slf4j
@RequestMapping("/oauth")
@RequiredArgsConstructor
@Controller
public class OauthController {
    private final OauthService oauthService;

    @GetMapping(value = "/getKakaoUrl")
    public ResponseEntity<?> kakaoConnect() throws UnsupportedEncodingException {
        //네이버 지정 URL + 본인앱의_clientId + 암호화용_state값 + 인코딩된_Redirect_URL 이 반환되어야 한다.
        String url = oauthService.createKakaoURL();
        log.info("============================== url ============================= " + url);
        return new ResponseEntity<>(url, HttpStatus.OK);
    }

    @GetMapping(value = "/kakao")
    public String defkakao(){
        log.info("anjdi dhodksehl");
        return "";
    }
}
