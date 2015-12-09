package org.samsara.pistachio.entity;

import java.sql.Date;

/**
 * Book basic info entity
 * @author sczyh30
 */
public class BookInfo {

    private String ISBN; //TODO: ISBN should be NUM(13) by standard
    private String name;
    private String author;
    private Date pubDate;

    private String publisher;
    private Integer page;
    private Integer category;

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN == null ? null : ISBN.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public Date getPubDate() {
        return pubDate;
    }

    public void setPubDate(Date pubDate) {
        this.pubDate = pubDate;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher == null ? null : publisher.trim();
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "BookInfo -> {" +
                "ISBN='" + ISBN + '\'' +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", pubDate=" + pubDate +
                ", publisher='" + publisher + '\'' +
                ", page=" + page +
                ", category=" + category +
                '}';
    }
}