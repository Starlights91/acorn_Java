package test.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/*
 * 	Java DataBase Connectivity (JDBC)
 * 
 * 	- java 에서 DB 에 연결해서 INSERT, UPDATE, DELETE, SELECT 등의 작업을 할수가 있다.
 * 	- 우리는 ORACLE DataBase 에 연결해서 이런 작업을 할 예정이다.
 * 	- ORACLE 연결 driver 클래스가 있어야 연결이 가능하다.
 */
public class MainClass02 {
	public static void main(String[] args) {
		//DB 에 접속에서 작업을 하려면 Connection 객체가 필요하다
		Connection conn=null;
		//connection (커넥션 객체를 이용해서 어떤 작업들이 이뤄지는지 알기)
		try { 
			//오라클 드라이버 로딩( ojdbc...jar 파일이 있어야 아래의 코드가 동작한다)
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//접속할 DB 의 정보 @아이피주소:port번호:db이름
			String url="jdbc:oracle:thin:@localhost:1521:xe"; // 본인 desktop ip 주소. mac은 docker 켜놓기!
			//계정 비밀번호를 이용해서 Connection 객체의 참조값 얻어오기
			conn=DriverManager.getConnection(url, "scott", "tiger"); // Connection 객체. mac p/w: tiger로 변경.
			//예외가 발생하지 않고 여기까지 실행순서가 내려오면 접속 성공이다.
			System.out.println("Oracle DB 접속 성공");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// SELECT 작업을 위해서 필요한 객체를 담을 지역변수 미리 만들기
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			// 실행할 sql 문 미리 준비하기 (java10부터 추가된 문법)
			String sql = """
				SELECT empno, ename, job, sal
				FROM emp
				ORDER BY empno ASC
			""";  //""" """; 여러줄에 여러줄을 편하게 작성 가능

			// sql 문을 전달하면서 PreparedStatement 객체의 참조값 얻어내기
			pstmt=conn.prepareStatement(sql);
			// SELECT 문 실행하고 결과를 ResultSet 객체로 얻어내기
			rs=pstmt.executeQuery();
			// 반복문 돌면서
			while(rs.next()) {
				int empno=rs.getInt("empno"); //getInt 는 정수로 출력 getString 는 문자로 출력)
				String ename=rs.getString("ename");
				String job=rs.getString("job");
				double sal=rs.getDouble("sal");
				// 현재 cursor 가 위치한 곳의 데이터를 테스트로 출력해보기
				System.out.println(empno+" | "+ename+" | "+job+" | "+sal);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
