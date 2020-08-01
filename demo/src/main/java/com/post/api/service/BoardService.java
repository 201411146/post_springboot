package com.post.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.post.api.dto.BoardDto;
import com.post.api.mapper.BoardMapper;

@Service
public class BoardService {

	@Autowired
    BoardMapper boardMapper;
	
	public List<BoardDto> boardList() throws Exception {

 
        return boardMapper.boardList();
    }

    public int insertBoard(BoardDto boardDTO) throws Exception{
	    return boardMapper.insertBoard(boardDTO);
    }
}
