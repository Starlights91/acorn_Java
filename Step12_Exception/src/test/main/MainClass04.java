package test.main;

public class MainClass04 {
	public static void main(String[] args) {
		System.out.println("main 메소드가 실행되었습니다");
		
		try {
			/*
			 * Thread.sleep() 메소드 내부에서는 RuntimeException 을 상속 받지않은
			 * InterruptedException 이 발생한다. RuntimeException 을 상속받지않은 예외는
			 * 예외 처리를 의무적으로 해야한다. 처리하는 방법:
			 * 1. throw
			 * 2. try~catch 로 묶어주기
			 */
			Thread.sleep(5000); // ='Thread=실행의 흐름' = 실행의 흐름을 5초(=5000ms)간 잡는 것. 이 줄에서 문법적으로 try catch 강제된다. 이 줄은 원래 에러나는데 surround with try catch 누르면 자동 완성으로 묶임.
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		System.out.println("main 메소드가 종료되었습니다");

		
	}

}
