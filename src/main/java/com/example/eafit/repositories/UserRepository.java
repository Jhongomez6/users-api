package com.example.eafit.repositories;

import com.example.eafit.model.User;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

  private final String FILE_PATH = "/Users/jhon.tobarg/Downloads/users-api/src/main/resources/users_database.txt";
  //ACCEDER A UN ARCHIVO TXT PARA PERSISTIR LA INFORMACION DE LOS USUARIOS, UN USUARIO POR LINEA
  // Y CADA PROPIEDAD SEPARA POR COMA

  /**
   * @param user This is the user to be persisted in the database
   * @return
   */
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
