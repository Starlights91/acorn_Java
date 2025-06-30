package test.main;

import java.util.HashMap;
import java.util.Map;

public class MainClass08 {
	public static void main(String[] args) {

		// in JS: { key:value, ... } = in JAVA: % (hashvalue 와 같다)
		/*
		 * HashMap<key type, value type>
		 * 
		 * key type 은 일반적으로 " String type 을 가장 많이 사용한다 ". value type 은 담고 싶은 데이터의 type 을
		 * 고려해서 지정하면 된다. value type 을 Object 로 지정하면 어떤 data type 이던지 다 담을수가 있다. 순서가 없는
		 * 데이터를 다룰때 사용하면 된다. dto 클래스 대신에 사용하기도 한다.
		 */
		// HashpMap 은 put 사용으로 데이터를 담고 & get 사용해서 데이터를 가져온다.
		// HashpMap 클래스는 주로 Map 인터페이스를 사용(구현)한다.
		Map<String, Object> map = new HashMap<>();
		// (나) ( ) 어떤 타입이던지 다 담을 수 있다. 위에 Object type 으로 담겼기 때문에. == 이건 in JS: let map = { num: 1, name:"김구라", isMan: true}; 와 같다 
		// 데이터를 참조할때는 .put(key,value) 메소드를 이용해서 담고
		map.put("num", 1);
		map.put("name", "김구라");
		map.put("inMan", true);
		
		// 데이터를 참조할때는 .get(key) 메소드를 이용한다.
		// value 의 Generic 이 Object 이기때문에 원래 type 으로 casting 이 필요하다
		int num = (int)map.get("num");
		String name = (String)map.get("name");
		boolean isMan = (boolean)map.get("isMan");
		
		//동일한 key 값으로 다시 담으면 수정
		map.put(name, "이정호");
		//특정 Key 값으로 담긴 내용 삭제
		map.remove("isMan");
		//모두 삭제
		map.clear();
		
		// Map 인터페이스의 of() 라는 static 메소드로 read only Map 객체ㅗ 만들어 낼수 있다.
		// Map<String, Object> map2 = Map.of("num",2,"name","해골","isMan",false);	
		// 위에는 가독성이 안좋으니까 아래처럼 표시 함
		Map<String, Object> map2 = Map.of(
				"num",2,
				"name","해골",
				"isMan",false
		);

	}

}
