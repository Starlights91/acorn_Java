package test.main;

import java.util.Scanner;

public class MainClass05 {
	public static void main(String[] args) {
		/*
		 * 1. 콘솔창으로 부터 입력받을 수 있는 Scanner 객체를 생성해서 그 참조값을 scan 이라는 지역 변수에 담아보자.
		 * 2. scan에 담겨있는 Sanner 객체를 두번 사용해서 콘솔창으로 부터 숫자를 2개 입력받기.
		 * 3. 입력받은 숫자(문자열)를 실제 숫자로 변경.
		 * 4. 두 수의 합을 구해서 콘솔창에 이쁘게 출력.
		 */
		Scanner input=new Scanner(System.in);
		
		System.out.print("첫번째 숫자입력: ");
		String str1=input.nextLine();
		System.out.print("두번째 숫자입력: ");
		String str2=input.nextLine();
		
		
		// .parseXXX();는 문자열을 받기 때문에 .parseXXX(a+b);의 형태는 단순히 "ab"로 출력된다.]
		Double num1=Double.parseDouble(str1);
		Double num2=Double.parseDouble(str2);
		
		
		double sum=num1+num2;
		
		System.out.println(str1+"과 "+str2+"의 합은: "+sum);
		
		// format 을 이용해 문자열 구성 (실수는 %f로 치환한다, 정수는 %d, 문자열은 %s)
		String result=String.format("%f 과 %f 의 합은: %f", num1, num2, sum);
		System.out.println(result);
		
		// 소수점 자릿수 지정해서 출력
		String result2=String.format("%.2f 과 %.2f 의 합은: %.2f", num1, num2, sum);
		System.out.println(result2);
	}
}
