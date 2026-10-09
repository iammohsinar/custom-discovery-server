package com.mohsyn.discoveryserver.utils;

public final class ClientUtil {

    private ClientUtil() {
        throw new IllegalArgumentException("Could not initiate the ClientUtil class");
    }

    public static final String REGISTER_CLIENT = "/register-client";
    public static final String HEART_BEAT = "/heart-beat";
    public static final String FETCH_CLIENT = "/fetch-client";

    public static class LogMessage {
      public static final String UNKNOWN_HOST_MSG = "The Unknown host ";
      public static final String UNKNOWN_APP_REGISTER = "unable to register the app";
    }
}
