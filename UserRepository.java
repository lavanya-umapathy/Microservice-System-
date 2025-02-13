package com.example.rest.demo_user.repository;

import com.example.rest.demo_user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface UserRepository extends JpaRepository<User,Long>{





}
