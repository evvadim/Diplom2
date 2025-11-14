package data.user.common;

import data.user.common.elements.ElementUser;

public class CommonUserDataFields {

    private Boolean success;
    private ElementUser user;
    private String accessToken;
    private String refreshToken;

    public CommonUserDataFields(Boolean success, ElementUser user, String accessToken, String refreshToken) {
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

    public ElementUser getUser() {
        return user;
    }

    public void setUser(ElementUser user) {
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
