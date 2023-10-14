package com.sangvaleap.lab8.controller;

import com.sangvaleap.lab8.model.User;
import com.sangvaleap.lab8.model.api.AuthRequest;
import com.sangvaleap.lab8.model.api.AuthResponse;
import com.sangvaleap.lab8.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping({"/auth"})
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    @PostMapping({"/login"})
    public ResponseEntity<?> login(@RequestBody AuthRequest authRequest){

        try {
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getEmail(), authRequest.getPassword()));
            User user = (User) authentication.getPrincipal();

            String token = jwtUtil.generateAccessToken(user);
            AuthResponse authResponse = new AuthResponse(authRequest.getEmail(), token);
            return ResponseEntity.ok(authResponse);
        }catch (BadCredentialsException e){
            return  ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}
