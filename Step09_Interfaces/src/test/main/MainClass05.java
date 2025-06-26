package test.main;

import test.mypac.Drill;

public class MainClass05 {
	public static void main(String[] args) {
		// (순서2) 여기는 나중에 구현될 예정
		/*
		 * 	여기는 팀원이 코딩한다고 가정
		 * 	팀원이 직접 Drill Type 객체를 생성해서 // (순서3) 순서4의 Drill 인터페이스(미리 만들어진 복잡한 동작)가 필요하다면, 특정 인터페이스만, 여기 순서3에서 Drill Type 객체를 생성해서 순서 4 {} 안에 넣어 사용 가능.
		 * 	어디에 구멍을 뚫을지(오버라이드 된 메소드에서 정하는 것) 마음대로 결정할수 있다.
		 */
		
		// 1번째 방법
		Drill d1=new Drill() { // (여기) d1
			// Drill 인터페이스 type 객체는 오직 1개의 메소드만 가지고 있는 객체다 (객체가 1개 메소드 호출하면서 메소드 전달하기 위함)
			@Override
			public void hole() {
				System.out.println("d1 바닥에 구멍을 뚫어요!");
			}
		};
		useDrill(d1); // (여기) d1
		
		
		// 2번째 방법 (1번째 방법을 줄인 표현) Drill d2 = ()->{};    => d2 = ()->{};  오버라이드된 추상표현
		// ()->{} 는 @Override 된 메소드 이다.
		Drill d2 = ()->{
			System.out.println("d2 바닥에 구멍을 뚫어요!");
		};
		useDrill(d2); // (여기) d2
		
		
		// 3번째 방법 (1번째 방법을 줄인 표현) useDrill(()->{});
		useDrill(()->{
			System.out.println("d3 바닥에 구멍을 뚫어요!");
		});
	}
	// (순서1) 아래는 미리 만들어진 상태
	/*
	 * 	useDrill() 기능을 만드는 프로그래머(팀장, 라이브러리나 프레임워크 개발자) 입장에서 생각해보자
	 * 	Drill 인터페이스는 본인이 미리 만들어 놓은 상태
	 * 	메소드 안에서 Drill 객체를 이용해서 어떤 복잡한 동작을 미리 만들어 놓을수 있다.
	 * 
	 */
	public static void useDrill(Drill d) { // (여기) d  // (순서4) => 순서3을 넣어서 사용.
		d.hole(); //// (여기) d.hole();  메소드를 
		
	}
}
