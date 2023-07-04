package nus.edu.iss.demo.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Sort;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import nus.edu.iss.demo.model.BookSummary;

import static nus.edu.iss.demo.repository.DBQueries.*;




@Repository

public class BookRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<BookSummary> findBooksByTitle(String title) {
        
        List<BookSummary> books = new ArrayList<BookSummary>();

        SqlRowSet rs = jdbcTemplate.queryForRowSet(SELECT_BOOKS,
                );

        while (rs.next()) {
            books.add(BookSummary.create(rs));
        }

        return books;
    }


    public List<BookSummary> getDetails(String title) {
        
        List<BookSummary> books = new ArrayList<BookSummary>();

        SqlRowSet rs = jdbcTemplate.queryForRowSet(SELECT_BOOK_DETAILS,
                );

        while (rs.next()) {
            books.add(BookSummary.create(rs));
        }

        return books;
    }
    


}

