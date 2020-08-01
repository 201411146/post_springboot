package com.post.api.controller;

import com.post.api.dto.BoardDTO;
import com.post.api.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api")
public class BoardController {

	@Autowired
	BoardService boardService;

	@GetMapping("/boards")
	public List<BoardDTO> boardList(HttpServletRequest req) throws Exception {
		String select = req.getParameter("select");
		String search = req.getParameter("search");
		List<BoardDTO> boardList;
		if (select == null) {
			boardList = boardService.boardList();
		} else {
			boardList = boardService.boardSearch(select, search);
		}

		return boardList;
	}
	


	@PostMapping("/board")
	public Map<String, Object> createBoard(@ModelAttribute BoardDTO boardDTO) throws Exception {

		Map<String, Object> resultMap = new HashMap<>();
		boardService.insertBoard(boardDTO);
		return resultMap;
	}

}
