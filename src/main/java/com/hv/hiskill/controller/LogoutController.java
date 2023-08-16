package com.hv.hiskill.controller;

import com.hv.hiskill.security.jwt.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/v1")
public class LogoutController {

    @Autowired
    private JwtUtils jwtUtils;
    @PostMapping("/logout")
    public ResponseEntity<String> logout(HttpServletRequest request) {
        String headerAuth = request.getHeader("Authorization");
        if (headerAuth != null && headerAuth.startsWith("Bearer ")) {
            String jwt = headerAuth.substring(7);
            String username = jwtUtils.getUserNameFromJwtToken(jwt);

            jwtUtils.invalidateToken(jwt);

            return ResponseEntity.ok("User " + username + " has been logged out successfully.");
        } else {

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid or missing JWT token in the Authorization header.");
        }
    }
}

