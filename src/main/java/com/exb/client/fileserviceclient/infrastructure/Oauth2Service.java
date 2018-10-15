package com.exb.client.fileserviceclient.infrastructure;

import org.springframework.http.HttpHeaders;

public interface Oauth2Service {

    HttpHeaders getHeadersToken();

    String getOauthHost();

    String getUserName();

    String getPassword();

    String getClientId();

    String getScope();
}
