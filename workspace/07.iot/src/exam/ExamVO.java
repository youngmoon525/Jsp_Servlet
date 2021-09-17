package exam;

import java.io.Serializable;

public class ExamVO implements Serializable {
	//ctrl + shift + y == 소문자로 바꾸기 (영역)
	private int no         ;
	private String content    ;
	private String answer     ;
	private int exam_cnt   ;
	//실제 DB에서 가져온 내용들.
	
	
	//사용자의 요청(답안제출)시 필요한 데이터를 담기 위한 필드.
	public String user_result; //사용자가 제출한 답안.
	public int result ; //정답이냐 아니냐
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public int getExam_cnt() {
		return exam_cnt;
	}
	public void setExam_cnt(int exam_cnt) {
		this.exam_cnt = exam_cnt;
	}
	
	
}
