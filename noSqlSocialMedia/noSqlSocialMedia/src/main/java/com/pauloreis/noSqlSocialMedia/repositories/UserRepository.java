package com.pauloreis.noSqlSocialMedia.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.pauloreis.noSqlSocialMedia.domain.entities.User;

public interface UserRepository extends MongoRepository<User, String> {

}
