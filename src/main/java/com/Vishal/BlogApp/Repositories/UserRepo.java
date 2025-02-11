package com.Vishal.BlogApp.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Vishal.BlogApp.Entities.User;


@Repository
public interface UserRepo extends JpaRepository<User,Integer> {

}
