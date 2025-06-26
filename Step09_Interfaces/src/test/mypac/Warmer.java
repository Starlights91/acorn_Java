package test.mypac;

//함수 형태로 쓰기위한 어노테이션 (메소드 1개가 강제된다) => 문법적으로 강제하는 것(1개만 가능) ()->{} 
@FunctionalInterface
public interface Warmer {
	public void warm(String target); // 무언가를 뎁히는 가상의 메소드

}
