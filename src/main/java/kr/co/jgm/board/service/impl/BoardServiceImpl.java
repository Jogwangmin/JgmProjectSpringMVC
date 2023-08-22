package kr.co.jgm.board.service.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.jgm.board.domain.Board;
import kr.co.jgm.board.service.BoardService;
import kr.co.jgm.board.store.BoardStore;

@Service
public class BoardServiceImpl implements BoardService{
	@Autowired
	private SqlSession session;
	@Autowired
	private BoardStore nStore;
	
	@Override
	public int insertBoard(Board board) {
		int result = nStore.insertBoard(session, board);
		return result;
	}
}
