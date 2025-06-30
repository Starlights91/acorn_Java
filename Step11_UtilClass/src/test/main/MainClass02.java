package test.main;

import java.util.ArrayList;

public class MainClass02 {
	public static void main(String[] args) {
		// 정수를 저장할수 있는 ArrayList<Integer> 객체를 생성해서 참조값을 지역변수 nums 에 담기 // 참조 데이터 값만id 값만
		// 저장
		ArrayList<Integer> nums = new ArrayList<>(); // 객체 생성시에 Generic 은 생략 가능. => ArrayList<Integer> nums = new
														// ArrayList<Integer>();

		// ArrayList 객체에 10, 20, 30 숫자 3개를 담아보세요
		nums.add(10);
		nums.add(20);
		nums.add(30);

		// ArrayList 객체에 저장된 숫자를 for 문을 이용해서 순서대로 콘솔창에 출력해 보세요.
		for (int i = 0; i < nums.size(); i++) {
			// i번째 item
			int tmp = nums.get(i);
			
			// 콘솔창에 출력
			System.out.println(tmp);
		}
		
		// 확장 for 문 . 위의 코드를 줄여서 쓰기
		// arraylist에 제네릭 클래스가 들어오는것이기 때문에 제네릭타입만 잘 확인하고 선언하면 된다.
		// for (int tmp:nums) {}
		System.out.println("확장 for 문을 이용하면 -------> ");
		for (int tmp : nums) {
			System.out.println(tmp);
		}
	}
}
