package com.sbs.exam.demo.service;

import org.springframework.stereotype.Service;

import com.sbs.exam.demo.repository.BoardRepository;
import com.sbs.exam.demo.vo.Board;

@Service
public class BoardService {
	BoardRepository boardRepository;
	
	BoardService(BoardRepository boardRepository){
		this.boardRepository = boardRepository;
	}

	public Board getBoardById(int id) {
		Board board = boardRepository.getBoard(id);
		return board;
	}
}
