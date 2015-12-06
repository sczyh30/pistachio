package org.samsara.pistachio.entity;

/**
 * Request error entity
 * @author sczyh30
 */
public class RequestError {

    public int code;
    public String msg;
    public String request;

    public RequestError() {}

    public RequestError(int code, String msg, String request) {
        this.code = code;
        this.msg = msg;
        this.request = request;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String message) {
        this.msg = message;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }
}
