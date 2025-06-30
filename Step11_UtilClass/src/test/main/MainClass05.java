package test.main;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import test.mypac.MemberDto;

public class MainClass05 {
	public static void main(String[] args) {
		// MemberDto 객체를 저장할수 있는 ArrayList 객체 생성
		List<MemberDto> list = new ArrayList<>(); // List 인터페이스로 받는게 더 많은 상속으로 받을 수 있다. 
		// 1번 회원의 정보
		MemberDto dto = new MemberDto();
		dto.setNum(1);
		dto.setName("김구라");
		dto.setAddr("노량진");
		
		// 2번 회원의 정보
		MemberDto dto2=new MemberDto(2, "해골", "행신동");
		// 3번 회원의 정보
		MemberDto dto3=new MemberDto(3, "원숭이", "동물원");
		
		// 생성한 회원의 정보를 ArrayList 객체에 누적시키기
		list.add(dto);
		list.add(dto2);
		list.add(dto3);
		
		// 확장 for 문
		for(MemberDto tmp:list) {
			//출력할 문자열을 String 클래스의 .format() 이라는 static 메소드를 이용해서 구성하
			String info = String.format("번호:%d, 이름:%s, 주소:%s", tmp.getNum(), tmp.getName(), tmp.getAddr());
			//출력하기
			System.out.println(info);
		}
		System.out.println(" forEach() 를 이용하면 --------> ");
		
		list.forEach(item -> { // 함수에 전달되는 item은 MemberDto type
			String info = 
					String.format("번호:%d, 이름:%s, 주소:%s", item.getNum(), item.getName(), item.getAddr());
					System.out.println(info);
		});
		
		//또는 이렇게도 사용 가능!
//		list.forEach(new Consumer<MemberDto>() { //여기 new Consumer 에 Consumer 클릭해서 add unimplement 
//			@Override
//			public void accept(MemberDto t) {
//				String info = String.format("번호:%d, 이름:%s, 주소:%s", t.getNum(), t.getName(), t.getAddr());
//				//출력하기
//				System.out.println(info);
//			}
//			
//		});
		
		
		//list.forEach(tmp -> System.out.println(String.format("번호:%d, 이름:%s, 주소:%s", tmp.getNum(), tmp.getName(), tmp.getAddr())));	
		
	
	}
}
