package test.main;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.function.Consumer;

/*
 * 	HashSet 은 Set 인터페이스를 구현한 클래스 이다.
 * 
 * 	- 순서가 없다.
 * 	- key 값도 없다.
 * 	- 중복을 허용하지 않는다.
 * 	- 어떤 data 를 묶음(집합) 으로 관리하고자 할때 사용한다.
 */
public class MainClass09 {
	public static void main(String[] args) {
		//정수를 저장할수 있는 HashSet 객체를 생성해서 참조값을 Set 인터페이스 type 지역변수에 담기
		//동일한 참조값은 여러번 집어 넣어도 값이 같으면, 중복값을 허용하지 않고, 한가지씩 집어 넣음.
		Set<Integer> set1 = new HashSet<>(); //bk 찍고 디버깅
		set1.add(10);
		set1.add(10);
		set1.add(20);
		set1.add(20);
		set1.add(30);
		set1.add(40);
		set1.add(10);
		
		//문자열을 저장할수 있는 HashSet 객체
		Set<String> set2 = new HashSet<>(); // ** Set generic type String
		set2.add("kim");
		set2.add("lee");
		set2.add("park");
		set2.add("lee");
		set2.add("kang");
		
		//Set 객체에 저장된 모든 아이템을 순서를 보장할수는 없지만 모두 참조해서 사용해보기
		set1.forEach((item)->{
			//set1 은 Set<Integer> 이기 때문에 위의 item 은 <> generic 타입에 따라 Integer type 이 된다.
			Integer tmp=item;
			System.out.println(tmp);
		});
		
		System.out.println("---------------");
		
		//함수모양Í
		set2.forEach((item)->{
			//set2 는 Set<String> 이기 때문에 item 은 String type 이된다.
			String tmp=item;
			System.out.println(tmp);
		});
		
//		//위의 함수모양은 Consumer 가 갖고 있는 accept 메소드를 실행. <String> 이면 -> (String) 이렇게 <> generic 타입을 따라간다.
//		set2.forEach(new Consumer<String>() { //new Consumer 부터: 메소드 1개짜리 객체를 전달. 결국 forEach() 내부에서 Consumer type 의 객체의 메소드가 호출되는데, 그 메소드는 accept() 메소드가 확실한 상황
//			@Override
//			public void accept(String t) {
//			// TODO Auto-generated method stub
//			
//			}
//		});
		
		//Iterator 를 사용하는 구조도 연습해 보자 ( ** Set 의 generic 이 Iterator 의 generic 이 된다. )
		Iterator<String> it = set2.iterator();
		// (나) 무한 루프: while(true) { }
		// (나) 반복문과 비슷
		/*
		 * 무한 루프를 구성하거나 정확한 반복횟수를 알수 없을때 while(){} 문을 많이 사용한다.
		 */
		//hasNext() 메소드는 boolean type: true/false => next(); String 타입으로
		while(it.hasNext()) { // 다음 item 이 있는지 확인해서
			// 다음 item 을 얻어낸다 (** item 의 type 은 Iterator 의 Generic type 이다.)
			String item=it.next();
			// 얻어낸 item 을 사용하고 또 다음 item 이 있는지 위에서 확인이 된다.
			System.out.println(item);
		}
		
	}
}
