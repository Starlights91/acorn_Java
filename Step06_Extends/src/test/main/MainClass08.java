package test.main;

import test.company.Department;
import test.company.Employee;

public class MainClass08 {
	public static void main(String[] args) {
		/*
		 *  사원의 이름: 김구라
		 *  급여: 1000
		 *  부서명: 교육부
		 *  부서의 위치: 역삼동
		 *  
		 *  위의 정보를 가지는 Employee 객체를 하나 생성해서 그 참조값을
		 *  emp1 이라는  지역변수에 담아보자.
		 *  Department, Employee 클래스를 수정하라는 말이 아님.
		 *  단 2줄의 코딩
		 *  메소드 호출 아님
		 */
		Department dept=new Department("교육부", "역삼동");
		Employee emp1=new Employee("김구라", 1000, dept);
		emp1.printInfo();
		
		/*
		 *  위에서 생성한 부서와 동일한 부서에서 근무하는 사원(Employee) 객체를 하나 더
		 *  생성해보자.
		 *  사원이름: 원숭이
		 *  급여: 2000
		 */
		Employee emp2=new Employee("원숭이", 2000, dept);
		emp2.printInfo();
		
		/*
		 *  사원이름: 주뎅이
		 *  급여: 3000
		 *  부서 이름: SALES
		 *  부서 위치: LA
		 *  위의 정보를 가지는 Employee 객체를 생성하되 1줄 코딩으로 생성 해보자.
		 */
		Employee emp3=new Employee("주뎅이", 3000, new Department("SALES", "LA"));
	}
}
