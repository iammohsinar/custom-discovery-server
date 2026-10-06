package com.mohsyn.discoveryserver.service;

import com.mohsyn.discoveryserver.request.RegisterClientRequest;
import java.util.List;

public interface ClientService {

  void registerClient(RegisterClientRequest request);
  void receiveHeartBeat(RegisterClientRequest request);
  List<RegisterClientRequest> getAllClientServices();
}
