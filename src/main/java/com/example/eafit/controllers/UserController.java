package com.example.eafit.controllers;

import com.example.eafit.model.User;
import com.example.eafit.model.exceptions.BusinessException;
import com.example.eafit.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/users")
public class UserController {

  private UserService userService;

  @Autowired
  public UserController(UserService userService){
    this.userService = userService;
  }
  @PostMapping
  //@PathVariable
  public void crearUsuario(@RequestBody User user) {
    try {
      userService.createUser(user);
    } catch (BusinessException e) {
      //AQUI DEBEMOS RESPONDER UN CODIGO 400 + EL MENSAJE DE LA EXCEPTION.
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
    }
  }

  @GetMapping("/{}")
  public User getUser(@PathVariable String email){
    return null;
  }
}
