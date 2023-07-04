package nus.edu.iss.demo.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import nus.edu.iss.demo.model.BookSummary;

public class BooksRowMapper implements RowMapper<BookSummary> {

    @Override
    public BookSummary mapRow(ResultSet rs, int rowNum) throws SQLException {
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

}
