package nus.edu.iss.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonArrayBuilder;
import nus.edu.iss.demo.model.BookSummary;
import nus.edu.iss.demo.repository.BookRepository;
import nus.edu.iss.demo.service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.util.List;
import java.util.Objects;


@RestController
@RequestMapping(path = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class ReviewController {

    @Autowired
    private BookRepository repo;

    @Autowired
    private service svc;

    @GetMapping()
    public ResponseEntity<String> getBooks(String title) {

        List<BookSummary> books = repo.findBooksByTitle(title);

        JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();

        for (BookSummary b : books) {
            arrayBuilder.add(b.toJson());
        }

        JsonArray result = arrayBuilder.build();

        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(result.toString());
    }

    @PostMapping(path = "/review", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getDetails(@PathVariable String title) {
		try {
			BookSummary r = repo.getDetails(title);

			return ResponseEntity.status(HttpStatus.ACCEPTED)
					.contentType(MediaType.APPLICATION_JSON)
					.body(
							Json.createObjectBuilder()
									.add("title", r.getTitle())
									.add("authors", r.getAuthors())
									.add("pages", r.getPages())
									.add("genres", r.getGenres())
									.add("bookcover", r.getBookcover())
									.build().toString());

		} catch (IOException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.contentType(MediaType.APPLICATION_JSON)
					.body(
							Json.createObjectBuilder()
									.add("error", e.getMessage())
									.build().toString());
		}
	}


    
}
