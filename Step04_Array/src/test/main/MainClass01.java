package test.main;

public class MainClass01 {
	public static void main(String[] args) {
		/*
		 * in Javascrit
		 * let num=[10, 20, 30, 40, 50];
		 * nums[0]
		 * nums[1]
		 * 
		 * in Java (Java에서는 배열이 많이 쓰이진 않는다)
		 * int[] nums={10, 20, 30, 40, 50}; // Java에서 배열은 {}로 만든다
		 * nums[0]							// Java에서 배열이 한번 만들어지면 
		 * nums[1]							// size(배열의 요소)를 늘리거나 줄일 수 없다.
		 */
		int[] nums= {10, 20, 30, 40, 50};
		/*
		 * "김구라" "해골" "원숭이" "주뎅이" "덩어리" 5개의 문자열이 저장된 배열을 만들고
		 * 그 찹조값은 names 라는 변수에 대입해 보자.
		 */
		String[] names= {"김구라", "해골", "원숭이", "주뎅이", "덩어리"};
		
		// nums 배열에 저장된 숫자를 반복문 돌면서 콘솔창에 하나씩 순서대로 출력하기 (for문)
		for (int i = 0; i < nums.length; i++) {
			System.out.println(nums[i]);
		}
		
		// ...문자열을...
		for (int i = 0; i < names.length; i++) {
			System.out.println(names[i]);
		}
	}
}
