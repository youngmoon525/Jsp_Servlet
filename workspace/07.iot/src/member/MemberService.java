package member;

import java.util.HashMap;

public interface MemberService {
	boolean member_join(MemberVO vo);//회원가입시 회원정보를 저장한다.(insert)
	MemberVO member_login(HashMap<String, String> map);//회원 로그인 처리(select)
	boolean member_update(MemberVO vo); //회원정보의 변경 (update)
	boolean member_delete(String id); //회원 탈퇴 (delete)
	boolean member_id_check(String id);//회원 가입 시 중복 된 아이디의 회원가입을 막는다(select)
						   //select count(*) from jsp_member where id = id?

}
