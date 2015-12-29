package org.samsara.pistachio.entity;

/**
 * Samsara Pistachio
 * Notice Entity
 */
public class Notice {

    private int nid;
    private String title;
    private String body;
    private int type;

    public int getNid() {
        return nid;
    }

    public void setNid(int nid) {
        this.nid = nid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Notice -> {" +
                "nid=" + nid +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", type=" + type +
                '}';
    }
}
