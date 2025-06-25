package test.main;

import java.util.Random;

public class MainClass07 {
	public static void main(String[] args) {
		// Random 객체 생성
		Random ran=new Random();
		// 0~4 사이의 숫자중에 랜덤한 정수가 하나 얻어진다.
		int ranNum=ran.nextInt(5);
		// 0~9 사이의 숫자중에...
		int ranNum2=ran.nextInt(10);
		// 1~10 사이의 숫자중에...
		int ranNum3=ran.nextInt(10)+1;
		
		System.out.println(ranNum);
	}
}
