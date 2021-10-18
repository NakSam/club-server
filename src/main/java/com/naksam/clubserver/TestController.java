package com.naksam.clubserver;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/club")
public class TestController {

    @GetMapping("test")
    public String test() {
        return "OK";
    }
}