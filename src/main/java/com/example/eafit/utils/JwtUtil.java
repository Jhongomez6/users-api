package com.example.eafit.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import javax.crypto.SecretKey;
import io.jsonwebtoken.security.Keys;

public class JwtUtil {

  // Clave secreta para firmar y verificar el token
  public static final SecretKey SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256);
  // Duración del token (en milisegundos)
  private static final long EXPIRATION_TIME = 864_000_000; // 10 días

  // Generar un nuevo token JWT
  public static String generateToken(String username) {
    Date now = new Date();
    Date expirationDate = new Date(now.getTime() + EXPIRATION_TIME);

    return Jwts.builder()
        .setSubject(username)
        .setIssuedAt(now)
        .setExpiration(expirationDate)
        .signWith(SECRET_KEY)
        .compact();
  }

  // Verificar y obtener los datos del token
  public static String getUsernameFromToken(String token) {
    Claims claims = Jwts.parserBuilder()
        .setSigningKey(SECRET_KEY)
        .build()
        .parseClaimsJws(token)
        .getBody();

    return claims.getSubject();
  }
}
