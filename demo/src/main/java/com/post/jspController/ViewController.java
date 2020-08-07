package com.post.jspController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    public String boardList(@RequestParam(name = "start", defaultValue = "1") int start,
                            @RequestParam(name = "select", required = false) String select,
                            @RequestParam(name = "search", required = false) String search, ModelMap modelMap){

        modelMap.addAttribute("select", select);
        modelMap.addAttribute("search", search);
        modelMap.addAttribute("start", start);
        return "boardList";
    }
    @GetMapping("/insert")
    public String insertBoard() {
        return "insertBoard";
    }


}
