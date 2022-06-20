package com.nkcode.user.controller;

import com.nkcode.user.VO.ResponseTemplate;
import com.nkcode.user.entity.User;
import com.nkcode.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/")
    public User saveUser(@RequestBody User user) {
        log.info("Inside saveUser method in User controller");
        return userService.saveUser(user);
    }

    @GetMapping("/{id}")
    public ResponseTemplate getUserWithDepartment(@PathVariable("id") Long userId) {
        log.info("Inside getUserWithDepartment method in User controller");
        return userService.getUserWithDepartment(userId);
    }
}
