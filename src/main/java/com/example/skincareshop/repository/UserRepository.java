package com.example.skincareshop.repository;

import com.example.skincareshop.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findUserByLastName(String Name);

    User save(User user);
}
