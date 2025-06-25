package test.main;

import java.io.InputStream;
import java.util.Scanner;

public class MainClass04 {
	public static void main(String[] args) {
		System.out.println("main 메소드가 시작 되었습니다.");
		
		// 콘솔창으로 부터 입력 받을 수 있는 Scanner 객체 생성
		InputStream is=System.in;
		Scanner scan1=new Scanner(is);
		
		Scanner scan2=new Scanner(System.in);
		// .print() 는 개행기호를 출력하지 않는다.
		System.out.print("문자열 입력: ");
		// 콘솔에 입력한 문자열을 String type으로 얻어낸다.
		String str=scan2.nextLine();
		
		
		System.out.println("입력한 내용: "+str);
		System.out.println("main 메소드가 종료됩니다.");
	}
}
