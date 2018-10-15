package com.exb.client.fileserviceclient.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import org.joda.time.DateTime;

public class Auth2TokenInfo {
    @JsonProperty("access_token")
    private String accessToken;
    @JsonProperty("token_type")
    private String tokenType;
    @JsonProperty("refresh_token")
    private String refreshToken;
    @JsonProperty("expires_in")
    private int expiresIn;
    private DateTime expirationDate;
    private String scope;
    private String jti;


    public static Auth2TokenInfo convertJsonToObject(String auth2TokenInfo) throws IOException {
        return (Auth2TokenInfo)(new ObjectMapper()).readValue(auth2TokenInfo, Auth2TokenInfo.class);
    }

    public Auth2TokenInfo() {
    }

    public String getAccessToken() {
        return this.accessToken;
    }

    public String getTokenType() {
        return this.tokenType;
    }

    public String getRefreshToken() {
        return this.refreshToken;
    }

    public int getExpiresIn() {
        return this.expiresIn;
    }

    public DateTime getExpirationDate() {
        return this.expirationDate;
    }

    public String getScope() {
        return this.scope;
    }

    public String getJti() {
        return this.jti;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public void setExpiresIn(int expiresIn) {
        this.expiresIn = expiresIn;
    }

    public void setExpirationDate(DateTime expirationDate) {
        this.expirationDate = expirationDate;
    }



    public boolean equals(Object o) {
        if(o == this) {
            return true;
        } else if(!(o instanceof Auth2TokenInfo)) {
            return false;
        } else {
            Auth2TokenInfo other = (Auth2TokenInfo)o;
            if(!other.canEqual(this)) {
                return false;
            } else {
                label87: {
                    Object this$accessToken = this.getAccessToken();
                    Object other$accessToken = other.getAccessToken();
                    if(this$accessToken == null) {
                        if(other$accessToken == null) {
                            break label87;
                        }
                    } else if(this$accessToken.equals(other$accessToken)) {
                        break label87;
                    }

                    return false;
                }

                Object this$tokenType = this.getTokenType();
                Object other$tokenType = other.getTokenType();
                if(this$tokenType == null) {
                    if(other$tokenType != null) {
                        return false;
                    }
                } else if(!this$tokenType.equals(other$tokenType)) {
                    return false;
                }

                label73: {
                    Object this$refreshToken = this.getRefreshToken();
                    Object other$refreshToken = other.getRefreshToken();
                    if(this$refreshToken == null) {
                        if(other$refreshToken == null) {
                            break label73;
                        }
                    } else if(this$refreshToken.equals(other$refreshToken)) {
                        break label73;
                    }

                    return false;
                }

                if(this.getExpiresIn() != other.getExpiresIn()) {
                    return false;
                } else {
                    label65: {
                        Object this$expirationDate = this.getExpirationDate();
                        Object other$expirationDate = other.getExpirationDate();
                        if(this$expirationDate == null) {
                            if(other$expirationDate == null) {
                                break label65;
                            }
                        } else if(this$expirationDate.equals(other$expirationDate)) {
                            break label65;
                        }

                        return false;
                    }

                    Object this$scope = this.getScope();
                    Object other$scope = other.getScope();
                    if(this$scope == null) {
                        if(other$scope != null) {
                            return false;
                        }
                    } else if(!this$scope.equals(other$scope)) {
                        return false;
                    }

                    Object this$jti = this.getJti();
                    Object other$jti = other.getJti();
                    if(this$jti == null) {
                        if(other$jti != null) {
                            return false;
                        }
                    } else if(!this$jti.equals(other$jti)) {
                        return false;
                    }

                    return true;
                }
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof Auth2TokenInfo;
    }

    public int hashCode() {
        boolean PRIME = true;
        int result = 1;
        Object $accessToken = this.getAccessToken();
        result = result * 59 + ($accessToken == null ? 43 : $accessToken.hashCode());
        Object $tokenType = this.getTokenType();
        result = result * 59 + ($tokenType == null?43:$tokenType.hashCode());
        Object $refreshToken = this.getRefreshToken();
        result = result * 59 + ($refreshToken == null?43:$refreshToken.hashCode());
        result = result * 59 + this.getExpiresIn();
        Object $expirationDate = this.getExpirationDate();
        result = result * 59 + ($expirationDate == null?43:$expirationDate.hashCode());
        Object $scope = this.getScope();
        result = result * 59 + ($scope == null?43:$scope.hashCode());
        Object $jti = this.getJti();
        result = result * 59 + ($jti == null?43:$jti.hashCode());
        return result;
    }

    public String toString() {
        return "Auth2TokenInfo(accessToken=" + this.getAccessToken() + ", tokenType=" + this.getTokenType() + ", refreshToken=" + this.getRefreshToken() + ", expiresIn=" + this.getExpiresIn() + ", expirationDate=" + this.getExpirationDate() + ", scope=" + this.getScope() + ", jti=" + this.getJti() + ")";
    }
}
