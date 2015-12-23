package org.samsara.pistachio.entity;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Samsara Pistachio
 * Process status entity
 * @author sczyh30
 */
public class ProcessStatus {

    private int code;
    private String psid;
    private String msg;
    private int level;
    private int userid;
    private Timestamp time;

    public ProcessStatus() {}

    public ProcessStatus(int code, String psid, String msg) {
        this.code = code;
        this.psid = psid;
        this.msg = msg;
    }

    public ProcessStatus(int code, String psid, String msg, int level, int userid, Timestamp time) {
        this.code = code;
        this.psid = psid;
        this.msg = msg;
        this.level = level;
        this.userid = userid;
        this.time = time;
    }

    public String getPsid() {
        return psid;
    }

    public void setPsid(String psid) {
        this.psid = psid;
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

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }
}
