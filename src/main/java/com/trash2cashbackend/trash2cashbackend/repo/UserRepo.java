package com.trash2cashbackend.trash2cashbackend.repo;

import com.trash2cashbackend.trash2cashbackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Integer> {

    User findByUsername(String username);


    boolean existsByUsername(String username);
}
