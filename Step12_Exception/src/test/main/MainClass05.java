package test.main;
/*
 * run 버튼을 누르면 Java Virtual Machine 이 main() 메소드를 호출하면서 메인 스레드가 시작다.
 * 
 * 따라서 여기서 발생하는 예외를 우리가 처리하지 않으면, JVM(자바가상머신) 이 대신 처리 해준다.  // (나) 따라서, 우리가 try catch 사용하지 않아도...
 * 
 */
public class MainClass05 {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("main 메소드가 실행되었습니다");
		
		//Exception 을 try~catch 로 묶지 않으면 예외처리의 주체는 메소드를 호출한 곳에서 처리를 한다
	
			Thread.sleep(5000); // ='Thread=실행의 흐름' = 실행의 흐름을 5초(=5000ms)간 잡는 것. 
			//이 줄에서 문법적으로 오류나기 때문에 Thread 위에 add Throw ... 누르면, 상단에 throws InterruptedException 자동 입력 된다.
			
		System.out.println("main 메소드가 종료되었습니다");

		
	}

}
