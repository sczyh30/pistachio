package org.samsara.pistachio.entity;

/**
 * Samsara Pistachio
 * User token entity
 * @author sczyh30
 */
public class UserToken {

    private int code;

    private String temp_token;

    private String username;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getTemp_token() {
        return temp_token;
    }

    public void setTemp_token(String temp_token) {
        this.temp_token = temp_token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
