package test.dto;

// 상품정보 (product db 테이블의 한 행을 표현할 DTO=Data Transfer Object)
public class ProductDto {
	private int id;
	private String pname;
	private int stockno;
	private int price;
	
	// 기본 생성자
	public ProductDto() {} //입력하고, 1. Generate setter& getter 만들기 =>

	// 모든 필드 초기화하는 생성자
	public ProductDto(int id, String pname, int stockno, int price) {
		this.id=id;
		this.pname=pname;
		this.stockno=stockno;
		this.price=price;
	}
	
	// getter / setter
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public int getStockno() {
		return stockno;
	}

	public void setStockno(int stockno) {
		this.stockno = stockno;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	};
	

}
