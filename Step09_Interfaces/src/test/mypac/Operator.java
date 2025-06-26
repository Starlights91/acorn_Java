package test.mypac;

//함수 형태로 쓰기위한 어노테이션 (메소드 1개가 강제된다) => 문법적으로 강제하는 것(1개만 가능) ()->{} 
@FunctionalInterface
public interface Operator {
	//매개변수에 전달되는 두 수를 연산해서 어떤 결과 값을 리턴해주는 추상 메소드 (구현은 자유)
	public double execute(double num1, double num2);

}
