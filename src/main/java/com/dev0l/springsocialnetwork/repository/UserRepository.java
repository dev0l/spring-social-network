package com.dev0l.springsocialnetwork.repository;

import com.dev0l.springsocialnetwork.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

//    @Query(value = "SELECT user FROM User user WHERE user.name = ?1 ")
//    User getTheUserWithName(@Param("name") String name);

  User findByUsername(String username);
}
