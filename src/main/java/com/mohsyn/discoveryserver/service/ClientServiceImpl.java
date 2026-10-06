package com.mohsyn.discoveryserver.service;

import com.mohsyn.discoveryserver.request.RegisterClientRequest;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class ClientServiceImpl implements ClientService {

  private static final Set<RegisterClientRequest> REGISTERED_CLIENTS = new HashSet<>();

  @Override
  public void registerClient(RegisterClientRequest request) {

    REGISTERED_CLIENTS.add(request);
    log.info("============== client registered successfully ==============");
  }

  @Override
  public void receiveHeartBeat(RegisterClientRequest request) {
    log.info("============== heart beat received ==============");

  }

  @Override
  public List<RegisterClientRequest> getAllClientServices() {
    return List.of();
  }
}
