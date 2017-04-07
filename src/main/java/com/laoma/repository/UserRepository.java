package com.laoma.repository;

import com.laoma.domain.User;
import org.bson.types.ObjectId;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * @Auther: laoma
 * @create: 2017-04-07 下午4:23
 */
public interface UserRepository extends MongoRepository<User,ObjectId> {

    List<User> findByName(String name);


    List<User> findByAgeGreaterThan(int age, Pageable page);

    @Override
    List<User> findAll(Sort sort);

    List<User> findTopByOrderByAgeDesc();

    List<User> findTopByOrderByAgeAsc();



}
