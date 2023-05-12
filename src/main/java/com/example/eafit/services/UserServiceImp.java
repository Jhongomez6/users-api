package com.example.eafit.services;

import com.example.eafit.model.User;
import com.example.eafit.model.exceptions.BusinessException;
import com.example.eafit.repositories.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {

  private UserRepository userRepository;

  @Autowired
  public UserServiceImp(UserRepository userRepository){
    this.userRepository = userRepository;
  }
  //logica de negocio, validaciones, restricciones, excepciones.
  @Override
  public User createUser(User user) throws BusinessException {
    //La longitud y caracteres especiales de la contraseña. (Opcional)
    if(user.getUsername() == null || user.getUsername().isBlank()){
      throw new BusinessException("Username is not valid");
    }
    if(user.getEmail() == null || user.getEmail().isBlank()) {
      throw new BusinessException("Email is not valid");
    }
    if(user.getPassword() == null || user.getPassword().isBlank()){
      throw new BusinessException("Password is not valid");
    }
    //QUE NO EXISTA EL USUARIO CON EL MISMO CORREO (NECESITAMOS UN METODO QUE NOS DEVUELVA TODOS LOS USUARIOS O CORREOS DE USUARIOS YA CREADOS
    //EN LA BASE DE DATOS.
    validateEmail(user);
    return userRepository.save(user);
  }

  public User getUser(String email) throws BusinessException {
    if(email == null || email.isBlank()) {
      throw new BusinessException("Email is not valid");
    }
    return userRepository.findByEmail(email);
  }

  private void validateEmail(User user) throws BusinessException {
    List<User> databaseUsers = userRepository.findAll();
    for(User databaseUser : databaseUsers) {
      if(databaseUser.getEmail().equalsIgnoreCase(user.getEmail())){
        throw new BusinessException("Email already exists");
      }
    }
  }
}
