package com.mohsyn.discoveryserver.service;

import com.mohsyn.discoveryserver.request.RegisterClientRequest;
import java.util.List;
import java.util.Set;

public interface ClientService {

  void registerClient(RegisterClientRequest request);
  void receiveHeartBeat(RegisterClientRequest request);
  Set<RegisterClientRequest> getAllClientServices();
  void removeDeadServices();
}
