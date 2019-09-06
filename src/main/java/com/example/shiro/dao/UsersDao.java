package com.example.shiro.dao;

import com.example.shiro.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersDao extends JpaRepository<User, Long> {

    @Query("from User where name= :name")
    List<User> findUsersByUserName(@Param("name") String userName);
}
