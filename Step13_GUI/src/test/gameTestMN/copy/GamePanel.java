package test.gameTestMN.copy;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

//JPanel 부모로부터 상속받아서 메소드 만든 것
public class GamePanel extends JPanel {
	// 필요한 필드 정의 (타입이 같으면 한줄에 선언 가능)
	Image unitImage, backImage, missImage, monImage1;
	// 드래곤의 좌표의 초기값 필드로 정의
	int unitX = 0;
	int unitY = 0;
	
	// 배경1의 y 좌표 & 배경2의 y 좌표를 초기값 필드로 정의 (배경 움직이게 아래서 해주기 위함) back2Y가 위 & back1Y 아래
	int back1Y = 0, back2Y = -800;
	
	// Missile 리스트 : Missile 객체를 누적시킬 ArrayList 객체
	List<Missile> missList = new ArrayList<>();
	
	// Monster 리스트 : Missile 과 비슷하게 몬스터 담을 monList Monster 리스트 추가
	private List<Monster> monList = new ArrayList<>();

	// 미사일(여러개라서 객체로 각각의 위치를 가지고 있고, 스페이스 누를때마다 new 해서 객체가늘어나고 List 제네릭 미사일이고, 반복해서
	// 사용되기 때문에 반복문 사용)=드래곤의 현재 좌표에
	// 미사일이 위로 가려면 미사일의 y 좌표는 위로 올라가야 앞으로 나가기 때문에 숫자는 줄어야 함.

	// 생성자
	public GamePanel() {
		// 무언가 준비 작업 ...

		// Panel 의 크기 설정 width:500, height:800
		setPreferredSize(new Dimension(500, 800));
		
		// src/images/unit1.png 파일의 위치를 URL 객체로 얻어내기
		URL url = getClass().getResource("/images/unit1.png");
		
		// 이미지 => 이미지 객체로 얻어내야 사용 가능
		// src/images/unit1.png 파일을 로딩해서 Image 객체로 만들기 (이미지 로딩)
		unitImage = new ImageIcon(url).getImage(); 
		// 배경 이미지
		backImage = new ImageIcon(getClass().getResource("/images/backbg2.png")).getImage();
		// 미사일 이미지
		missImage = new ImageIcon(getClass().getResource("/images/mi2.png")).getImage();
		// 몬스터 이미지
		monImage1 = new ImageIcon(getClass().getResource("/images/juck2.png")).getImage();

		// 마우스 움직임 처리
		MouseMotionAdapter adapter = new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				// 마우스의 좌표
				int x = e.getX();
				int y = e.getY();
				// 마우스의 좌표를 unit 의 좌표에 반영하기 & 하단의 // 3. 플레이어(드래곤) 그리기 에 반영이 되어 움직이는 것.
				unitX = x;
				unitY = y;

				// 테스트로 출력해보기
//				System.out.println(x+" | " +y);
			}
		};

		// 마우스 움직임을 처리하기 위한 code
		addMouseMotionListener(adapter);
		
		//패널 포커스
		// Panel 이 포커스를 받을수 있도록 (key event 처리를 위해)
		setFocusable(true);
		// 바로 포커스 주기(포커스 = 현재 사용하는 프레임)
		requestFocusInWindow();

		// 생성자 안에서 몬스터 3마리 생성하여 넣기
		monList.add(new Monster(100, 100, 2)); // 오른쪽으로 2
		monList.add(new Monster(200, 200, -3)); // 왼쪽으로 3
		monList.add(new Monster(300, 300, 1)); // 오른쪽으로 1

		// 키보드 입력 처리
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
//				System.out.println(e.getKeyCode()); // 누른 키보드의 값= 숫자
				// 만일 space 바를 누르면
				if (e.getKeyCode() == 32) {
					// Missile 객체를 생성해서 현재 unit 의 좌표를 담은다음 List 에 누적시키기
					// & array 객체를 담을 ArrayList 필요하니까 위에 필드 추가하기!
					Missile m = new Missile(unitX, unitY);
					missList.add(m);
				}
			}

		});
		
		// Timer : 0.01초(10ms) 마다 실행
		// Panel 이 10/1000 초 마다 다시 그려지게 하기위한 타이머 설정 // 이 함수는 10/1000 초 마다 호출한다. 1초에 100번
		// 호출
		Timer timer = new Timer(10, (e) -> {
			// 몬스터들 이동: 모든 몬스터 x 좌표를 좌우로 이동하도록 한다. (확장 for 문)
			for (Monster m : monList) {
				m.setX(m.getX() + m.getDx());
				if (m.getX() <= 0 || m.getX() >= 500) {
					m.setDx(-m.getDx()); // 벽에 닿으면 방향 반전
				}

				// 몬스터랑 미사일 충돌 되어 죽는지 확인하는 검사
				for (Missile miss : missList) {
					for (Monster mon : monList) {
						if (miss.getX() > mon.getX() - 30 && miss.getX() < mon.getX() + 30) {
							if (miss.getY() > mon.getY() - 30 && miss.getY() < mon.getY() +30) {
								miss.setRemove(true); // true 이면 Missile 없애고 & 
								mon.setRemove(true); // true 이면 Monster 도 없애고.
							}
						}
					}
				} // 미사일 & 몬스터 모두 제거 

			}

			// + 미사일 이동, 충돌검사, 제거도 이 repaint() 안에서!
			// Panel 객체의 repaint() 메소드를 호출(결과적으로 paintComponent() 메소드가 다시 호출된다.)
			repaint();

			// System.out.println("호출됨");
		});
		timer.start();

	} // 생성자 는 여기까지로 클로징 된다.

	
	
	// Panel 에 무언가를 그릴때 호출되는 메소드
	// Panel 이 초기화 될때 한번 호출되고 그다음에는 repaint() 라는 메소드가 호출될때 마다 다시 호출된다.
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		// 1. 배경 그리기 : 배경이미지 그리기
		g.drawImage(backImage, 0, back1Y, 500, 800, this);
		g.drawImage(backImage, 0, back2Y, 500, 800, this);

		// 2. 반복문 돌면서 미사일 이미지 모두 그리기 (일반 for 문)
		for (int i = 0; i < missList.size(); i++) {
			// 미사일 그리기 : i번째 미사일 객체
			Missile tmp = missList.get(i); // tmp.getX() & tmp.getY() 좌표안에 들어있다.
			g.drawImage(missImage, tmp.getX() - 15, tmp.getY() - 20, 30, 40, this); // x값 30의 반이라 -15, y값 40의 반이라 -20

		}
		// 3. 플레이어(드래곤) 그리기 : 
		// 메소드의 매개변수에 전달되는 Graphics 객체를 Panel 에 그림을 그릴수 있는 도구이다.
		g.drawImage(unitImage, unitX - 50, unitY - 50, 100, 100, this); // x,y,w,h 마우스가 움직이면 unitX, unitY 좌표를 따라간다.
		// 초당 100번 호출되는 메소드 //unitX, unitY 필드의 값이 변경(=마우스움직여서 위치한 좌표) 되면 드래곤의 이미지에 바로
		// 반영된다.
		
		// 몬스터 그리기 : 
		for (Monster m : monList) {
			g.drawImage(monImage1, m.getX() - 25, m.getY() - 25, 50, 50, this);
		}

