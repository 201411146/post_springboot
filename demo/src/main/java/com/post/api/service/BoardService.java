package com.post.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.post.api.dto.BoardDTO;
import com.post.api.mapper.BoardMapper;

@Service
public class BoardService {

	@Autowired
    BoardMapper boardMapper;
	
	public List<BoardDTO> boardList() throws Exception {

 
        return boardMapper.boardList();
    }

    public int insertBoard(BoardDTO boardDTO) throws Exception{
	    return boardMapper.insertBoard(boardDTO);
    }
}
