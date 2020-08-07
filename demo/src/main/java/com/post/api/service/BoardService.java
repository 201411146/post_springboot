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
	
	public List<BoardDto> boardSearch(String select, String search) throws Exception {

		 
        return boardMapper.boardSearch(select, search);
    }

    public BoardDto getBoardById(int boardId){
        return boardMapper.getBoardById(boardId);
    }

    public int insertBoard(BoardDto boardDTO){
	    return boardMapper.insertBoard(boardDTO);
    }

    public int deleteBoard(int id){
	    return boardMapper.deleteBoard(id);
    }

    public int updateBoard(BoardDto boardDto){
	    return boardMapper.updateBoard(boardDto);
    }
}
