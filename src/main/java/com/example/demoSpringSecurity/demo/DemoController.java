package com.example.demoSpringSecurity.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("beipiel/demoController")
public class DemoController {

    @GetMapping
    public ResponseEntity<String> sagHallo() {
        return ResponseEntity.ok("Hallo, du bist hier sicher");
    }
}
