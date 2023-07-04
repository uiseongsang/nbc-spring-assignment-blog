package com.sparta.springlv2.jwt;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sparta.springlv2.security.UserDetailsServiceImpl;
import io.jsonwebtoken.Claims;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Slf4j(topic = "JWT 검증 및 인가")
public class JwtAuthorizationFilter extends OncePerRequestFilter {

    private final JwtUtil jwtUtil;
    private final UserDetailsServiceImpl userDetailsService;

    public JwtAuthorizationFilter(JwtUtil jwtUtil, UserDetailsServiceImpl userDetailsService) {
        this.jwtUtil = jwtUtil;
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain filterChain) throws ServletException, IOException {
        //log.info(req.getRequestURI());
        String tokenValue = jwtUtil.getJwtFromHeader(req);

//        if (StringUtils.hasText(tokenValue)) {
//            log.info("토큰 있음");
//            if (!jwtUtil.validateToken(tokenValue)) {
//                log.error("Token Error");
//                return;
//            }
//            Claims info = jwtUtil.getUserInfoFromToken(tokenValue);
//            try {
//                setAuthentication(info.getSubject());
//            } catch (Exception e) {
//                log.error(e.getMessage());
//                return;
//            }
//        }else{
//            log.info("토큰 없음");
//        }
//        filterChain.doFilter(req, res);
        if(tokenValue != null) {
            if(!jwtUtil.validateToken(tokenValue)){
                log.error("Token Error");
                return;
            }
            Claims info = jwtUtil.getUserInfoFromToken(tokenValue);
            setAuthentication(info.getSubject());
        }
        try {
            filterChain.doFilter(req, res);
        } catch(FileUploadException e){
            log.error(e.getMessage());
        }
    }


    // 인증 처리
    public void setAuthentication(String username) {
        log.info("인증 처리");
        SecurityContext context = SecurityContextHolder.createEmptyContext();
        Authentication authentication = createAuthentication(username);
        context.setAuthentication(authentication);

        SecurityContextHolder.setContext(context);
    }

    // 인증 객체 생성
    private Authentication createAuthentication(String username) {
        log.info("인증 객체 생성");
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        return new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
    }
}
