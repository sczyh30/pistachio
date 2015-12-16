package org.samsara.pistachio.entity;

/**
 * Book category entity
 * @author sczyh30
 */
public class BookCategory {

    private Integer cid;

    private String name;

    public BookCategory(String name) {
        this.name = name;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}