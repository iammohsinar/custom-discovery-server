package com.mohsyn.discoveryserver.controller;

import static com.mohsyn.discoveryserver.utils.ClientUtil.FETCH_CLIENT;
import static com.mohsyn.discoveryserver.utils.ClientUtil.HEART_BEAT;
import static com.mohsyn.discoveryserver.utils.ClientUtil.REGISTER_CLIENT;

import com.mohsyn.discoveryserver.request.RegisterClientRequest;
import com.mohsyn.discoveryserver.service.ClientService;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class ClientController {

  private final ClientService clientService;

  @PostMapping(REGISTER_CLIENT)
  public ResponseEntity<Void> registerClient(RegisterClientRequest request) {

    log.info("registering service ================= {}",request.getAppName());

    clientService.registerClient(request);
    return new ResponseEntity<>(HttpStatus.CREATED);
  }

  @PostMapping(HEART_BEAT)
  public ResponseEntity<Void> heartBeat(RegisterClientRequest request) {

    clientService.receiveHeartBeat(request);
    return new ResponseEntity<>(HttpStatus.CREATED);
  }

  @GetMapping(FETCH_CLIENT)
  public ResponseEntity<Set<RegisterClientRequest>> getAllRegisteredClients() {
    return ResponseEntity.ok(clientService.getAllClientServices());
  }

}
