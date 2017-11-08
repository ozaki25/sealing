package com.example.sealing.security;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.example.sealing.entity.Player;

public class LoginSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
        Player player = ((LoginUser)authentication.getPrincipal()).getPlayer();
        request.getSession().setAttribute("currentUser", player);
        response.sendRedirect("/home");
    }
}
