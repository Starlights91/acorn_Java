package test.game;

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

public class GamePanel extends JPanel{
	//필요한 필드 정의
	Image backImage, missImage;
	//드레곤의 좌표
	int unitX=0;
	int unitY=0;
	//배경1의 y 좌표, 배경2의 y 좌표
	int back1Y=0, back2Y=-800;
	//Missile 객체를 누적시킬 ArrayList 객체
	List<Missile> missList=new ArrayList<>();
	//드레곤 Image 객체를 저장할 방2개짜리 배열 객체 미리 준비
	Image[] unitImgs=new Image[2];
	//드레곤이미지 인덱스
	int unitIndex;
	//메소드 호출횟수를 누적할 필드
	int count;
	
	//생성자
	public GamePanel() {
		//무언가 준비 작업 ...
		
		// Panel 의 크기 설정  width:500, height:800
		setPreferredSize(new Dimension(500, 800));
		
		//드레곤 이미지 2개를 로딩해서 Image[] 배열에 미리 넣어두기 
		unitImgs[0] = new ImageIcon(getClass().getResource("/images/unit1.png")).getImage();
		unitImgs[1] = new ImageIcon(getClass().getResource("/images/unit2.png")).getImage();

		//배경 이미지
		backImage=new ImageIcon(getClass().getResource("/images/backbg.png")).getImage();
		//미사일 이미지
		missImage=new ImageIcon(getClass().getResource("/images/mi2.png")).getImage();
		
		MouseMotionAdapter adapter=new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				//마우스의 좌표
				int x=e.getX();
				int y=e.getY();
				//마우스의 좌표를 unit 의 좌표에 반영하기
				unitX=x;
				unitY=y;
			}
		};
		//Panel 위에서 마우스 움직임을 처리 하기 위한 code
		addMouseMotionListener(adapter);
		
		//Panel 이 포커스를 받을수 있도록(key event 처리를 위해)
		setFocusable(true);
		//바로 포커스 주기 
		requestFocusInWindow();
		
		//키보드 입력 처리
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				//만일 space 바를 눌르면
				if(e.getKeyCode() == 32) {
					//Missile 객체를 생성해서 현재 unit 의 좌표를 담은다음 List 에 누적시키기 
					Missile m=new Missile(unitX, unitY);
					missList.add(m);
				}
			}
		});
		
		// Panel 이 10/1000 초 마다 다시 그려지게 하기위한 타이머 설정
		Timer timer=new Timer(10, (e)->{
			//Panel 객체의 repaint() 메소드를 호출(결과적으로 painComponent() 메소드가 다시 호출된다)
			repaint();
		});
		
		timer.start();
	}
	
	// Panel 에 무언가를 그릴때 호출되는 메소드 
	// Panel 이 초기화 될때 한번 호출되고 그다음에는 repaint() 라는 메소드가 호출될때 마다 다시 호출된다.
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		count++;
		
		//배경이미지 그리기
		g.drawImage(backImage, 0, back1Y, 500, 800, this);
		g.drawImage(backImage, 0, back2Y, 500, 800, this);
		//반복문 돌면서 미사일 이미지 모두 그리기
		for(int i=0; i<missList.size(); i++) {
			//i번째 미사일 객체
			Missile tmp=missList.get(i);
			g.drawImage(missImage, tmp.getX()-15, tmp.getY()-20, 30, 40, this);
		}
		
		//메소드의 매개변수에 전달되는 Graphics 객체를 Panel 에 그림을 그릴수 있는 도구이다.
		g.drawImage(unitImgs[unitIndex], unitX-50, unitY-50, 100, 100, this);
		
		//테스트로 미사일의 갯수 표시
		g.setColor(Color.YELLOW);
		g.setFont(new Font("Arial", Font.BOLD, 20));
		g.drawString("count:"+count, 10, 20);
		
		// count가 10의 배수인 경우. 10을 나눈 나머지값=0 . 
		if(count%10 == 0) { 
			//드레곤 unitIndex 1 증가
			unitIndex++;
			//만일 존재하지 않는 인덱스라면 
			if(unitIndex == 2) {
				//인덱스를 다시 0으로 변경한다.
				unitIndex=0;
			}
		}
		
		
		//모든 미사일의 y 좌표를 감소 시켜서 미사일이 위로 이동하도록 한다.
		for(Missile tmp : missList) {
			//현재 y 좌표에서 10 감소 시킨 값을 얻어내서 
			int resultY = tmp.getY()-10;
			//해당 객체에 다시 넣어준다.
			tmp.setY(resultY);
			//만일 위쪽으로 화면을 벗어난 미사일 객체라면
			if(tmp.getY() <= -20) {
				//제거 하도록 표시해 둔다.
				tmp.setRemove(true);
			}
		}
		
		//반복문 돌면서 List 에서 제거할 Missile 객체는 제거한다.
		for(int i=0; i<missList.size(); i++) {
			//i 번째 Missile 객체
			Missile tmp=missList.get(i);
			//만일 i 번째 미사일 객체가 제거할 객체라면
			if(tmp.isRemove()) {
				//List 에서 i 번째 item 을 제거한다
				missList.remove(i);
			}
		}
		
		back1Y += 2;
		back2Y += 2;
		//만일 배경1이 아래쪽으로 벗어난다면
		if(back1Y >= 800) {
			// -800 의 좌표로 다시 보낸다.
			back1Y = -800;
		}
		//만일 배경2가 아래쪽으로 벗어난다면
		if(back2Y >= 800) {
			// -800 의 좌표로 다시 보낸다.
			back2Y = -800;
		}
	}
}



















