package com.example.eafit.services;

import com.example.eafit.model.User;
import com.example.eafit.model.exceptions.BusinessException;

public interface UserService {

  void createUser(User user) throws BusinessException;
}
