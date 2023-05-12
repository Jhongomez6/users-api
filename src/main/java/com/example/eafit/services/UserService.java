package com.example.eafit.services;

import com.example.eafit.model.User;
import com.example.eafit.model.exceptions.BusinessException;

public interface UserService {

  User createUser(User user) throws BusinessException;

  User getUser(String email) throws BusinessException;
}
