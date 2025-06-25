package test.mypac;

// 어떤 상품의 정보를 담기 위해서 클래스 설계하기
public class Item {
	private String name;   	//상품명
	private int price;	  	//가격
	private String madeBy;	//제조사
	
	// 상품의 이름을 필드에 저장하는 setter 메소드
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}
