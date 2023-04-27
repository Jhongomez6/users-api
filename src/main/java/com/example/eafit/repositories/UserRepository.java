package com.example.eafit.repositories;

import com.example.eafit.model.User;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

  private final String FILE_PATH = "/Users/jhon.tobarg/Documents/EAFIT/users-api/src/main/resources/users_database.txt";
  //ACCEDER A UN ARCHIVO TXT PARA PERSISTIR LA INFORMACION DE LOS USUARIOS, UN USUARIO POR LINEA
  // Y CADA PROPIEDAD SEPARA POR COMA


  public List<User> getAllUsersFromDatabase(){
    try {
      List<User> users = new ArrayList<>();
      BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH));
      String line;
      while((line = reader.readLine()) != null){
        String[] fields = line.split(",");
        User user = new User(fields[1], fields[2], fields[3]);
        user.setId(fields[0]);
        user.setActive(Boolean.valueOf(fields[4]));
        users.add(user);
      }
      return users;
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
  public User saveUser(User user) {
    try {
      BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true));
      String userPropertiesString = user.getId() + "," + user.getUsername() + "," + user.getPassword() + ","
          + user.getEmail() + "," + user.isActive();
      writer.write(userPropertiesString);
      writer.newLine();
      writer.close();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    return user;
  }
}
