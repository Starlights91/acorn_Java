package test.main;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class MainClass13 {
	public static void main(String[] args) {
		try {
			//(이미지)파일로 부터 byte 알갱이를 읽어들일 객체 생성
			var fis=new FileInputStream("/Users/minaoh/playground/SouthKorea.png");
			//byte 알갱이를 파일에 출력할 객체 생성 (/copied 는 새로운 파일명)
			var fos=new FileOutputStream("/Users/minaoh/playground/copied2.png");
			//byte 알갱이 1024 개를 한번에 읽어들일수 있는 배열 객체 생성 (1 kilo byte 씩)
			byte[] buffer=new byte[1024];
			
			
			//반복문 돌면서
			while(true) {
				//byte[] 객체를 전달해서 배열에 읽어들이도록 하고 몇 byte 를 읽어 들였는지를 리턴받는다.
				int readedCount=fis.read(buffer);
				//만일 더이상 읽을 byte 가 없다면, -1 출력하고, 반복문 탈출
				if(readedCount == -1)break;
				//배열안에 읽어들인 데이터를 읽은 갯수만큼 출력하기
				fos.write(buffer, 0, readedCount);
				fos.flush();
			}
			System.out.println("파일을 copy 했습니다");
			//마무리 작업
			fos.close();
			fis.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
