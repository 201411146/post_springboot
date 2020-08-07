package com.post.api.controller;

import com.post.api.dto.BoardDto;
import com.post.api.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// TODO: mysql timezone 수정
// TODO : throws
// TODO : 메서드, 변수 네이밍
// TODO : serivice
// TODO : category

@RestController
@RequestMapping("/api")
public class BoardController {

	@Autowired
	BoardService boardService; // 생성자 주입을 @Autowired를 사용하는 필드 주입보다 권장하는 이유
								// (https://madplay.github.io/post/why-constructor-injection-is-better-than-field-injection
								// 참조)

	@GetMapping("/boards")
	public List<BoardDto> getBoardList(@RequestParam(name = "start", defaultValue = "0") int start,
			@RequestParam(name = "select", required = false) String select,
			@RequestParam(name = "search", required = false) String search) throws Exception {

		List<BoardDto> boardList;
		if (select == null) {
			boardList = boardService.boardList(start);
		} else {
			boardList = boardService.boardSearch(start, select, search);
		}

		return boardList;
	}

	@GetMapping("/board/{id}")
	public BoardDto getBoardById(@PathVariable(name = "id", required = true) int boardId) {
		return boardService.getBoardById(boardId);
	}

	@PostMapping("/board")
	public Map<String, Object> insertBoard(@RequestBody BoardDto boardDto) { // https://codepen.io/rlfalsgh95/pen/abNbpxv
																				// (ajax를 이용한 테스트 코드)
		Map<String, Object> resultMap = new HashMap<>();
		int insertKey = 0;

		try {
			boardService.insertBoard(boardDto);
			insertKey = boardDto.getId(); // 자동으로 생성된 key value
			resultMap.put("result", "success");
		} catch (Exception e) {
			e.printStackTrace();
			resultMap.put("result", "fail");
		}

		return resultMap;
	}

	@DeleteMapping("/board/{id}") // https://codepen.io/rlfalsgh95/pen/dyMyWjL (ajax를 이용한 테스트 코드)
	public Map<String, Object> deleteBoard(@PathVariable(name = "id", required = true) int boardId) {
		Map<String, Object> resultMap = new HashMap<>();

		int deleteCount = boardService.deleteBoard(boardId);
		String deleteResult = (deleteCount != 0) ? "success" : "fail";

		resultMap.put("result", deleteResult);
		return resultMap;
	}

	@PutMapping("/board")
	public Map<String, Object> updateBoard(@RequestBody BoardDto boardDto) {
		Map<String, Object> resultMap = new HashMap<>();

		try {
			int updateCount = boardService.updateBoard(boardDto);

			String updateResult = (updateCount != 0) ? "success" : "fail"; // 요청에 id가 포함되지 않은 경우(null인 경우) 예외가 발생하지 않지만,
																			// updateCount가 0
			resultMap.put("result", updateResult);
		} catch (Exception e) {
			e.printStackTrace();
			resultMap.put("result", "fail");
		}

		return resultMap;
	}

}
