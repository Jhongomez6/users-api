package com.example.eafit.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
public class PaymentsController {

  @PostMapping
  public void savePayment(@RequestBody String payment){
    //llamar a la capa de servicios para guardar el pago que llega desde wompi.
    //Luego la capa de servicio deberia llamar a la capa de repositorio y persistir la informacion en la tabla
    // o entidad de SQL 'Payments'.
  }
}
