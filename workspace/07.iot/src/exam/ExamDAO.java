package exam;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class ExamDAO {
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
	public List<ExamVO> getList(){
		// Mybatis가 기본적으로 우리가 select를 list를 한다면.
		//조회 건수가 1건 이상이라면 반환 타입이 List
		sql = sqlmapper.openSession();//연결객체를 통해 초기화
		List<ExamVO> list = sql.selectList("member.mapper.exam");
		return list;
	}
}
