package test.main;

import test.mypac.Operator;

public class MainClass07 {
	public static void main(String[] args) {
		
		// 람다 표현식 ()->{}; 
		// Operator plus = ()->{};
		//더하기 연산을해서 결과값을 리턴해주는 Operator type 객체
		Operator plus = (double num1, double num2)->{
			return num1+num2;
		};
		
		// 람다 표현식 ()->{};  (매개변수의 type 생략 가능)
		Operator minus = (double num1, double num2)->{
			return num1-num2;
		};
		
		// [ 자주 사용 ] Operator multiply = (a, b) -> a*b; 
		//메소드의 {} 생략하고 return 예약어 없이 리턴할 값만 -> 우측에 작성해도 된다.
		Operator multiply = (a, b) -> a*b; // 단지 return 할 값만 얻어내면 된다.
		
		double result1=plus.execute(10, 10); //20
		double result2=minus.execute(10, 10); //0
		double result3=multiply.execute(10, 10); //100
//		Operator multiply = (a, b) -> {
//							// 실행할 코드가 없다.
//			return a*b; // 단지 return 할 값만 얻어내면 된다.
//		};
		
	}

}
