package test.main;

public class MainClass11 {
	public static void main(String[] args) {
		
		int i=0;
		while(i<5) {
			System.out.println(i+"반복합니다");
			i++;
		}
		
		System.out.println("----------------");
		
		
		int j=0;
		// 무한 루프는 실행하다가 break 문을 만나면 탈출할수 있다.
		// (나) 외형상 무한루프 while(true) { }; 
		while(true) {
			System.out.println(j+"반복합니다");
			j++;
			// 반복문 " 탈출조건" 을 이용해서
			if(j == 5) {
				break; // 반복문을 탈출한다.
			}
		
		}
	}
}
