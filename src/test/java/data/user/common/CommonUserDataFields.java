package data.user.common;

import data.user.common.elements.OwnerData;

public class CommonUserDataFields {

    private Boolean success;
    private OwnerData user;
    private String accessToken;
    private String refreshToken;

    public CommonUserDataFields(Boolean success, OwnerData user, String accessToken, String refreshToken) {
        this.success = success;
        this.user = user;
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
    }

    public CommonUserDataFields() {
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public OwnerData getUser() {
        return user;
    }

    public void setUser(OwnerData user) {
        this.user = user;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

}
