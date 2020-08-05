package com.post.api.controller;

import com.post.api.dto.BoardDto;
import com.post.api.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// TODO: mysql timezone 수정

@RestController
@RequestMapping("/api")
public class BoardController {

	@Autowired
    BoardService boardService;

    @GetMapping("/")
    public List<BoardDto> boardList(){

        List<BoardDto> boardList = boardService.boardList();
        return boardList;
    }

    @PostMapping("/board")
    public Map<String, Object> createBoard(@RequestBody BoardDto boardDto) {
        Map<String, Object> resultMap = new HashMap<>();
        int insertKey  = 0;

        try{
            boardService.insertBoard(boardDto);
            insertKey = boardDto.getId();   // 자동으로 생성된 key value
            resultMap.put("result", "success");
        }catch(Exception e){
            resultMap.put("result", "fail");
        }

        return resultMap;
    }


}
