package kr.co.jgm.board.store.logic;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.jgm.board.domain.Board;
import kr.co.jgm.board.store.BoardStore;

@Repository
public class BoardStoreLogic implements BoardStore{

	@Override
	public int insertBoard(SqlSession session, Board board) {
		int result = session.insert("BoardMapper.insertBoard", board);
		return result;
	}

}
