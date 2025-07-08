package test.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import test.dto.ProductDto;
import test.util.DBConnectorForProduct;

/*
 * 	Data Access Object (DAO) 객체를 생성할 클래스 정의하기!
 * 
 * - DB 에 insert, update, delete, select 작업을 하는 코드를 작성한다. (CRUD)
 */
public class ProductDao {

	// 1. 상품 추가: (한개의 상품 정보를 DB 에 저장 & 성공여부를 리턴하는 메소드)
	public boolean insert(ProductDto dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		// 변화된 row 의 갯수를 담을 변수 선언하고 0 으로 초기화
		int rowCount = 0;
		try {
			conn = new DBConnectorForProduct().getConn();
			String sql = """
					INSERT INTO product
					(id, pname, stockno, price)
					VALUES(product_seq.NEXTVAL, ?, ?, ?)
					""";
			pstmt = conn.prepareStatement(sql);
			// ? 에 순서대로 필요한 값 바인딩
			pstmt.setString(1, dto.getPname());
			pstmt.setInt(2, dto.getStockno());
			pstmt.setInt(3, dto.getPrice());
			// sql 문 실행하고 변화된(추가된, 수정된, 삭제된) row 의 갯수 리턴받기
			rowCount = pstmt.executeUpdate(); // 성공이면 1인데, 실패하면 0 초기값이라
			// int flag = pstmt.executeUpdate();
			// return flag > 0;
		} catch (Exception e) { // 여기서 e = SqlException 발생
			e.printStackTrace();
		} finally { // 에러나던 안나던 실행된다.
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}

		// 변화된 rowCount 값을 조사해서 작업의 성공 여부를 알아 낼수 있다.
		if (rowCount > 0) {
			return true; // 작업 성공이라는 의미에서 true 리턴하기
		} else {
			return false; // 작업 실패라는 의미에서 false 리턴하기
		}
	}

	// 2. 상품 정보 수정 (& 성공여부를 리턴하는 메소드)
	public boolean update(ProductDto dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		// 변화된 row 의 갯수를 담을 변수 선언하고 0으로 초기화
		int rowCount = 0;
		try {
			conn = new DBConnectorForProduct().getConn();
			String sql = """
						UPDATE product
						SET pname=?, stockno=?, price=?
						WHERE id=?
					""";
			pstmt = conn.prepareStatement(sql);
			// ? 에 순서대로 필요한 값 바인딩
			pstmt.setString(1, dto.getPname());
			pstmt.setInt(2, dto.getStockno());
			pstmt.setInt(3, dto.getPrice());
			pstmt.setInt(4, dto.getId());
			// sql 문 실행하고 변화된(추가된, 수정된, 삭제된) row 의 갯수 리턴받기
			rowCount = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}

		// 변화된 rowCount 값을 조사해서 작업의 성공 여부를 알아 낼수 있다.
		if (rowCount > 0) {
			return true; // 작업 성공이라는 의미에서 true 리턴하기
		} else {
			return false; // 작업 실패라는 의미에서 false 리턴하기
		}
	}

	// 3. 상품 정보를 DB 에서 삭제 (& 성공여부를 리턴하는 메소드)
	public boolean deleteById(int id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		// 변화된 row 의 갯수를 담을 변수 선언하고 0으로 초기화
		int rowCount = 0;
		try {
			conn = new DBConnectorForProduct().getConn();
			String sql = """
						DELETE FROM product
						WHERE id=?
					""";
			pstmt = conn.prepareStatement(sql);
			// ? 에 순서대로 필요한 값 바인딩
			pstmt.setInt(1, id);
			// sql 문 실행하고 변화된(추가된, 수정된, 삭제된) row 의 갯수 리턴받기
			rowCount = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}

		// 변화된 rowCount 값을 조사해서 작업의 성공 여부를 알아 낼수 있다.
		if (rowCount > 0) {
			return true; // 작업 성공이라는 의미에서 true 리턴하기
		} else {
			return false; // 작업 실패라는 의미에서 false 리턴하기
		}
	}

	// 4. 상품 번호로 1개 단일 상품 정보를 조회하는 메소드
	public ProductDto getById(int id) {
		ProductDto dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = new DBConnectorForProduct().getConn();
			String sql = "SELECT id, pname, stockno, price FROM product WHERE id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				dto = new ProductDto();
				dto.setId(rs.getInt("id"));
				dto.setPname(rs.getString("pname"));
				dto.setStockno(rs.getInt("stockno"));
				dto.setPrice(rs.getInt("price"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}
		return dto; // 잊지 말기!
	}

	// 5. 모든 상품 조회 (전체 목록 SELECT 해서 List에 담아서 리턴하는)메소드
	public List<ProductDto> selectAll() {
		// 회원정보를 누적시킬 ArrayList 객체 미리 준비하기
		List<ProductDto> list = new ArrayList<>();
		// 필요한 객체를 담을 지역변수를 미리만든다
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = new DBConnectorForProduct().getConn();
			// 실행할 sql 문
			String sql = """
					SELECT id, pname, stockno, price
					FROM product
					ORDER BY id DESC
					""";
			pstmt = conn.prepareStatement(sql);
			// ?에 값 바인딩

			// select 문 실행하고 결과를 ResultSet으로 받아온다
			rs = pstmt.executeQuery();
			// 반복문 돌면서 ResultSet 에 담긴 데이터를 추출해서 어떤 객체에 담는다
			while (rs.next()) {
				// list.add(null)

				// 커서가 위치한 곳의 회원정보를 저장할 Member 객체 생성
				ProductDto dto = new ProductDto();
				dto.setId(rs.getInt("id")); // rs(ResultSet) 으로부터 얻어낸 회원번호를 MemberDto 객체의 setter 메소드를S 이용해서 dto에 저장.
				dto.setPname(rs.getString("pname"));
				dto.setStockno(rs.getInt("stockno"));
				dto.setPrice(rs.getInt("price"));

				// 상품 한개의 정보가 담긴 새로운 ProductDto 객체의 참조값을 List 에 누적시키기
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}
		return list;
	}

}
