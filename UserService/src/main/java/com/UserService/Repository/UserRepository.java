package com.UserService.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.UserService.Entities.User;

public interface UserRepository extends JpaRepository<User, Long> 
{

}
