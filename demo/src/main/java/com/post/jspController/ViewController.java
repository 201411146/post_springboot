package com.post.jspController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class ViewController {
    @GetMapping("/{id}")
    public String board(@PathVariable(name = "id", required = true) int boardId, ModelMap modelMap){
        modelMap.addAttribute("id", boardId);
        return "board";
    }

    @GetMapping("/update/{id}")
    public String updateBoard(@PathVariable(name = "id", required = true) int boardId, ModelMap modelMap){
        modelMap.addAttribute("id", boardId);
        return "updateBoard";
    }

    @GetMapping("/list")
    public String boardList(){
        return "boardList";
    }
    @GetMapping("/insert")
    public String insertBoard() {
        return "insertBoard";
    }


}
