package test.main;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;

public class MainClass06 {
	public static void main(String[] args) {
		//콘솔창에 출력할수 있는 객체의 참조값 얻어내기
		PrintStream ps=System.out;
		//PrintStream 객체의 참조값을 부모 type 변수에 담기
		OutputStream os = ps;
		//2 byte 처리 스트림이기 때문에 한글 처리 가능
		var osw=new OutputStreamWriter(os);
		// 좀 더 많은 문자열을 한번에 출력가능하고 개행기호를 출력하는 기능도 가지고 있는 BufferedWriter
		var bw=new BufferedWriter(osw);
		try {
			bw.write("하나");
			bw.newLine(); //운영체제에 맞는 개행기호를 자동으로 출력해주는 메소드
			bw.write("두울");
			bw.newLine();
			bw.write("세엣");
			bw.flush();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
