package org.samsara.pistachio.entity;

/**
 * Book detail entity
 * @author sczyh30
 */
public class BookDetail {

    private String ISBN;

    private String summary;

    private String authorSummary;

    private String category;

    private String categoryDetail;

    public BookDetail() {}

    public BookDetail(String ISBN, String summary, String authorSummary, String category, String categoryDetail) {
        this.ISBN = ISBN;
        this.summary = summary;
        this.authorSummary = authorSummary;
        this.category = category;
        this.categoryDetail = categoryDetail;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN == null ? null : ISBN.trim();
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary == null ? null : summary.trim();
    }

    public String getAuthorSummary() {
        return authorSummary;
    }

    public void setAuthorSummary(String authorSummary) {
        this.authorSummary = authorSummary == null ? null : authorSummary.trim();
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category == null ? null : category.trim();
    }

    public String getCategoryDetail() {
        return categoryDetail;
    }

    public void setCategoryDetail(String categoryDetail) {
        this.categoryDetail = categoryDetail;
    }

    @Override
    public String toString() {
        return "Book Detail -> {" +
                "ISBN='" + ISBN + '\'' +
                ", summary='" + summary + '\'' +
                ", authorSummary='" + authorSummary + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}