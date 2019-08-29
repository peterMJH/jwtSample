package com.jwt.example.control;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExceptionController {

    @GetMapping(value = "/accessdenied")
    public void accessdeniedException() {
        throw new AccessDeniedException("");
    }
}