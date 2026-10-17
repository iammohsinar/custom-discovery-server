package com.mohsyn.discoveryserver.service;

import com.mohsyn.discoveryserver.request.RegisterClientRequest;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class ClientServiceImpl implements ClientService {


  private static final Map<String,RegisterClientRequest> REGISTERED_CLIENTS = new ConcurrentHashMap<>();

  @Override
  public void registerClient(RegisterClientRequest request) {
    request.setCheckInTimeStamp(LocalDateTime.now());
    REGISTERED_CLIENTS.put(request.getUniqueName(),request);
    log.info("==== client {} registered successfully ====",request.getUniqueName());
  }

  @Override
  public void receiveHeartBeat(RegisterClientRequest request) {
    REGISTERED_CLIENTS.computeIfPresent(request.getUniqueName(),(K,V) -> {
      LocalDateTime checkInTime = LocalDateTime.now();
      V.setCheckInTimeStamp(checkInTime);
      return V;
    });
    log.info("==== heart beat {} received ====",request.getUniqueName());
  }

  @Override
  public Set<RegisterClientRequest> getAllClientServices() {
    Set<RegisterClientRequest> registerClients = new HashSet<>();
    for(Map.Entry<String, RegisterClientRequest> service: REGISTERED_CLIENTS.entrySet()) {
      registerClients.add(service.getValue());
    }
    log.info("==== Total {} clients registered ====",registerClients.size());
    return registerClients;
  }

  @Scheduled(fixedDelay = 30000)
  @Override
  public void removeDeadServices() {
    REGISTERED_CLIENTS.values().removeIf(client -> {
      log.info("CHECKING :: service {}", client.getUniqueName());
      boolean removedService = ChronoUnit.SECONDS.between(client.getCheckInTimeStamp(),LocalDateTime.now()) >= 90;
      if(removedService) {
        log.info("REMOVED..!! :: service {}", client.getUniqueName());
      }
      return removedService;
    });
  }
}
