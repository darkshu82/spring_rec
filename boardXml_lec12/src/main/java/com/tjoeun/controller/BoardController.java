package com.tjoeun.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tjoeun.dto.ContentDTO;
import com.tjoeun.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
  @Autowired
  private BoardService boardService;

	@GetMapping("/main")
	public String main(@RequestParam("board_info_idx") int board_info_idx,
			               Model model) {
		model.addAttribute("board_info_idx", board_info_idx);		
		return "board/main";      
	}
	
	@GetMapping("/read")
	public String read() {
		return "board/read";
	}

	@GetMapping("/write")
	public String write(@ModelAttribute("writeContentDTO") ContentDTO writeContentDTO, 
	                    @RequestParam("board_info_idx") int board_info_idx) {
			writeContentDTO.setContent_board_idx(board_info_idx);
		return "board/write";
	}
	
	@PostMapping("/write_procedure")
	public String writeProcedure(@Valid @ModelAttribute("writeContentDTO") ContentDTO writeContentDTO, BindingResult result) {
		
		if(result.hasErrors()) {
			return "board/write";	
		}
		boardService.addContent(writeContentDTO);
		return "board/read";
	}

	@GetMapping("/modify")
	public String modify() {
		return "board/modify";
	}

	@GetMapping("/delete")
	public String delete() {
		return "board/delete";
	}
	
}
