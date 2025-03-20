package com.example.Book.Management.System.repository;

import com.example.Book.Management.System.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
