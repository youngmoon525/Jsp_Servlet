package board;

import java.util.HashMap;
import java.util.List;

public class BoardServiceImpl implements BoardService {
	BoardDAO dao = new BoardDAO();
	@Override
	public List<BoardVO> board_list() {
		// dao.
		return dao.board_list();
	}

	@Override
	public BoardPage board_list(BoardPage page) {
		return dao.board_list(page);
	}

	@Override
	public void board_view(int id) {
		dao.board_view(id);
	}

	@Override
	public void board_insert(BoardVO vo) {
		dao.board_insert(vo);
		
	}

	@Override
	public void board_update(BoardVO vo) {
		dao.board_update(vo);
		
	}

	@Override
	public void board_delete(int id) {
		dao.board_delete(id);
		
	}

	@Override
	public void board_read(int id) {
		dao.board_read(id);
		
	}

	@Override
	public List<BoardVO> board_list(HashMap<String, String> data) {
		return dao.board_list(data);
	}

	@Override
	public void board_reply_insert(BoardVO vo) {
		dao.board_reply_insert(vo);
		
	}

}
