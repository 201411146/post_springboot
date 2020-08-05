package com.post.api.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.post.api.dto.BoardDto;
import com.post.api.service.BoardService;

@RestController
@RequestMapping("/api")
public class BoardController {

	@Autowired
	BoardService boardService;

	@GetMapping("/boards")
	public List<BoardDto> boardList(HttpServletRequest req) throws Exception {
		String select = req.getParameter("select");
		String search = req.getParameter("search");
		List<BoardDto> boardList;
		if (select == null) {
			boardList = boardService.boardList();
		} else {
			boardList = boardService.boardSearch(select, search);
		}

		return boardList;
	}
	


	@PostMapping("/board")
	public Map<String, Object> createBoard(@ModelAttribute BoardDto boardDTO) throws Exception {

		Map<String, Object> resultMap = new HashMap<>();
		boardService.insertBoard(boardDTO);
		return resultMap;
	}

}
