package com.upen.springsecurityjpa;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeResource {

    @GetMapping("/")
    public String home() {
        return ("<h1>Welcome | Home Page</h1>");
    }

    @GetMapping("/user")
    public String user() {
        return ("<h1>Welcome | All Users</h1>");
    }

    @GetMapping("/admin")
    public String admin() {
        return ("<h1>Welcome | Admins Only</h1>");
    }
}

