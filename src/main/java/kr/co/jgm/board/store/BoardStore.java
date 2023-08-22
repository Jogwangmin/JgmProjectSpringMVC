package kr.co.jgm.board.store;

import org.apache.ibatis.session.SqlSession;

import kr.co.jgm.board.domain.Board;

public interface BoardStore {

	/**
	 * 공지사항 등록 Store
	 * @param session
	 * @param board
	 * @return int
	 */
	int insertBoard(SqlSession session, Board board);

}
