package com.post.api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.post.api.dto.BoardDto;

@Mapper
public interface BoardMapper {

	List<BoardDto> boardList();
	int insertBoard(BoardDto boardDTO);
}
