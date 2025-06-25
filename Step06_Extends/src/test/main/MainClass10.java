package test.main;

import test.company.Department;
import test.company.Employee;

public class MainClass10 {
	public static void main(String[] args) {
		
		Department d1 = new Department("영업부", "대전");
		/*
		 *  위의 부서에서 근무하는 사원(Employee) 객체 3개를 만들어서 그 참조값 3개를
		 *  배열에 순서대로 담아보자.
		 */
		
		Employee emp1 = new Employee("김구라", 1000, d1);
		Employee emp2 = new Employee("원숭이", 2000, d1);
		Employee emp3 = new Employee("아무게", 3000, d1);
		
		// 첫번째 방법
		Employee[] array1 = {emp1, emp2, emp3};
		
		// 두번째 방법 (더 자주 쓰는)
		Employee[] array2 = new Employee[3];
		array2[0]=emp1;
		array2[1]=emp2;
		array2[2]=emp3;
		
		// for 문 이용해서 Employee[] 에 담긴 Employee 객체의 .printInfo() 메소드 호출
		for (int i = 0; i < array2.length; i++) {
			// i 번째 방에 있는 Employee 객체의 참조값 얻어내기
			Employee tmp = array2[i];
			// 메소드 호출
			tmp.printInfo();
			// array[i].printInfo();  //1줄로
			
			
			
			}
		System.out.println("---");
		
		for(Employee tmp : array2) {
			tmp.printInfo();
		}
	}
}
