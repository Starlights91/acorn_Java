package test.mypac;

/*
 * 	인터페이스에서 메소드의 접근 지정자 public 생략하면 기본 public 이다
 */

@FunctionalInterface
public interface MyFunction {
	// 추상 메소드
	public void execute();

	// java 9 부터 추가된문법 default 메소드 (참조값으로 호출하는 메소드)
	public default void log() {
		System.out.println("실행 로그 출력");
	}

	// java 9 부터 추가된 문법 static 메소드 (인터페이스명에 . 찍어서 호출하는 메소드)
	public static void help() {
		System.out.println("도움말");
	}
}