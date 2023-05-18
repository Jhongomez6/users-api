package com.example.eafit.controllers;

import com.example.eafit.dtos.AuthResponse;
import com.example.eafit.dtos.LoginRequest;
import com.example.eafit.services.AuthService;
import com.example.eafit.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authorizations")
public class AuthController {

  @Autowired
  public AuthService authService;

  @PostMapping("/login")
  public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
    // Lógica de autenticación
    // Verificar credenciales, generar token, etc.

    // Ejemplo simple: verificar que las credenciales sean válidas
    if (authService.areValidCredentials(loginRequest.getUsername(), loginRequest.getPassword())) {
      String token = JwtUtil.generateToken(loginRequest.getUsername());
      return ResponseEntity.ok(new AuthResponse(token));
    } else {
      return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
  }
}
