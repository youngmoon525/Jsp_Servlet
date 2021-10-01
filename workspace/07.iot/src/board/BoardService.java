package board;

import java.util.HashMap;
import java.util.List;

public interface BoardService {
	//CRUD
	List<BoardVO> board_list(); //게시판글 목록 조회 ( 전체 조회 )
	BoardPage board_list(BoardPage page); //페이지 단위로 게시판 글 목록 조회
	
	void board_view(int id); //글 상세보기 	
	void board_insert(BoardVO vo); //게시판 글 삽입 (insert)
	void board_update(BoardVO vo); //게시판 글 수정
	void board_delete(int id); //게시판 글 삭제
	void board_read(int id);//조회수 증가처리 
	List<BoardVO> board_list(HashMap<String, String> data); //게시판글 목록 조회 ( 검색어가 있을때의 처리 )

	void board_reply_insert(BoardVO vo); //답글 저장 
}
