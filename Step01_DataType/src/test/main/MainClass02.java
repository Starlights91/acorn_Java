package test.main;

public class MainClass02 {
	public static void main(String[] args) {
		// 1. 콘솔창에 "main 메소드가 시작되었습니다."를 출력 syso
		System.out.println("main 메소드가 시작되었습니다.");
		// 2. 국어점수 95 를 kor 이라는 변수에 담아보자.
		int kor=95;
		// 3. 영어점수 100 을 eng 라는 변수에 담아보자.
		int eng=100;
		// 4. 만들어진 변수를 이용하여 국어 점수와 영어 점수의 평균을 구한다음(연산자) avg 라는 변수에 담아보자.
		int avg=(kor+eng)/2;
		System.out.println(avg);
		// 정수끼리 연산하면 결과는 정수만 나온다 (소수점 무시)
		// 정수와 실수를 연산하면 결과느누 실수가 나온다 (소수점 무시되지 않음)
		double avg2=(kor+eng)/2d;
		System.out.println(avg2);
		// 원하는 format 의 문자열 만들기
		String info="평균:"+avg2;
		String info2="국어:"+kor+" 영어:"+eng+" 평균:"+avg2;
		System.out.println(info);
		System.out.println(info2);
	}
}
