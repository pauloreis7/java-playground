package com.pauloreis.noSqlSocialMedia.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.pauloreis.noSqlSocialMedia.domain.dtos.UserDTO;
import com.pauloreis.noSqlSocialMedia.domain.entities.Post;
import com.pauloreis.noSqlSocialMedia.domain.entities.User;
import com.pauloreis.noSqlSocialMedia.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

  @Autowired
  private UserService service;

  @GetMapping
  public ResponseEntity<List<UserDTO>> findAll() {
    final List<User> users = service.findAll();
    final List<UserDTO> usersDTO = users.stream().map(user -> new UserDTO(user)).collect(Collectors.toList());

    return ResponseEntity.ok().body(usersDTO);
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<UserDTO> findById(@PathVariable final String id) {
    final User findUser = service.findById(id);
    final UserDTO userDTO = new UserDTO(findUser);

    return ResponseEntity.ok().body(userDTO);
  }

  @GetMapping(value = "/{id}/posts")
  public ResponseEntity<List<Post>> findUserPosts(@PathVariable final String id) {
    final User findUser = service.findById(id);
    final List<Post> posts = findUser.getPosts();

    return ResponseEntity.ok().body(posts);
  }

  @PostMapping
  public ResponseEntity<UserDTO> insert(@RequestBody final UserDTO userDTO) {
    final User createdUser = service.insert(userDTO);

    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdUser.getId())
        .toUri();
    return ResponseEntity.created(uri).build();
  }

  @PutMapping(value = "/{id}")
  public ResponseEntity<Void> update(@RequestBody final UserDTO userDTO, @PathVariable final String id) {
    userDTO.setId(id);
    service.update(userDTO);

    return ResponseEntity.noContent().build();
  }

  @DeleteMapping(value = "/{id}")
  public ResponseEntity<Void> delete(@PathVariable final String id) {
    service.delete(id);

    return ResponseEntity.noContent().build();
  }
}
