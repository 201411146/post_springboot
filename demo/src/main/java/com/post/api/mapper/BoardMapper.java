package com.post.api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.post.api.dto.BoardDto;

@Repository
public interface BoardMapper {

	public List<BoardDto> boardList();
	public List<BoardDto> boardSearch(String select, String search);
	public int insertBoard(BoardDto boardDTO);
}
