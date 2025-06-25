package test.main;

public class MainClass08 {
	public static void main(String[] args) {
		/*
		 * for 문을 이용해서
		 * 1 + 2 + 3 + 4 ... + 99 + 100
		 * 의 총 합을 콘솔창에 출력하라
		 */
		int sum=0;
		for (int i = 0; i < 100; i++) {
			sum += i+1;
		}
		System.out.println("1~100 까지 총합1:"+sum);
		
		sum=0;
		for (int i = 1; i <= 100; i++) {
			sum += i;
			// sum = sum+i 의 반복
		}
		System.out.println("1~100 까지 총합2:"+sum);
	}
}
