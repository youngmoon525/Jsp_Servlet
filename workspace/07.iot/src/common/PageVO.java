package common;

public class PageVO {
	private int totalList; // 총글건수
	private int totalPage; // 총페이지수
	private int totalBlock; // 총블록수
	private int pageList = 10 ; //페이지당 보여질 목록의 수
	private int blockPage = 10 ; //블럭당 보여질 페이지의 수
	private int curPage; // 현재 페이지
	private int beginList , endList; // 각 페이지에 보여질 목록번호
	private int curBlock; // 현재 블럭
	private int beginPage , endPage; // 각 블럭에 보여질 페이지 번호
	/////===================///
	private String serach , keyword; //검색조건 , 검색어
	
	
	public int getTotalList() {
		return totalList;
	}
	public void setTotalList(int totalList) {
		this.totalList = totalList;//DB로부터 조회 된 총 글건수
		//총페이지수
		totalPage = totalList / pageList; // 총페이지수 = 총건수 / 페이지당 글건수
		if ( totalList % pageList > 0 ) ++ totalPage;
		
		totalBlock = totalPage / blockPage; // 총 블록수 = 총페이지수 / 블럭당 페이지수
		if (totalPage % blockPage > 0 ) ++ totalBlock;
		
		//현재페이지에 따라 보여질 글의 시작/끝목록번호가 결정이된다.
		//각 페이지의 끝 목록번호 : 총 목록수 - (페이지번호-1) * 페이지당 보여질 목록수
		endList = totalList - (curPage - 1) * pageList;
		//각 페이지의 시작 목록번호 : 끝 목록번호 - (페이지당 보여질 목록수-1)
		beginList = endList - ( pageList - 1);
			
		//각 블럭에 보여질 페이지 번호는 현재 블럭에 따라 결정이 된다.
		curBlock = curPage / blockPage;
		if ( curPage % blockPage > 0) ++ curBlock;
		
		//각 블럭의 끝 페이지번호 : 블럭번호 * 블럭당 보여질 페이지수
		endPage = curBlock * blockPage;
		//각 블럭의 시작 페이지 번호 : 끝페이지번호 - (블럭당 보여질 페이지수-1)
		beginPage = endPage - ( blockPage - 1 );
		
		//마지막 블럭에서 끝 페이지번호가 총 페이지수보다 클 수 없으므로
		//총 페이지수를 끝 페이지번호로 한다.
		if( endPage > totalPage ) endPage = totalPage;
		
		
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getTotalBlock() {
		return totalBlock;
	}
	public void setTotalBlock(int totalBlock) {
		this.totalBlock = totalBlock;
	}
	public int getPageList() {
		return pageList;
	}
	public void setPageList(int pageList) {
		this.pageList = pageList;
	}
	public int getBlockPage() {
		return blockPage;
	}
	public void setBlockPage(int blockPage) {
		this.blockPage = blockPage;
	}
	public int getCurPage() {
		return curPage;
	}
	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}
	public int getBeginList() {
		return beginList;
	}
	public void setBeginList(int beginList) {
		this.beginList = beginList;
	}
	public int getEndList() {
		return endList;
	}
	public void setEndList(int endList) {
		this.endList = endList;
	}
	public int getCurBlock() {
		return curBlock;
	}
	public void setCurBlock(int curBlock) {
		this.curBlock = curBlock;
	}
	public int getBeginPage() {
		return beginPage;
	}
	public void setBeginPage(int beginPage) {
		this.beginPage = beginPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public String getSerach() {
		return serach;
	}
	public void setSerach(String serach) {
		this.serach = serach;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
	
}
