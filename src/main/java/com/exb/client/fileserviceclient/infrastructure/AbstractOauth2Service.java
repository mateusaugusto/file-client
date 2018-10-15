package com.exb.client.fileserviceclient.infrastructure;

import com.exb.client.fileserviceclient.model.Auth2TokenInfo;
import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.joda.time.DateTime;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class AbstractOauth2Service implements Oauth2Service {
    private static String GRANT_TYPE_PASSWORD = "password";
    private Auth2TokenInfo currentToken;

    public AbstractOauth2Service() {
    }

    public Auth2TokenInfo getOauth2TokenInfo() throws IOException {
        if (null == this.currentToken || this.currentToken.getExpirationDate().isBeforeNow()) {
            HttpClient client = HttpClientBuilder.create().build();
            HttpPost post = new HttpPost(this.getTokenUrl());
            post.setHeader("Authorization", "Basic " + Base64.encodeBase64String(this.getClientId().concat(":").getBytes()));
            post.setEntity(new UrlEncodedFormEntity(this.getNameValuePairs()));
            HttpResponse response = client.execute(post);
            String reply = EntityUtils.toString(response.getEntity());
            this.currentToken = Auth2TokenInfo.convertJsonToObject(reply);
            this.currentToken.setExpirationDate((new DateTime()).plusSeconds(this.currentToken.getExpiresIn() - 5));
        }

        return this.currentToken;
    }

    protected List<NameValuePair> getNameValuePairs() {
        List<NameValuePair> pairs = new ArrayList();
        pairs.add(new BasicNameValuePair("username", this.getUserName()));
        pairs.add(new BasicNameValuePair("password", this.getPassword()));
        pairs.add(new BasicNameValuePair("scope", this.getScope()));
        pairs.add(new BasicNameValuePair("client_id", this.getClientId()));
        pairs.add(new BasicNameValuePair("grant_type", GRANT_TYPE_PASSWORD));
        return pairs;
    }

    protected String getTokenUrl() {
        return String.format("%s/oauth/token", new Object[]{this.getOauthHost()});
    }

    public HttpHeaders getHeadersToken() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        try {
            headers.set("Authorization", "Bearer " + this.getOauth2TokenInfo().getAccessToken());
            headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON_UTF8));
            return headers;
        } catch (Exception var3) {
            throw new UnsupportedOperationException(var3);
        }
    }
}
