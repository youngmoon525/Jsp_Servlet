package customer;

import java.util.List;

public class CustomerServiceImpl implements CustomerService{
	CustomerDAO dao = new CustomerDAO(); 


	@Override
	public List<CustomerVO> customer_list() {
		return dao.customer_list();
	}

	@Override
	public CustomerVO customer_detail(int id) {
		return dao.customer_detail(id);
	}

	@Override
	public void customer_update(CustomerVO vo) {
		dao.customer_update(vo);
		
	}

	@Override
	public void customer_delete(int id) {
		dao.customer_delete(id);
		
	}

	@Override
	public void customer_insert(CustomerVO vo) {
		dao.customer_insert(vo);
		
	}

	@Override
	public int customer_test() {
		
		return dao.customer_test();
	}


}
