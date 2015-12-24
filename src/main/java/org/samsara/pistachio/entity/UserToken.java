package org.samsara.pistachio.entity;

/**
 * Samsara Pistachio
 * User token entity
 * @author sczyh30
 */
public class UserToken {

    private int code;

    private String temp_token;

    private User user;

    public UserToken() {}

    public UserToken(int code, String temp_token, User user) {
        this.code = code;
        this.temp_token = temp_token;
        this.user = user;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getTempToken() {
        return temp_token;
    }

    public void setTempToken(String temp_token) {
        this.temp_token = temp_token;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
