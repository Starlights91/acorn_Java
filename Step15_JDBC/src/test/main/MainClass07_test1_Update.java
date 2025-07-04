package test.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import test.dto.MemberDto;
import test.util.DBConnector;

public class MainClass07_test1_Update {
	
	//member 테이블에 회원 한명의 정보만 수정하는 메소드를 만든다 가정.
	public static boolean update(MemberDto dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		//변화된 row 의 갯수 담을 변수 선언 및 0으로 초기화
		int rowCount=0;
		try {
			conn = new DBConnector().getConn();
			String sql = """
					UPDATE member 
					SET name = '윌슨',
						addr = '강남구'
					WHERE num = 3;
					""";
			pstmt = conn.prepareStatement(sql);
			// ? 에 순서대로 필요한 값 바인
			pstmt.setString(1, dto.getName()); 
			pstmt.setString(2, dto.getAddr());
			// sql 문 실행하고 변화된(추가된, 수정된, 삭제된) row 의 갯수 리턴받기
			rowCount = pstmt.executeUpdate();
			if (rowCount > 0) { // 추가, 수정, 삭제된 row 갯수가 나오고, 변화된게 없거나
				System.out.println("작업성공!"); // 0보다 크면 성공
			} else {
				System.out.println("작업실패!"); // 0과 같으면 실패
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();				
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		// 변화된 rowCount 값 조사해서 작업성공여부 확인.
		if(rowCount>0) {
			return true;
		}else {
			return false;
		}
		
	}
	
	public static void main(String[] args) {
		//DB 에 수정할 회원의 정보 (member table)
		String name="한여름";
		String addr="강남구";
		// 회원 이름&주소를 MemberDto 객체에담기 => new memberDto(); 객체에 dto라는 변수명의 memberDto 타입으로 넣기
		MemberDto dto=new MemberDto();
		dto.setName(name);
		dto.setAddr(addr);
		// 메소드 호출하면서 전달하고, 작업의 성공여부를 리턴받는다.
		boolean isSuccess=update(dto);
		if(isSuccess) {
			System.out.println("성공적으로 수정했어! 다음 작업 진행해!");
		}else {
			System.out.println("실패니까 다시 수정해서 동작해봐~");
		}
	}
	

}
