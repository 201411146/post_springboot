package com.post.api.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.post.api.dto.BoardDto;

@Repository
public interface BoardMapper {

	List<BoardDto> boardList();
	int insertBoard(BoardDto boardDTO);
}
