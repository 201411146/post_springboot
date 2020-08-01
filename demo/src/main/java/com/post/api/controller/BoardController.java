package com.post.api.controller;

import com.post.api.dto.BoardDto;
import com.post.api.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class BoardController {

	@Autowired
    BoardService boardService;

    @GetMapping("/")
    public List<BoardDto> boardList() throws Exception {

        List<BoardDto> boardList = boardService.boardList();
        return boardList;
    }

    @PostMapping("/board")
    public Map<String, Object> createBoard(@ModelAttribute BoardDto boardDto) throws Exception{

        Map<String, Object> resultMap = new HashMap<>();
        System.out.println(boardDto);
       // boardService.insertBoard(boardDto);
        return resultMap;
    }


}
