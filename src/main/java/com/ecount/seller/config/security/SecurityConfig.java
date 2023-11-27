package com.ecount.seller.config.security;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@Configuration
@RequiredArgsConstructor // final 생성자 자동 생성(lombok)
public class SecurityConfig {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public WebSecurityCustomizer configure() {
        return (web) -> web.ignoring().antMatchers( // 특정 요청 패턴 무시하도록 설정
                "/css/**",
                "/images/**",
                "/plugins/**",
                "/js/**",
                "/login",
                "/logout",
                "/join",
                "/oauth/**",
                "/",
                "/favicon.ico",
                "/error"
        );
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .cors() // CORS 필터 적용
                .and()
                .csrf().disable() // CSRF 보호 기능 비활성화
                .httpBasic().disable() // http 기본 인증 비활성화
                .formLogin().disable() // 폼 로그인 비활성화
                .headers() // http 응답 헤더 구성
                .frameOptions()
                .sameOrigin() // 동일 출처 프레임 사용 허용
                .and()
                .sessionManagement() // 세션 관리 설정
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS) // 세션 생성하지 않음
                // 권한 검사
                .and()
                .authorizeRequests()
                .antMatchers("/join", "/login", "/oauth/**").permitAll()  // 회원가입과 로그인은 모두 승인
                .and()
                .exceptionHandling();

                //.access("@JwtAuthChecker.checkAuthURI(request)"); // 권한별 메뉴 접근 허용

               /* .and()
                .addFilterBefore(new JwtFilter(jwtProvider), UsernamePasswordAuthenticationFilter.class) // JWT
                .exceptionHandling()
                .authenticationEntryPoint(authenticationEntryPoint())       // 인증
                .accessDeniedHandler(accessDeniedHandler())*/;                // 인가

        return httpSecurity.build();
    }
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
        CorsConfiguration corsConfiguration = new CorsConfiguration();

        corsConfiguration.setAllowCredentials(true);
        corsConfiguration.addAllowedOrigin("*"); // 출처
        corsConfiguration.addAllowedHeader("*"); // 헤더
        corsConfiguration.addAllowedMethod("*"); // 메서드

        urlBasedCorsConfigurationSource.registerCorsConfiguration("/api/*", corsConfiguration); // 특정 경로에 대한 cors 설정 등록

        return urlBasedCorsConfigurationSource;
    }

    private boolean isAxios(HttpServletRequest request) {
        return "axios".equals(request.getHeader("X-Request-Type"));
    }
}
