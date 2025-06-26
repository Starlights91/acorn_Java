package test.main;

import test.mypac.ZzangGu;

public class MainClass06 {
	public static void main(String[] args) {
		/*
		 *  ZzangGu 객체를 3개 생성해서 배열에 담은 다음 반복문 돌면서
		 *  배열에 담긴 ZzangGu 객체의 dance() 메소드를 모두 호출.
		 */
		ZzangGu[] zg=new ZzangGu[3];
		for (int i = 0; i < zg.length; i++) {
			zg[i]=new ZzangGu();
		}
		for (int i = 0; i < zg.length; i++) {
			zg[i].dance();
		}
		
		System.out.println("---");
		
//		for (ZzangGu zg[i] : zg) {
//			zg[i].dance();
//		}
		
	}
	
}
