package com.example.eafit.services;

import com.example.eafit.model.User;
import com.example.eafit.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

  @Autowired
  private UserRepository userRepository;
  @Override
  public boolean areValidCredentials(String username, String password) {
   /* User user = userRepository.findByEmailAndPassword(username, password);
    if(user == null){
      return false;
    }
    return true;*/
    // Implementa la lógica para verificar las credenciales aquí
    // Puede ser una consulta a la base de datos, llamada a un servicio, etc.
    // Retorna true si las credenciales son válidas, false en caso contrario
    // Este es solo un ejemplo simple
    return "admin@email.com".equals(username) && "password".equals(password);
  }
}
