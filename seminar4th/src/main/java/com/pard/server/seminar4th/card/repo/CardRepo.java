package com.pard.server.seminar4th.card.repo;

import com.pard.server.seminar4th.card.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepo extends JpaRepository<Card, Long> {

}
