package com.pauloreis.noSqlSocialMedia.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pauloreis.noSqlSocialMedia.domain.entities.Post;
import com.pauloreis.noSqlSocialMedia.exceptions.ObjectNotFoundException;
import com.pauloreis.noSqlSocialMedia.repositories.PostRepository;

@Service
public class PostService {

  @Autowired
  private PostRepository repository;

  public Post findById(final String id) {
    final Optional<Post> findPost = repository.findById(id);

    return findPost.orElseThrow(() -> new ObjectNotFoundException("post not found"));
  }

  public List<Post> findByTitle(final String text) {
    final List<Post> posts = repository.searchTitle(text);

    return posts;
  }

  public List<Post> fullSearch(final String text, final Date minDate, final Date maxDate) {
    final Date maxDateOfNextDay = new Date(maxDate.getTime() + 1000 * 60 * 60 * 24);

    final List<Post> posts = repository.fullSearch(text, minDate, maxDateOfNextDay);

    return posts;
  }
}
