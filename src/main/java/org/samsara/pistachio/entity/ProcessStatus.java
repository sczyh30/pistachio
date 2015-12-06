package org.samsara.pistachio.entity;

/**
 * Samsara Pistachio
 * Process status entity
 * @author sczyh30
 */
public class ProcessStatus {

    private int code;
    private String msg;

    public ProcessStatus() {}

    public ProcessStatus(int code, String msg) {
        this.code = code;
        this.msg = msg;
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

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
