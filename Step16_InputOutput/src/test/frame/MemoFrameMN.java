package test.frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class MemoFrameMN extends JFrame {

	// 필요한 필드 정의하기
	JTextArea ta = new JTextArea();
	// 현재 열린 파일 객체를 저장할 필드
	File openedFile;
	
	
	// 생성자
	public MemoFrameMN(String title) {
		super(title);
		
		//메뉴바, File 메뉴, View -> Theme 메뉴 구성
		JMenuBar mb=new JMenuBar();
		//메뉴
		JMenu menu=new JMenu("File");
		JMenu viewMenu=new JMenu("View"); // 사용자 맞춤: 보기
		JMenu themeMenu=new JMenu("Theme"); // 테마 설정
		
		// File 메뉴 아이템
		JMenuItem newItem=new JMenuItem("New");
		JMenuItem openItem=new JMenuItem("Open"); // 저장된 노트 불러오기 기능 +
		JMenuItem saveItem=new JMenuItem("Save");
		JMenuItem saveAsItem=new JMenuItem("Save As");
		
		
		
		//Theme 메뉴 아이템
		JMenuItem pastelItem = new JMenuItem("Pastel");
		JMenuItem darkItem = new JMenuItem("Dark");

		
		//처음에 저장기능은 disable 된 상태로 초기값을 만든다 (아직 메모장을 작성하지 않은 상태라서 비활성화 하는 것)
		saveItem.setEnabled(false);
		saveAsItem.setEnabled(false);
		
		//메뉴에 메뉴 아이템을 순서대로 추가 
		menu.add(newItem);
		menu.add(openItem);
		menu.add(saveItem);
		menu.add(saveAsItem);
		//Theme 메뉴에 아이템 추가
		themeMenu.add(pastelItem);
		themeMenu.add(darkItem);
		// View 메뉴에 Theme 메뉴 추가
		viewMenu.add(themeMenu);
		
		// 메뉴바에 File, View 추가
		//메뉴를 메뉴바에 추가 
		mb.add(menu);
		mb.add(viewMenu);
		//프레임의 메소드를 이용해서 메뉴바를 추가하기 
		setJMenuBar(mb);

		
		//레이아웃 설정
		setLayout(new BorderLayout());
		
		//스크롤 페널
		JScrollPane scp=new JScrollPane(ta);
		//프레임의 가운데에 JScrollPane 을 배치하기 
		add(scp, BorderLayout.CENTER);
		
		//JTextArea 의 글자 크기 조절하기
		Font font=new Font("Serif", Font.PLAIN, 30);
		ta.setFont(font);
		//처음에는 JTextArea 를 안보이게 설정
		ta.setVisible(false);
		
		
		
		// new 를 눌렀을때
		newItem.addActionListener((e)->{
			ta.setVisible(true); //처음에는 ta.setVisible(false); 라서 안보임. -> file 에서 new 누르면, 여기 함수가 실행되어 보이는 것!)  
			//프레임의 제목 바꾸기
			setTitle("제목 없음");
			//new 를 눌렀을 떄 saveAs 버튼만 활성화.
			saveAsItem.setEnabled(true);
			// New 할때 배경색 랜덤 파스텔 색 적용 되도록.
		    ta.setBackground(getRandomPastelColor());
			
		});
		
		// (내가 추가) Open 을 눌렀을 때 (FileReader+BufferReader 로 읽어와서 JTextArea 에 넣어야 함!)
		openItem.addActionListener((e)->{
			//파일 선택을 하게 해주는 객체 생성: JFileChooser() 
			var fc=new JFileChooser();
			//파일을 불러오게 하는 다이얼로그 팝업 창 띄우기
			int resultOD=fc.showOpenDialog(this); // int 정수값을 리턴 -> 사용자가 버튼을 눌렀을 때 취소/승인/에러 옵션 형태로 나타낼 수 있음
			//만약 제대로 파일을 오픈할 준비를 했다면
			if(resultOD == JFileChooser.APPROVE_OPTION) {
				//선택한 해당 File 객체를 얻어오기
				openedFile=fc.getSelectedFile();
				//프레임의 title 은 열어서 불러온 파일명으로 바꿔서 출력
				setTitle(openedFile.getName());
				
				//실제로 해당 파일 내용을 읽어서 JTextArea 에 출력하기
				try (
					//파일을 읽기 위한 FileReader(파일로 부터 문자열을 읽어들일수 있는 객체 생성) 
					// ** => 여기서 에러가 나는데, var fr = new FileReader(openedFile); => add catch clause to surrounding try 하면 된다
					var fr = new FileReader(openedFile);
					//좀 더 좋은 기능(라인 단위로 읽기 위해서)을 가지고 있는 BufferedReader 객체 생성
					var br = new BufferedReader(fr);
				){
				// 입력한 문자열을 누적시킬 StringBuilder 생성하기
				StringBuilder sb=new StringBuilder();
				//한 줄씩 읽어서 담을 변수
				String line;
				while((line = br.readLine()) !=null) {
					sb.append(line).append("\n"); //줄 단위로 + 개행기호 추가되도록
				}
				// StringBuilder sb 에서 누적된 문자열은 JTextArea ta 에 넣기
				ta.setText(sb.toString());
				// 상단에 초기값으론 JTextArea 안보이게 설정해뒀어서, 다시 보이게 처리하기
				ta.setVisible(true);
				
				//파일 열었으니까, 저장 기능 활성화 시키기
				saveItem.setEnabled(true);
				saveAsItem.setEnabled(true);
				// Open 할때도 배경색 랜덤 파스텔 컬러가 나오게 하도록 추가하기
	            ta.setBackground(getRandomPastelColor());
				
				//var fr = new FileReader(openedFile); 위에서 => add catch clause to surrounding try 한 것.
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(this, "파일을 불러오는데 실패했습니다.");
				}
				
			}
		
		});
		
		
		// (내가 추가) Save 를 눌렀을 때
		saveItem.addActionListener((e)->{
			// 현재 openedFile 에 내용을 저장하는 메소드 호출
			saveToFile();
		});
		
		
		//Save As 를 눌렀을때
		saveAsItem.addActionListener((e)->{
			//파일 선택을 하게 해주는 객체 생성
			var fc=new JFileChooser();
			//파일을 저장하게 하는 다이얼로그 띄우기 
			int resultSD=fc.showSaveDialog(this); // int 정수값을 리턴 -> 사용자가 버튼을 눌렀을 때 어떤 동작
			//만일 제대로 파일을 만들 준비를 했다면
			if(resultSD == JFileChooser.APPROVE_OPTION) {
				//해당 File 객체를 얻어오기
				openedFile=fc.getSelectedFile();
				//프레임의 title 로 파일명을 출력 
				setTitle(openedFile.getName()); // 여기까지작성하면 파일 실행
				//실제로 해당 파일 만들기 (openedFile.createNewFile(); 입력하고, 에러뜬 부분 위에서 -> surround with try/catch)
				try {
					openedFile.createNewFile();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				//파일에 저장하는 메소드 호출
				saveToFile();
			}
		});
		
		// PastelColor 클릭하면 배경색 파스텔톤으로
		pastelItem.addActionListener((e)->{
		    ta.setBackground(getRandomPastelColor());
		});

		// Dark 클릭하면 배경색 어두운 톤으로
		darkItem.addActionListener((e)->{
		    ta.setBackground(getRandomDarkColor());
		});
		
	}


		// (내가 추가) 파스텔톤 랜덤 컬러를 만들어서 리턴하는 메소드 //참고 0~255: int r/g/b=(int)(Math.random() * 256);
		public Color getRandomPastelColor() {
			int r= 150 + (int)(Math.random() * 106); // 150~255
			int g= 150 + (int)(Math.random() * 106);
			int b= 150 + (int)(Math.random() * 106);
			return new Color(r,g,b);
	}
	
	// (내가 추가) 어두운 톤 랜덤 색 만들어서 리턴하는 메소드
	    public Color getRandomDarkColor() {
	        int r = (int)(Math.random() * 101);
	        int g = (int)(Math.random() * 101);
	        int b = (int)(Math.random() * 101);
	        return new Color(r, g, b);
	    }


	// 현재까지 JTextArea 에 입력한 내용을 읽어와서 openedFile 에 저장하는 메소드
	public void saveToFile() {
		// JTextArea 에 입력한 문자열을 읽어와서
		String memo = ta.getText();
		// FileWriter 객체를 이용해서 openedFile 객체에 문자열이 저장되도록 한다.
		try (var fw = new FileWriter(openedFile);) {
			fw.append(memo);
			fw.flush();
			JOptionPane.showMessageDialog(this, "저장했습니다");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		MemoFrameMN f = new MemoFrameMN("메모장");
		f.setBounds(100, 100, 500, 500);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		// 메모장 열 때 (프로그램 실행 시에) 배경색을 매번 파스텔톤의 새로운 색 랜덤으로 적용하여 변경 = ta.setBackground(f.getRandomColor())
		f.ta.setBackground(f.getRandomPastelColor());
		f.setVisible(true);
	}	
	
	
	
}


