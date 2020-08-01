package com.post.api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.post.api.dto.BoardDTO;

@Repository
public interface BoardMapper {

	public List<BoardDTO> boardList();
	public int insertBoard(BoardDTO boardDTO);
}
