package test.main;

public class MainClass01 {
	public static void main(String[] args) {
		System.out.println("main 메소드가 시작 되었습니다.");
		
		try {
			Thread.sleep(5000); // 스레드 = 실행의 흐름(작업단위)
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		test();
		
		System.out.println("main 메소드가 종료 됩니다.");
	
	}
	
	public static void test() {
		System.out.println("test() 메소드 호출 됨");
	}
}
