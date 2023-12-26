package com.fuad.proposalManagement.home;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class HomeController {
    @GetMapping("/home")
    public String homePage(){
        return "Hello World";
    }


}
