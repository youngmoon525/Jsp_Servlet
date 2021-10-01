package customer;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import board.BoardVO;

public class CustomerDAO implements CustomerService {
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
	public void customer_insert(CustomerVO vo) {
		sql = sqlmapper.openSession();
		int result = sql.insert("customer.mapper.new", vo);
		sql.commit();
		System.out.println(result);
		
	}

	@Override
	public List<CustomerVO> customer_list() {
		sql = sqlmapper.openSession();
		List<CustomerVO> list = sql.selectList("customer.mapper.list");
		return list;
	}

	@Override
	public CustomerVO customer_detail(int id) {
		sql = sqlmapper.openSession();
		CustomerVO vo = sql.selectOne("customer.mapper.detail" , id);
		return vo;
	}

	@Override
	public void customer_update(CustomerVO vo) {
		sql = sqlmapper.openSession();
		int result = sql.update("customer.mapper.update" , vo);
		sql.commit();
		System.out.println(result);
		
	}

	@Override
	public void customer_delete(int id) {
		sql = sqlmapper.openSession();
		int result = sql.delete("customer.mapper.delete" ,id);
		sql.commit();
		System.out.println(result);
		
	}

	@Override
	public int customer_test() {
		sql = sqlmapper.openSession();
		int result = sql.selectOne("customer.mapper.test");
		return result;
	}

	@Override
	public CustomerPage customer_list(CustomerPage page) {
		sql = sqlmapper.openSession();
		page.setTotalList( sql.selectOne("customer.mapper.totalList" , page) );
		List<CustomerVO> list = sql.selectList("customer.mapper.list" , page);
		page.setList(list );
		sql.close();
		return page;
	}

}
