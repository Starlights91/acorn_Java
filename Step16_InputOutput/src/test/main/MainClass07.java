package test.main;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class MainClass07 {
	public static void main(String[] args) {
		//새로운 파일을 만들어서 문자열을 기록하는 예제를 만들고자 한다.
		//파일에 저장할 문자열
		String msg="""
				안녕하세요
				hi
				bye...
				""";
		
		File f=new File("memo.txt");
		try {
			//만일 해당 파일이 존재하지 않으면 (exists() 존재여부 boolean type 으로 확인)
			if(!f.exists()) {
				//새로운 파일 만들기
				f.createNewFile(); 
				System.out.println("memo.txt 파일을 만들었습니다.");
			}
			//파일에 문자열을 출력하는 기능을 가지고 있는 객체 생성
			var fw=new FileWriter(f, true); // (f, true) = 기존의 내용에 계속 추가로 내용을 쌓는것. (f, false) = 마지막의 내용만 출력 
			//String a=null;
			//fw.app
			fw.append(msg); // append() 메소드를 이용해서 문자열 출력하기
			fw.flush();
			fw.close();
			System.out.println("memo.txt 파일에 문자열을 기록 했습니다");
			
		}catch(IOException ie) {
			ie.printStackTrace();
		}
	}
}
