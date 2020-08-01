package com.post.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.post.api.dto.BoardDTO;
import com.post.api.mapper.BoardMapper;
import com.post.api.service.BoardService;

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
