package com.pard.server.seminar6.user.repo;



import com.pard.server.seminar6.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface UserRepo extends JpaRepository<User, Long> {
    List<User> findAllByPart(String part);
}
