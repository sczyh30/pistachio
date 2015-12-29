package org.samsara.pistachio.entity;

import java.util.List;

/**
 * Samsara Pistachio
 * Notice Request Entity
 */
public class NoticeRequest {

    private int count;
    private List<Notice> notices;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Notice> getNotices() {
        return notices;
    }

    public void setNotices(List<Notice> notices) {
        this.notices = notices;
    }

    @Override
    public String toString() {
        return "NoticeRequest -> {" +
                "count=" + count +
                ", notices=" + notices +
                '}';
    }
}
