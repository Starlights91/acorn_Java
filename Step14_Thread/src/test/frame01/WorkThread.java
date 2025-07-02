package test.frame01;
/*
 * 새로운 스레드 만드는 방법
 * 
 * 1. Thread 클래스를 상속 받은 클래스를 정의한다.
 * 2. run() 메소드를 오버라이드 한다.
 * 3. run() 메소드 안에서 새로운 스레드에서 해야 할 작업을 코딩한다.
 * 4. 만든 클래스로 객체를 생성하고 해당 객체의 start() 메소드를 호출하면 새로운 스레드가 시작된다.
 */
public class WorkThread extends Thread {
	@Override
	public void run() { // 호출 할 때: main 스레드에서 new workThread().start(); 해야한다.   // .run(); 이 아닌 start(); 로 호출해야 함.
		//여기는 메인스레드가 실행해준다. (버튼을 누르면)
		System.out.println("10 초 걸리는 작업을 시작합니다.");
		try {
			//결과적으로 메인스레드는 10초간 sleep 상태로 된다. (작업중이라고 가정)
			Thread.sleep(1000*10);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		System.out.println("작업이 종료 되었습니다.");
	
	}

}
