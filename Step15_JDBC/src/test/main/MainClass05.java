package test.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import test.util.DBConnector;

public class MainClass05 {
	public static void main(String[] args) {
		int minSal=2000;
		int maxSal=3000;
		//위의 범위의 sal 을 받는 사원들의 empno, ename, sal 를 SELECT 해서
		//sal 에대해서 오름차순 정렬해서 콘솔창에 출력하기
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			conn=new DBConnector().getConn(); //DBConnector 클래스 만들어 논 것 불러오기
			//실행할 sql 문의 뼈대 구성하기  //2000 & 3000이 아닌 어떤 값이 들어 올지 모를 땐 ? 넣기 (이건 미완성이라) 
			String sql="""
					SELECT empno, ename, sal
					FROM emp
					WHERE SAL BETWEEN ? AND ?
					ORDER BY sal ASC
					""";
			//미완성의 sql 문을 전달하면서 PreparedStatement 객체 얻어내기
			pstmt=conn.prepareStatement(sql);
			// ? 에 필요한 값 바인딩하기 (
			pstmt.setInt(1, minSal); //1번째 ? 에 minSal 바인딩
			pstmt.setInt(2, maxSal); //2번째 ? 에 maxSal 바인딩
			//SELECT 문 실행하고 결과를 ResultSet 객체로 받아오기
			rs=pstmt.executeQuery();
			while(rs.next()) {
				int empno=rs.getInt("empno");
				String ename=rs.getString("ename");
				int sal=rs.getInt("sal");
				System.out.println(empno+" | "+ename+" | "+sal);
			}

		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
