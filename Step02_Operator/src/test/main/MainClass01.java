package test.main;
/*
 * 1. 산술연산자 테스트
 * 
 * +, -, *, /, %
 */
public class MainClass01 {
	public static void main(String[] args) {
		int num1=5;
		int num2=2;
		// + 연산
		int sum = 10 + 1;
		int sum2 = num1 + num2;
		int sum3 = 10 + num2;
		// 정수끼리 연산하면 결과는 정수만 나온다.
		int result1 = 5 / 3;
		int result2 = num1 / num2;
		// 연산의 결과로 실수 값을 얻어내고 싶으면 적어도 하나는 실수여야 한다.
		double result3 = 5 / 3.0;
		// double result3 = 5 / (double)3; 값은 같다.
		// 10을 3으로 나눈 나머지값을 변수에 담기
		int result = 10%3;
		
		// 
		byte a =10;
		// a는 byte type인데 a에 저장된 값을 int type b에 대입하는건 문제가 없을까?
		int b = a; // 잘 들어간다.
		// b는 int type인데 b에 저장된 값을 byte type인 c에 대입하는건 문제가 없을까?
		// byte c = b; // 문제가 있을 수도 있고 없을 수도 있다.
		
		/*
		 * b 자체는 int type 이지만 (byte) 연산자로 casting 하면
		 * 대입 연산자의 우측에는 byte type이 있다고 간주되어서 문법이 성립한다.
		 * 대신 b 안에 들어있는 값이 byte 범위 안에 들어 있다는 것이 확실할 때만
		 * casting 해야 오류가 없다.
		 */
		
		// 만약 byte 범위가 넘는 숫자 1000을 대입하면?
		byte c = (byte)b;
		int d = 1000;
		byte e = (byte)d; // 결과를 보면 전혀 다른 값이 대입된다.
		/* 
		 * -128 ~ 127 의 범위를 넘는 숫자는 계속 범위값을 순환한다.
		 * 예: 128을 대입하면 -128, 129를 대입하면 -127이 된다.
		 */
	}
}
