package com.ecount.seller.config.oauth2.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.URLEncoder;
import java.security.SecureRandom;
@Slf4j
@Service
public class OauthService extends DefaultOAuth2UserService {

    public String createKakaoURL() throws UnsupportedEncodingException {
        log.info("createKakaoURL () ");
        StringBuffer url = new StringBuffer();

        // 카카오 API 명세에 맞춰서 작성
        String redirectURI = URLEncoder.encode("http://localhost:8085/oauth/kakao", "UTF-8"); // redirectURI 설정 부분
        SecureRandom random = new SecureRandom();
        String state = new BigInteger(130, random).toString();
        https://kauth.kakao.com/oauth/authorize?response_type=code
        // &client_id=d03e021cb31c4dd3c15c10d2767c872
        // 3&redirect_uri=https%3A%2F%2Fauth.data.go.kr%2Fsso%2Fauth%2Fk%2Fcallback
        url.append("https://kauth.kakao.com/oauth/authorize?response_type=code");
        url.append("&client_id=" + "6dc30ede4b65bf92996819f7b936c627");
        url.append("&redirect_uri=" + redirectURI);



        return url.toString();
    }
}
