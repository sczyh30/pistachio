package org.samsara.pistachio.entity;

import java.sql.Date;
import java.sql.Timestamp;

/**
 * Book basic info entity
 * @author sczyh30
 */
public class BookInfo {

    private String ISBN; //TODO: ISBN should be NUM(13) by standard
    private String name;
    private String author;
    private Date pubDate;
    private Timestamp joinDate;

    private String publisher;
    private Integer page;
    private Integer category;

    public BookInfo() {}

    public BookInfo(String ISBN, String name, String author, Date pubDate, String publisher, Integer page, Integer category) {
        this.ISBN = ISBN;
        this.name = name;
        this.author = author;
        this.pubDate = pubDate;
        this.publisher = publisher;
        this.page = page;
        this.category = category;
    }

    private BookDetail detail;
    private BookStatus status;

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

    public Timestamp getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Timestamp joinDate) {
        this.joinDate = joinDate;
    }

    public BookDetail getDetail() {
        return detail;
    }

    public void setDetail(BookDetail detail) {
        this.detail = detail;
    }

    public BookStatus getStatus() {
        return status;
    }

    public void setStatus(BookStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "BookInfo -> {" +
                "ISBN='" + ISBN + '\'' +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", pubDate=" + pubDate +
                ", joinDate=" + joinDate +
                ", publisher='" + publisher + '\'' +
                ", page=" + page +
                ", category=" + category +
                ", detail=" + detail +
                ", status=" + status +
                '}';
    }
}