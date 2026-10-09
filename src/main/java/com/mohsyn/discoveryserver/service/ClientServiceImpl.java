package com.mohsyn.discoveryserver.service;

import com.mohsyn.discoveryserver.request.RegisterClientRequest;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class ClientServiceImpl implements ClientService {


  private static final Map<String,RegisterClientRequest> REGISTERED_CLIENTS = new HashMap<>();

  @Override
  public void registerClient(RegisterClientRequest request) {

    REGISTERED_CLIENTS.put(request.getUniqueName(),request);
    log.info("============== client registered successfully ==============");
  }

  @Override
  public void receiveHeartBeat(RegisterClientRequest request) {

    REGISTERED_CLIENTS.computeIfPresent(request.getUniqueName(),(K,V) -> {
      LocalDateTime checkInTime = LocalDateTime.now();
      V.setCheckInTimeStamp(checkInTime);
      return V;
    });
    log.info("============== heart beat received ==============");
  }

  @Override
  public List<RegisterClientRequest> getAllClientServices() {
    return List.of();
  }
}
