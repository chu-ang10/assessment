package nus.edu.iss.demo.service;

import java.io.IOException;
import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import nus.edu.iss.demo.model.BookSummary;
import nus.edu.iss.demo.repository.BookRepository;

public class service {

    @Autowired
	private BookRepository repo;

    @Value("${bookreview.api.url}")
    private String bookReviewUrl;

	@Value("${bookreview.api.key}")
    private String bookReviewKey;

		public Optional<BookSummary> getReviews(BookSummary rr)
            throws IOException {

		String reviewurl = "/reviews.json?"; 
       	String finalReview = UriComponentsBuilder
                .fromUriString(reviewurl)
                .queryParam("fname", rr.getTitle())
				.queryParam("api-key", bookReviewKey)
                .toUriString();
        RestTemplate template = new RestTemplate();
        ResponseEntity<String> resp = null;
	

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		headers.setAccept(List.of(MediaType.TEXT_PLAIN));



		// HttpEntity<MultiValueMap<String, String>> req = new HttpEntity<>(respBody, headers);

		// try {
		// 	resp = template.exchange(URI.create(), HttpMethod.POST, req, String.class);
		// } catch (RestClientException e) {
		// 	throw new IOException("Error placing order");
		// }

		// String[] respBody = resp.getBody().split(",");

		return headers;


	}


    
}
