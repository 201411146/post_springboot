package com.post.jspController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class ViewController {
    @GetMapping("/list")
    public String boardList(){
        return "boardList";
    }
    @GetMapping("/insert")
    public String insertBoard() {
        return "insertBoard";
    }
    @GetMapping("/update")
    public String updateBoard(){
        return "updateBoard";
    }

}
