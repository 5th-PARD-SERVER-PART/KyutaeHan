package com.pard.server.hw4_blog.home.controller;

import com.pard.server.hw4_blog.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class HomeController {
    private final UserService userService;

    @GetMapping("/")
    public String home(@AuthenticationPrincipal Object principal, Model model) {
        String name = null;
        if (principal instanceof OAuth2User oAuth2User) {
            name = oAuth2User.getAttribute("name");
        } else if (principal instanceof User userDetails) {
            String email = userDetails.getUsername();
            name = userService.findByEmail(email).getName();
        }
        if (name != null) {
            model.addAttribute("userName", name);
        }
        return "home";
    }
} 