package com.post.api.controller;

import com.post.api.dto.BoardDTO;
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
    public List<BoardDTO> boardList() throws Exception {

        List<BoardDTO> boardList = boardService.boardList();
        System.out.println(boardList.get(0));
        return boardList;
    }

    @PostMapping("/board")
    public Map<String, Object> createBoard(@ModelAttribute BoardDTO boardDTO) throws Exception{

        Map<String, Object> resultMap = new HashMap<>();
        boardService.insertBoard(boardDTO);
        return resultMap;
    }


}
