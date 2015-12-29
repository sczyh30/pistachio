package org.samsara.pistachio.entity;

/**
 * Book detail entity
 * @author sczyh30
 */
public class BookDetail {

    //private String ISBN;

    private String summary;

    private String authorSummary;

    private String classification;

    private String categoryDetail;

    public BookDetail() {}

    public BookDetail(String summary, String authorSummary, String classification, String categoryDetail) {
        //this.ISBN = ISBN;
        this.summary = summary;
        this.authorSummary = authorSummary;
        this.classification = classification;
        this.categoryDetail = categoryDetail;
    }

    /*public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN == null ? null : ISBN.trim();
    }*/

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

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification == null ? null : classification.trim();
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
                //"ISBN='" + ISBN + '\'' +
                "summary='" + summary + '\'' +
                ", authorSummary='" + authorSummary + '\'' +
                ", classification='" + classification + '\'' +
                '}';
    }
}