package test.main;

public class MainClass09 {
	public static void main(String[] args) {
		/*
		 * 1~100 사이의 숫자 중에서 짝수의 총합을 구해서 출력
		 */
		
		int sum=0;
		for (int i = 1; i <= 100; i++) {
			if(i%2==0) { // 짝수를 판별
				sum+=i;  // i 가 짝수면 실행
			}
		}
		System.out.println("1~100 사이의 숫자 중에서 짝수의 총합1:"+sum);
		
		sum=0;
		for (int i =2; i <= 100; i+=2) {
			sum+=i;
		}
		System.out.println("1~100 사이의 숫자 중에서 짝수의 총합2:"+sum);
	}
}
