package com.springboot.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.springboot.spring.entities.User;


@Repository
public interface UserRepository extends JpaRepository<User,Integer>{
    //way to write custom query
   //@Query("UPDATE User u SET u.name = :name, u.email = :email, u.department = :department WHERE u.ID = :id")
  //int updateUser(@Param("id") int id, @Param("name") String name, @Param("email") String email, @Param("department") String department);
}