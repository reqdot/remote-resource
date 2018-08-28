package com.repl.remoteresource;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
public class UserController {

    @RequestMapping("/api/profile")
    public ResponseEntity<UserProfile> profile(Principal principal) {
        System.out.println("success!!");

        // 방법 3) 이것 사용 안 됨(String을 왜 User로 캐스팅하느냐고 따짐)
//        User user = (User) SecurityContextHolder.getContext()
//                .getAuthentication().getPrincipal();

        // 방법 1) 대신 parameter에 있는 principal은 없어도 됨
//        Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
//        String username = loggedInUser.getName();

        // 방법 2)
        String username = principal.getName();
        String email = username + "@mailinator.com";

        UserProfile profile = new UserProfile();
        profile.setName(username);
        profile.setEmail(email);

        return ResponseEntity.ok(profile);
    }
}
