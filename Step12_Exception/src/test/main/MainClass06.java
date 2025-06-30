package test.main;

import test.mypac.MyUtil;

public class MainClass06 {
	public static void main(String[] args) {
		MyUtil.draw(); // 그리는데 5초 소요
		
		try {
			MyUtil.send(); // => 예외가 발생될 때 ,런타임을 상속받지 않거나 객체 생성중에 생기는 에러 unhandled exception type -> throw 하거나  전송되는데 5초 소요
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
