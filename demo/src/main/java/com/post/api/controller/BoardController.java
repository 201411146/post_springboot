package com.post.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.post.api.dto.BoardDTO;
import com.post.api.mapper.BoardMapper;

@RestController
public class BoardController {

	@Autowired
    BoardMapper a;

    @GetMapping("/")
    public List<BoardDTO> users() throws Exception {

        List<BoardDTO> boardList = a.boardList();
        return boardList;
    }
}
