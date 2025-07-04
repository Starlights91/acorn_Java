package test.main;

import java.util.Scanner;

import test.dao.MemberDao;
import test.dto.MemberDto;

public class MainClass08 {
	public static void main(String[] args) {
		//Scanner 객체를 이용해서 회원의 이름과 주소를 입력 받은 다음
		Scanner scan=new Scanner(System.in);
		
		System.out.print("이름입력:");
		String name=scan.nextLine();
		
		System.out.print("주소입력:");
		String addr=scan.nextLine();
		
		// 자주 하게 될 일: 
		//MemberDao 객체를 이용해서 DB 에 저장하려면? (4줄코딩?)
		//3. MemberDto 객체를 생성해
		MemberDto dto = new MemberDto();
		//4. 입력한 이름과 주소를 담고 (아래 콘솔창에 입력하면 입력된 정보 저장)
		dto.setName(name);
		dto.setAddr(addr);
		
		//1. MemberDao dao = new MemberDao();
		//2. dao. -> ctrl+shift 3번째 insert
		MemberDao dao = new MemberDao();
		//메소드는 작업의 성공여부를 리턴해준다.
		boolean isSuccess=dao.insert(dto);
		if(isSuccess) {
			System.out.println(name+" 님의 정보를 성공적으로 DB에 저장"); //여기가 리턴 = true
		}else {
			System.out.println("저장 실패!"); // 여기가 리턴 = false
		}
	}

}
