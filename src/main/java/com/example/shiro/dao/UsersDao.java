package com.example.shiro.dao;

import com.example.shiro.pojo.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersDao extends JpaRepository<Users, Long> {

    @Query("from Users where username= :userName")
    List<Users> findUsersByUserName(@Param("userName") String userName);
}
