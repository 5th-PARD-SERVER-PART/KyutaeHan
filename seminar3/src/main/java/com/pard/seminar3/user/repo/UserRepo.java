package com.pard.seminar3.user.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import com.pard.seminar3.user.entity.User;
public interface UserRepo extends JpaRepository<User, Long> {
    public User findByEmail(String email);
}
