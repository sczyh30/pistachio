package org.samsara.pistachio.entity;

/**
 * Borrow status entity
 * @author sczyh30
 */
public class BorrowStatus {

    private Integer bid;

    private int status;

    private String ISBN;

    private String start;

    private String end;

    private int due;

    private String msg;

    public BorrowStatus() {}

    public BorrowStatus(Integer bid, String ISBN, int status, String start, String end, int due, String msg) {
        this.bid = bid;
        this.status = status;
        this.ISBN = ISBN;
        this.start = start;
        this.end = end;
        this.due = due;
        this.msg = msg;
    }

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN == null ? null : ISBN.trim();
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start == null ? null : start.trim();
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end == null ? null : end.trim();
    }

    public int getDue() {
        return due;
    }

    public void setDue(int due) {
        this.due = due;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "BorrowStatus -> {" +
                "bid=" + bid +
                ", status='" + status + '\'' +
                ", ISBN='" + ISBN + '\'' +
                ", start='" + start + '\'' +
                ", end='" + end + '\'' +
                ", due=" + due +
                ", msg='" + msg + '\'' +
                '}';
    }
}