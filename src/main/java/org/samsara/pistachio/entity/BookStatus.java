package org.samsara.pistachio.entity;

/**
 * Book status entity
 * @author sczyh30
 */
public class BookStatus {

    //private String ISBN;

    private Integer numEntire;

    private Integer numPresent;

    private Boolean status;

    private String msg;

    /*public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN == null ? null : ISBN.trim();
    }*/

    public Integer getNumEntire() {
        return numEntire;
    }

    public void setNumEntire(Integer numEntire) {
        this.numEntire = numEntire;
    }

    public Integer getNumPresent() {
        return numPresent;
    }

    public void setNumPresent(Integer numPresent) {
        this.numPresent = numPresent;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "BookStatus => {" +
                "numEntire=" + numEntire +
                ", numPresent=" + numPresent +
                ", status=" + status +
                ", msg='" + msg + '\'' +
                '}';
    }
}