//		// 테스트로 몬스터 몇개 추가
//		monList.add(new Monster(100, 100));
//		monList.add(new Monster(200, 200));
//		monList.add(new Monster(300, 300));

		// 미사일 갯 수 표시 : 테스트로 미사일의 갯수 표시
		g.setColor(Color.YELLOW);
		g.setFont(new Font("Arial", Font.BOLD, 20));
		g.drawString("Missile:" + missList.size(), 10, 20);
		
		// 미사일 이동
		// 모든 미사일의 y 좌표를 감소 시켜서 미사일이 위로 이동하도록 한다. (확장 for 문)
		for (Missile tmp : missList) {
			// 현재 y 좌표에서 10 감소 시킨 값을 얻어내서
			int resultY = tmp.getY() - 10;
			// 해당 객체에 다시 넣어준다.
			tmp.setY(resultY);
			// 만일 위쪽으로 화면을 벗어난 미사일 객체라면
			if (tmp.getY() <= -20) {
				// 제거 하도록 표시해 둔다.
				tmp.setRemove(true); // 초기의 값은 false 로 되어 있음.
			}
		}

		// 반복문 돌면서 List 에서 제거할 Missile 객체는 제거한다.
		for (int i = 0; i < missList.size(); i++) {
			// i 번째 Missile 객체
			Missile tmp = missList.get(i);
			// 만일 i 번째 미사일 객체가 제거할 객체라면
			if (tmp.isRemove()) {
				// List 에서 i 번째 item 을 제거한다.
				missList.remove(i);
			}
		}
		
		// 미사일 제거
		for (int i = 0; i < missList.size(); i++) {
			if (missList.get(i).isRemove()) {
				missList.remove(i);
			}
		}

		// & 몬스터 제거
		for (int i = 0; i < monList.size(); i++) {
			if (monList.get(i).isRemove()) {
				monList.remove(i);
			}
		}

		back1Y += 2; // 숫자가 크면 클수록 배경이미지가 더 빨리 움직인다.
		back2Y += 2;

		// 배경 이미지 1개로 2개의 이미지로 만들어서 반복문으로 무한스크롤 되도록 만든 것!
		// 만일 배경1이 아래쪽으로 벗어난다면
		if (back1Y >= 800) {
			// -800 의 좌표로 다시 보낸다.
			back1Y = -800;
		}
		// 만일 배경2가 아래쪽으로 벗어난다면
		if (back2Y >= 800) {
			// -800 의 좌표로 다시 보낸다.
			back2Y = -800;
		}



	}
}
