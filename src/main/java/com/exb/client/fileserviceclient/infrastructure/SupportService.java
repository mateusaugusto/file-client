package com.exb.client.fileserviceclient.infrastructure;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

public abstract class SupportService extends AbstractOauth2Service {

    @Value("${oauth.host.name}")
    private String hostName;

    @Value("${oauth.user.name}")
    private String userName;

    @Value("${oauth.password}")
    private String password;

    private final RestTemplate restTemplate = new RestTemplate();

    protected HttpEntity<Object> getRequest() {
        return new HttpEntity<>(this.getHeadersToken());
    }

    protected HttpEntity<Object> getRequestWithOutAccept() {
        return new HttpEntity<>(this.getHeadersTokenWithoutAcept());
    }

    protected RestTemplate getRestTemplate() {
        return this.restTemplate;
    }

    @Override
    public String getOauthHost() {
        return this.hostName;
    }

    @Override
    public String getUserName() {
        return this.userName;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getClientId() {
        return "webapp";
    }

    @Override
    public String getScope() {
        return "write";
    }

}
