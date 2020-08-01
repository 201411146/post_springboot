package com.post.api.controller;

import com.post.api.dto.BoardDTO;
import com.post.api.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BoardController {

	@Autowired
    BoardService boardService;

    @GetMapping("/")
    public List<BoardDTO> boardList() throws Exception {

        List<BoardDTO> boardList = boardService.boardList();
        return boardList;
    }


}
