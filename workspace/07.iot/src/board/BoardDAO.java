package board;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class BoardDAO implements BoardService {

//실제 작업 영역
	private static SqlSessionFactory sqlmapper;//연결 객체 |conn
	private static SqlSession sql; //전송과 결과를 담당하는 객체 |ps , rs
	static {
		String resource = "data/SqlMapConfig.xml";//Mybatis 설정이 있는 파일
		try {
			InputStream inputStream = Resources.getResourceAsStream(resource);
			sqlmapper = new SqlSessionFactoryBuilder().build(inputStream);
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("마이바티스 SqlSessionFactory 여기 에러");
		}
	}
	@Override
	public List<BoardVO> board_list() {
		sql = sqlmapper.openSession();
		List<BoardVO> list = sql.selectList("board.mapper.list");
		return list;
	}

	@Override
	public BoardPage board_list(BoardPage page) {
		//총 글 건수를 가지고와서 세팅함.
		sql = sqlmapper.openSession();
		page.setTotalList( sql.selectOne("board.mapper.totalList") );
		List<BoardVO> list = sql.selectList("board.mapper.list" , page);
		page.setList(list );
		return page;
	}

	@Override
	public void board_view(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void board_insert(BoardVO vo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void board_update(BoardVO vo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void board_delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void board_read(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<BoardVO> board_list(HashMap<String, String> data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void board_reply_insert(BoardVO vo) {
		// TODO Auto-generated method stub
		
	}

}
