package com.post.api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.post.api.dto.BoardDto;

@Repository
public interface BoardMapper {
	List<BoardDto> boardList();
	List<BoardDto> boardSearch(String select, String search);
	BoardDto getBoardById(int boardId);
	int deleteBoard(int id);
	int updateBoard(BoardDto boardDto);
	int insertBoard(BoardDto boardDTO);
}
