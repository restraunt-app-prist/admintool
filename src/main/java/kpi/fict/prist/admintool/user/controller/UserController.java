package kpi.fict.prist.admintool.user.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kpi.fict.prist.admintool.user.dto.UserWithOrdersResponse;
import kpi.fict.prist.admintool.user.entity.UserProfileEntity;
import kpi.fict.prist.admintool.user.service.UserService;

@RestController
@RequestMapping("user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    record UserResponse(String username) {
    }

    @GetMapping
    List<UserProfileEntity> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("{id}")
    public ResponseEntity<UserWithOrdersResponse> getUserById(@PathVariable String id) {
        return userService.findById(id)
            .map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("current")
    UserResponse getCurrentUser(@AuthenticationPrincipal User user) {
        return new UserResponse(user.getUsername());
    }
}
