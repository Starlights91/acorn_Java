package test.main;

//ArrayList = 가변 배열 = 엄청 자주 사용하게될 객체임!!!!
import java.util.ArrayList;

public class MainClass01 {
	public static void main(String[] args) {
		//java 에서 배열은 용도가 한정되어 있다. item 을 담을수 있는 공간을 늘이거나 중일수 없다.
		
		//문자열(String) type 을 담을수 있는 방 5개 짜리 배열 객체 생성
		String [] names = new String[5]; // 자바 배열에선 : 데이터의 갯수가 정해져있어서 5개 방만 만들어짐 (디버깅 모드로 확인)
		names[0] = "김구라";
		names[1] = "해골";
		names[2] = "원숭이";
		
		// 아이템을 갯수 상관없이 필요에 따라 마음대로 추가하거나 제거할수 있는 배열목록(Arraylist) 객체 생성하기 // 원래: ArrayList<String> friends =new ArrayList<String>(); // <E> = 배열타입 데이터(참조데이터로) 전달 
		// ArrayList<String>  = ArrayList 에 <String> 이라는 String 타입으로 제네릭으로 전달.
		ArrayList<String> friends = new ArrayList<>(); // <E> = 배열타입 데이터(참조데이터로) 전달  //디버깅 여기에 breakpoint 놓고 해보기!
		// friends. //ctrl+space
		
		
		//제일 자주 사용 하는건: .add (순서대로 담고) & .get (#번방, " " ); #	번방 불러와서 담기 => 자바의 arraylist = 자바스크립트의 [] 와 유사
		
		//김구라, 해골, 원숭이 를 순서대로 담아보세요. (3줄코딩)  //friends.add (ctrl+space) // add라는 메소드는 차곡차곡 담아지는 것.
		friends.add("김구라");
		friends.add("해골");
		friends.add("원숭이");
		
		//2번방의 item 을 "신현호" 로 값 수정 // friends.set (ctrl+space) [2]원숭이 => [2]신현호 로 변경된다.
		friends.set(2, "신현호");
		
		
		//0 번방의 아이템을 불러와서 item 이라는 변수에 담기 // friends.get (ctrl+space) => friends.get(0); => item=friends.get(0);
		String item=friends.get(0);
		System.out.println(item);
		
		//1 번방의 아이템을 삭제 // friends.remove (ctrl+space) // 필요하다면, String removedName = friends.remove(0);  이렇게 쓰면 됨.
		friends.remove(0); // .remove(int index): String => 결과적으론 삭제한 item을 return  & .remove(Object):boolean =>  boolean = 결과적으론 (삭제)어떤 작업의 성공 여부를 return. 
		// **** 특정 #번 방의 아이템을 삭제하면, 뒤에 있는 아이템이 앞으로 땡겨져 온다. 따라서, [2]원숭이는 => [1] 원숭이가 됨. 나머지 뒤의 번호들도 
		
		//저장된 아이템의 갯수(size) 를 "size 라는 지역 변수"에 담기 // friends.size (ctrl+space)
		int size=friends.size();
		
		//0 번방에 "에이콘" 을 끼워넣기 // friends.add(0,""); (ctrl+space)
		friends.add(0, "에이콘");
		// **** 특정 #번 방의 아이템을 끼워 넣으면, 아이템이 뒤로 한칸씩 밀려난다. 따라서, [0]에는 에이콘이 추가되고, [0]김구라는 => [1] 김구라가 됨. 나머지 뒤의 번호들도 

		
		//저장된 모든 아이템 전체 삭제 //friends.clear();  (ctrl+space)
		friends.clear();


	}

}
