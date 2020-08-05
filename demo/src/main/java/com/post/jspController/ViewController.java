package com.post.jspController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class ViewController {
    @GetMapping("/test")
    public String testController(){
        return "hello";
    }

}
