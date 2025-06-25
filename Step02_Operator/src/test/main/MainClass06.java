package test.main;

public class MainClass06 {
	public static void main(String[] args) {
		// boolean type 변수나 상수는 대화식으로 지으면 가독성이 좋다
		// can... is... 형식으로 많이 만든다.
		boolean isPretty=true;
		boolean canEat=false;
		
		// 만일(if) 이쁘다면(Pretty)...
		if(isPretty) {
			// 이곳은 이쁘면 실행된다.
		}
		
		// 만일(if) 이쁘지 않다면(!Pretty)...
		if(!isPretty) {
			// 이쁘지 않으면 실행된다.
		}
		
		// 만일(if) 먹을 수 있다면(canEat)...
		if(canEat) {
			// 먹을 수 있으면 실행된다.
		}
		
		// 만일(if) 먹을 수 없다면(!canEat)...
		if(!canEat) {
			// 먹을 수 없다면 실행된다.
		}else{  // 그렇지 않다면(먹을 수 없다가 아니라면)
			// 먹을 수 있다면 실행된다.
		}
		
		// 만일 이쁘거나 또는 먹을 수 있다면.
		if(isPretty || canEat) {
			// 둘 중 하나라도 해당되면(이뻐도 or 먹을 수 있어도) 실행된다.
		}
		
		// 만일 이쁘고, 먹을 수 있다면.
		if(isPretty && canEat) {
			// 둘 다 해당되면(이쁘고 먹을 수 있는) 실행된다.
		}
		
		// 만일 이쁘고 "그리고" 먹을 수 없다면.
		if(isPretty && !canEat) {
			// 이쁘고, 먹을 수 없다면 실행된다.
		}
	}
}
