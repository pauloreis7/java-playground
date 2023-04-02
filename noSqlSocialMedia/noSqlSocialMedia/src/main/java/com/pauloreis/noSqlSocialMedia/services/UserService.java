package com.pauloreis.noSqlSocialMedia.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pauloreis.noSqlSocialMedia.domain.dtos.UserDTO;
import com.pauloreis.noSqlSocialMedia.domain.entities.User;
import com.pauloreis.noSqlSocialMedia.exceptions.ObjectNotFoundException;
import com.pauloreis.noSqlSocialMedia.repositories.UserRepository;

@Service
public class UserService {

  @Autowired
  private UserRepository repository;

  public List<User> findAll() {
    final List<User> users = repository.findAll();

    return users;
  }

  public User findById(final String id) {
    final Optional<User> findUser = repository.findById(id);

    return findUser.orElseThrow(() -> new ObjectNotFoundException("user not found"));
  }

  public User insert(final UserDTO userDTO) {
    final User user = new User(userDTO.getId(), userDTO.getName(), userDTO.getEmail());
    final User createdUser = repository.insert(user);

    return createdUser;
  }

  public User update(final UserDTO userDTO) {
    final User findUser = findById(userDTO.getId());

    final User updatedUser = new User(findUser.getId(), userDTO.getName(), userDTO.getEmail());

    return repository.save(updatedUser);
  }

  public void delete(final String id) {
    findById(id);
    repository.deleteById(id);
  }
}
