package com.pauloreis.noSqlSocialMedia.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.pauloreis.noSqlSocialMedia.domain.dtos.AuthorDTO;
import com.pauloreis.noSqlSocialMedia.domain.dtos.CommentDTO;
import com.pauloreis.noSqlSocialMedia.domain.entities.Post;
import com.pauloreis.noSqlSocialMedia.domain.entities.User;
import com.pauloreis.noSqlSocialMedia.repositories.PostRepository;
import com.pauloreis.noSqlSocialMedia.repositories.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private PostRepository postRepository;

  @Override
  public void run(String... args) throws Exception {
    userRepository.deleteAll();
    postRepository.deleteAll();

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

    final User user1 = new User(null, "Maria Brown", "maria@gmail.com");
    final User user2 = new User(null, "Alex Green", "alex@gmail.com");
    final User user3 = new User(null, "Bob Grey", "bob@gmail.com");

    userRepository.saveAll(Arrays.asList(user1, user2, user3));

    final AuthorDTO authorDTO = new AuthorDTO(user1);

    final Post post1 = new Post(null, sdf.parse("21/03/2023"), "Lets go!", "Going to travel, bye!", authorDTO);
    final Post post2 = new Post(null, sdf.parse("23/03/2023"), "Good evening", "I am happy!", authorDTO);

    CommentDTO comment1 = new CommentDTO("Good trip!", sdf.parse("21/03/2023"), new AuthorDTO(user2));
    CommentDTO comment2 = new CommentDTO("Enjoy", sdf.parse("22/03/2023"), new AuthorDTO(user3));
    CommentDTO comment3 = new CommentDTO("Have a great day!", sdf.parse("23/03/2023"), new AuthorDTO(user2));

    post1.getComments().addAll(Arrays.asList(comment1, comment2));
    post2.getComments().addAll(Arrays.asList(comment3));

    postRepository.saveAll(Arrays.asList(post1, post2));

    user1.getPosts().addAll(Arrays.asList(post1, post2));

    userRepository.save(user1);
  }
}
