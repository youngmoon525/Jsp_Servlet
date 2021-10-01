package customer;

import java.util.List;

public interface CustomerService {
	//CRUD ( Create , Read , Update , Delete) 
	void customer_insert(CustomerVO vo);//CREATE ( Insert 신규고객 정보를 추가) 
	List<CustomerVO> customer_list(); // Read (Select 고객 목록 조회 )
	
	CustomerPage customer_list(CustomerPage page);
	
	CustomerVO customer_detail(int id);//Read (Select 고객 목록중에 선택 된 정보를 상세보기)
	void customer_update(CustomerVO vo); //Update 고객 정보 수정 저장( Update )
	void customer_delete(int id); //Delete 고객 정보 삭제 (Delete)
	
	//임시 테스트용 메소드 추가
	int customer_test();
}
