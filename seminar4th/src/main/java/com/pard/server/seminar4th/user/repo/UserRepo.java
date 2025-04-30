package com.pard.server.seminar4th.user.repo;


import com.pard.server.seminar4th.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepo extends JpaRepository<User, Long> {


}
