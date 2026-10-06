package com.mohsyn.discoveryserver.controller;

import com.mohsyn.discoveryserver.request.RegisterClientRequest;
import com.mohsyn.discoveryserver.service.ClientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class ClientController {

  private final ClientService clientService;

  @PostMapping("/register-client")
  public ResponseEntity<Void> registerClient(RegisterClientRequest request) {

  log.info("registering service ================= {}",request.getAppName());
  clientService.registerClient(request);

  return new ResponseEntity<>(HttpStatus.CREATED);

  }


}
