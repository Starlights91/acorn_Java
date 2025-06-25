package test.main;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class MainClass08 {
	public static void main(String[] args) {
		// String type 이 저장되어 있는 배열 
		String[] data = {"🍒", "🍎", "🍌", "🍈", "7"};
		
		// 위에 배열에 저장된 5개의 문자열중에서 랜덤하게 1개만 출력
		Random ran1=new Random();
		Random ran2=new Random();
		Random ran3=new Random();
		int d1=ran1.nextInt(data.length);
		int d2=ran2.nextInt(data.length);
		int d3=ran3.nextInt(data.length);
		String r1=data[d1];
		String r2=data[d2];
		String r3=data[d3];
		System.out.println(r1+r2+r3);
		
		Set<String> set = new HashSet<>();
		set.add(r1);
		set.add(r2);
		set.add(r3);
		if (set.size() == 1) {
			System.out.println("잭팟!!");
		} else {
			System.out.println("꽝!");
		}
	}
}
