package test.main;
/*
 * 2. 증감 연산자 테스트
 * 	  변수에 있는 숫자 값을 1씩 증가 혹은 1씩 감소 시킬 때 사용한다.
 * 	  ++, --
 */
public class MainClass02 {
	public static void main(String[] args) {
		int num=0;
		num++;
		num++;
		num++; // num 은 최종적으로 3이 된다.
		
		int num2=0;
		num2--;
		num2--;
		num2--; // num2 는 최종적으로 -3이 된다.
		
		
		// ++ 연산자의 위치에 따라 값이 다르게 입력된다.
		int num3=0;
		int result1 = num3++; // result 에 0 이 대입되고 num3 가 1 증가한다.
				
		int num4=0;
		int result2 = ++num4; // num4 가 1 증가하고 result2 에 1 이 대입된다.
	}
}
