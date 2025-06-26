package test.main;

import test.mypac.Warmer;

public class MainClass06 {
	public static void main(String[] args) {
		// 방법 1
		Warmer w1 = new Warmer() {
			
			@Override
			public void warm(String target) {
				System.out.println(target+" 을(를) 따듯하게 해요");
			}
		};
		useWarmer(w1);
		// w1.warm("손을 따듯하게 해요");
		
		// 방법 2
		//매개변수의 type 생략 가능
		Warmer w2 = (String target)->{
			System.out.println(target+" 을(를) 뜨겁게 해요");
		};
		useWarmer(w2);
		
		// 방법 3
		Warmer w3 = (t)->{
			System.out.println(t+" 에 불을 붙여요");
		};
		useWarmer(w3);
	
	}
	public static void useWarmer(Warmer w) {
		w.warm("손");
	
	}

}
