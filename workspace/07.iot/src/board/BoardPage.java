package board;

import java.util.List;

import common.PageVO;

//List<BoardVO> <> pageVO
//List Page == Field 전부다 사용할수있는 처리
//extends를 통해서 부모클래스에서 구현해놓은 page관련 기능들을 전부다 상속 받아옴.
public class BoardPage extends PageVO {
	private List<BoardVO> list; //field
	

	public List<BoardVO> getList() {
		return list;
	}

	public void setList(List<BoardVO> list) {
		this.list = list;
	}
	
	

	
}
