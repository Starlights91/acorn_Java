package test.main;

import test.mypac.Remocon;

public class MainClass04 {
	public static void main(String[] args) {
		//인터체이스도 익명의 InnerClass 를 이용해서 구현 객체를 만들수 있다.
		//Remocon r1=new Remocon "여기서 ctrl+space" () {
		Remocon r1=new Remocon() {
			
			@Override
			public void up() {
				System.out.println("채널을 올려요!");
				
			}
			
			@Override
			public void down() {
				System.out.println("채널을 내려요!");
				
			}
		};
		//지역변수 r1 에 있는 참조값을 전달하면서 메소드 호출
		useRemocon(r1);
		//메소드 호출하면서 즉석에서 객체를 만들어서 호출
		//useRemocon(new Remocon 여기서 ctrl+space);
		useRemocon(new Remocon() {
			
			@Override
			public void up() {
				System.out.println("머리를 올려요!");
				
			}
			
			@Override
			public void down() {
				System.out.println("머리를 내려요!");
				
			}
		});
		
		
	}
	
	public static void useRemocon(Remocon r) {
		r.up();
		r.down();
	}

}
