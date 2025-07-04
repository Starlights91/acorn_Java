package test.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import test.dto.MemberDto;
import test.util.DBConnector;

public class MainClass07 {
	
	//member 테이블에 회원 한명의 정보를 추가하는 메소드를 만든다고 생각해 보자. 매개변수에 선언 (String name, String addr)해줌으로써 아래에 바인딩
	public static boolean insert(MemberDto dto) { //boolean 으로 변경 
		Connection conn=null;
		PreparedStatement pstmt=null;
		// 변화된 row 의 갯수를 담을 변수 선언하고 0으로 초기화
		int rowCount=0;
		try {
			conn=new DBConnector().getConn();
			String sql="""
					INSERT INTO member
					(num, name, addr)
					VALUES(member_seq.NEXTVAL, ?, ?)
					""";
			pstmt=conn.prepareStatement(sql);
			// ? 에 순서대로 필요한 값 바인딩
			pstmt.setString(1, dto.getName()); //이름 얻기
			pstmt.setString(2, dto.getAddr()); //주소를 얻기
			// sql 문 실행하고 변화된(추가된, 수정된, 삭제된) row 의 갯수 리턴받기
			rowCount=pstmt.executeUpdate();
			if(rowCount>0) { // 추가, 수정, 삭제된 row 갯수가 나오고, 변화된게 없거나 
				System.out.println("작업성공!"); //0보다 크면 성공
			}else {
				System.out.println("작업실패!"); //0과 같으면 실패
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close(); //null 인지 아닌지 확인이 필요!
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		//변화된 rowCount 값을 조사해서 작업의 성공 여부를 알아 낼수 있다.
		if(rowCount>0) {
			return true; //작업 성공이라는 의미에서 true 리턴하기
			
		}else {
			return false; //작업 실패라는 의미에서 false 리턴하기
		}
	}
	
	public static void main(String[] args) {
		//DB 에 추가할 회원의 정보라고 가정하자 (member table)
		String name="누구게";
		String addr="어디게";
		//회원의 이름과 주소를 MemberDto 객체에 담는다
		MemberDto dto=new MemberDto();
		dto.setName(name);
		dto.setAddr(addr);
		// 메소드 호출하면서 전달하고 작업의 성공여부를 리턴 받는다.
		boolean isSuccess=insert(dto);
		if(isSuccess) {
			System.out.println("성공이네...성공이니까 다음 작업은 이걸 해야지...");
		}else {
			System.out.println("실패니까 다른 동작을 다시 해 봐야지...");
		}
	}

}
