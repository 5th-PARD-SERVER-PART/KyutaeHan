package com.pard.server.seminar4th.card.service;


import com.pard.server.seminar4th.card.dto.CardRequest;
import com.pard.server.seminar4th.card.entity.Card;
import com.pard.server.seminar4th.card.repo.CardRepo;
import com.pard.server.seminar4th.user.entity.User;
import com.pard.server.seminar4th.user.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CardService {
    private final CardRepo cardRepo;
    private final UserRepo userRepo;

    public void createCard(CardRequest.CardCreateRequest req) {
        Optional<User> u = userRepo.findById(req.getUserId());
        User user = u.get();

        Card card = Card.builder()
                .id(null)
                .name(req.getName())
                .user(user)
                .build();

        card.assignUser(user);
        cardRepo.save(card);
        userRepo.save(user);
    }


}
