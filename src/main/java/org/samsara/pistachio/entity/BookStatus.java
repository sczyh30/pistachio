package org.samsara.pistachio.entity;

/**
 * Book status entity
 * @author sczyh30
 */
public class BookStatus {

    private String ISBN;

    private Integer numEntire;

    private Integer numPresent;

    private Boolean status;

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN == null ? null : ISBN.trim();
    }

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

    @Override
    public String toString() {
        return "BookStatus -> {" +
                "ISBN='" + ISBN + '\'' +
                ", numEntire=" + numEntire +
                ", numPresent=" + numPresent +
                ", status=" + status +
                '}';
    }
}