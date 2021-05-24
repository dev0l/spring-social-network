package com.dev0l.springsocialnetwork.repository;

import com.dev0l.springsocialnetwork.entity.Post;
import com.dev0l.springsocialnetwork.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

//    @Query(value = "SELECT user FROM User user WHERE user.name = ?1 ")
//    User getTheUserWithName(@Param("name") String name);

//  Post findByTitle(String title);

//  List<Post> findPostByUserOrderById(Optional<User> user);

//  List<Post> findAllByOrderByIdDesc();
}
