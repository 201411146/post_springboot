package com.post.api.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.post.api.dto.BoardDTO;


public interface BoardMapper {

	public List<BoardDTO> boardList();
}
