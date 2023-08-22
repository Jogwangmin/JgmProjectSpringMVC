package kr.co.jgm.board.service;

import kr.co.jgm.board.domain.Board;

public interface BoardService {

	/**
	 * 공지사항 등록 Service
	 * @param board
	 * @return int
	 */
	int insertBoard(Board board);

}
