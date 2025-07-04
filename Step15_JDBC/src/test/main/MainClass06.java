package test.main;

import java.sql.Connection;
import java.sql.PreparedStatement;

import test.util.DBConnector;

public class MainClass06 {
	public static void main(String[] args) {
		//DB 에 추가할 회원의 정보라고 가정하자 (member table)
		String name="누구게";
		String addr="어디게";
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			conn=new DBConnector().getConn();
			String sql="""
					INSERT INTO member
					(num, name, addr)
					VALUES(member_seq.NEXTVAL, ?, ?)
					""";
			pstmt=conn.prepareStatement(sql);
			// ? 에 순서대로 필요한 값 바인
			pstmt.setString(1, name);
			pstmt.setString(2, addr);
			// sql 문 실행하고 변화된(추가된, 수정된, 삭제된) row 의 갯수 리턴받기
			int rowCount=pstmt.executeUpdate();
			if(rowCount>0) { // 추가, 수정, 삭제된 row 갯수가 나오고, 변화된게 없거나 
				System.out.println("작업성공!"); //0보다 크면 성공
			}else {
				System.out.println("작업실패!"); //0과 같으면 실패
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
