package com.pauloreis.noSqlSocialMedia.resources;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.pauloreis.noSqlSocialMedia.domain.entities.Post;
import com.pauloreis.noSqlSocialMedia.resources.utils.URL;
import com.pauloreis.noSqlSocialMedia.services.PostService;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

  @Autowired
  private PostService service;

  @GetMapping(value = "/{id}")
  public ResponseEntity<Post> findById(@PathVariable final String id) {
    final Post findPost = service.findById(id);

    return ResponseEntity.ok().body(findPost);
  }

  @GetMapping(value = "/titlesearch")
  public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") final String text) {
    final String decodedText = URL.decodeParam(text);
    final List<Post> posts = service.findByTitle(decodedText);

    return ResponseEntity.ok().body(posts);
  }

  @GetMapping(value = "/fullsearch")
  public ResponseEntity<List<Post>> fullSearch(
      @RequestParam(value = "text", defaultValue = "") String text,
      @RequestParam(value = "minDate", defaultValue = "") String stringMinDate,
      @RequestParam(value = "maxDate", defaultValue = "") String stringMaxDate) {

    final String decodedText = URL.decodeParam(text);

    final Date minDate = URL.convertDate(stringMinDate, new Date(0L));
    final Date maxDate = URL.convertDate(stringMaxDate, new Date());

    final List<Post> posts = service.fullSearch(decodedText, minDate, maxDate);

    return ResponseEntity.ok().body(posts);
  }
}
