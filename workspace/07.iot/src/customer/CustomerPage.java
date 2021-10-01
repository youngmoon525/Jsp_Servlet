package customer;

import java.util.List;

import common.PageVO;

public class CustomerPage extends PageVO{
	private List<CustomerVO> list; //field

	public List<CustomerVO> getList() {
		return list;
	}

	public void setList(List<CustomerVO> list) {
		this.list = list;
	}
	
	
}
