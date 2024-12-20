package kpi.fict.prist.admintool.user;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {

    record UserResponse(String username) {
    }

    @GetMapping("current")
    UserResponse getCurrentUser(@AuthenticationPrincipal User user) {
        return new UserResponse(user.getUsername());
    }

}
