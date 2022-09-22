package com.pp.springboot.SpringBoot.repositories;

import com.pp.springboot.SpringBoot.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
