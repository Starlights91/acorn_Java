package test.main;

import java.util.ArrayList;
import java.util.Scanner;

public class MainClass03Quiz {
	// Quiz
	// ArrayList<String> words = new ArrayList<>();
	// 위에서 생성한 Scanner 객체로 반복문 돌면서 문자열을 5번 입력받아서
	// 입력 받을때 마다 ArrayList<String> 객체에 add() 하고
	// 다 입력 받으면 다시 한번 반복문 돌면서 ArrayList<String> 객체에 저장된 문자열 5개를
	// 순서대로 콘솔창에 출력하는 프로그래밍을 해 보세요.

	//하단의 args, scan, msgs = 모두 지역변수 (메소드 안의)
	public static void main(String[] args) { 
		// 콘솔창으로 부터 입력 받을 수 있는 Scanner(System.in) 객체 생성
		Scanner scan = new Scanner(System.in);
		// 문자열을 순서대로 저장할수 있는 ArrayList 객체 생성
		ArrayList<String> msgs = new ArrayList<>(); // 객체 생성시에 Generic 은 생략 가능. => ArrayList<Integer> nums = new

		for (int i = 0; i < 5; i++) { // {} 이안에서 만들어진 지역변수는 벗어나면 사라짐.
			System.out.println("문자열 입력");
			// Scanner 객체를 이용해서 여기서 문자열 입력 받기 (하단 콘솔에 입력해서 입력 받기)
			String line = scan.nextLine(); // line = 임시(지역)변수 = 나타났다가 사라졌다가 반복 
			msgs.add(line); // ArrayList에 저장
		}
		// 위에서 정한 i & line 은 {} 괄호 끝나면서 더이상 사용 불가
		
		// 저장된 문자열 출력
		for(String tmp : msgs) { // tmp ={} 이 for 문 괄호 안에서만사용 가능한 지역변수 
			System.out.println(tmp);
		}
	

//		// 저장된 문자열 출력
//		for (int i = 0; i < 5; i++) {
//			String line = scan.nextLine();
//			msgs.add(line);
//		}

	}
}
