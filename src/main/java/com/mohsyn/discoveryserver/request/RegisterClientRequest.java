package com.mohsyn.discoveryserver.request;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class RegisterClientRequest {
  private String appName;
  private int port;
  private String remoteAddress;
  private String uniqueName;
  @EqualsAndHashCode.Exclude
  private LocalDateTime checkInTimeStamp;
  @EqualsAndHashCode.Exclude
  private LocalDateTime checkOutTimeStamp;
}