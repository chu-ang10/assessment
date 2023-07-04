package nus.edu.iss.demo.model;

import org.springframework.jdbc.support.rowset.SqlRowSet;

import jakarta.json.Json;
import jakarta.json.JsonValue;

public class BookSummary {
    private String book_id;
    private String title;
    private String authors;
    private String edition;
    private Integer pages;
    private String genres;
    private String bookcover;
    private Integer reviewcount;
    private String reviewer;
    private String reviewerDate;

    public BookSummary(String book_id, String title, String authors, String edition, Integer pages, String genres,
            String bookcover, Integer reviewcount) {
        this.book_id = book_id;
        this.title = title;
        this.authors = authors;
        this.edition = edition;
        this.pages = pages;
        this.genres = genres;
        this.bookcover = bookcover;
        this.reviewcount = reviewcount;
    }

    public BookSummary() {
    }



    @Override
    public String toString() {
        return "BookSummary [book_id=" + book_id + ", title=" + title + ", authors=" + authors + ", edition=" + edition
                + ", pages=" + pages + ", genres=" + genres + ", bookcover=" + bookcover + ", reviewcount="
                + reviewcount + ", reviewer=" + reviewer + ", reviewerDate=" + reviewerDate + "]";
    }

    public static BookSummary create(SqlRowSet rs) {
        BookSummary books = new BookSummary();

        books.setBook_id(rs.getString("book_id"));
        books.setTitle(rs.getString("title"));
        books.setAuthors(rs.getString("authors"));
        books.setEdition(rs.getString("edition"));
        books.setPages(rs.getInt("pages"));
        books.setGenres(rs.getString("genres"));
        books.setBookcover(rs.getString("bookcover"));
        books.setReviewcount(rs.getInt("reviewcount"));

        return books;
    }

    public JsonValue toJson() {
        return Json.createObjectBuilder()
                .add("book_id", getBook_id())
                .add("title", getTitle())
                .add("authors", getAuthors())
                .add("edition", getEdition())
                .add("pages", getPages())
                .add("genres", getGenres())
                .add("bookcover", getBookcover())
                .add("reviewcount", getReviewcount())
                .build();

    }

    public String getBook_id() {
        return book_id;
    }

    public void setBook_id(String book_id) {
        this.book_id = book_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReviewer() {
        return reviewer;
    }

    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }

    public String getReviewerDate() {
        return reviewerDate;
    }

    public void setReviewerDate(String reviewerDate) {
        this.reviewerDate = reviewerDate;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    public String getBookcover() {
        return bookcover;
    }

    public void setBookcover(String bookcover) {
        this.bookcover = bookcover;
    }

    public Integer getReviewcount() {
        return reviewcount;
    }

    public void setReviewcount(Integer reviewcount) {
        this.reviewcount = reviewcount;
    }

}
