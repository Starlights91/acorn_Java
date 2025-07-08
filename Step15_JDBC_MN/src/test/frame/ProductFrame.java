package test.frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import test.dao.ProductDao;
import test.dto.ProductDto;

public class ProductFrame extends JFrame {
	// 필요한 필드 정의하기 (상품명, 재고수량, 가격, 검색창)
	JTextField inputPname, inputStockno, inputPrice, searchField;
	// 표 형식으로 정보를 출력할 UI
	JTable table;
	// JTable 에 출력할 data 를 공급해줄 모델 객체
	DefaultTableModel model;
	// MemberDao 를 자주 사용할 예정이기 때문에 미리 필드에 참조값 넣어두기
	ProductDao dao = new ProductDao();

	// 생성자
	public ProductFrame() {

		// 레이아웃 설정
		setLayout(new BorderLayout());
		// JLabel 3개
		JLabel label1 = new JLabel("상품명");
		JLabel label2 = new JLabel("재고 수량");
		JLabel label3 = new JLabel("가격");

		// JTextField
		inputPname = new JTextField(10);
		inputStockno = new JTextField(5);
		inputPrice = new JTextField(7);

		// JButton
		JButton insertBtn = new JButton("저장");
		var updateBtn = new JButton("수정");
		JButton deleteBtn = new JButton("삭제");
		
		// 수정 버튼의 동작
		updateBtn.addActionListener((e) -> {
			int selectedRow = table.getSelectedRow();
			if(selectedRow == -1) {
				JOptionPane.showMessageDialog(this, "수정할 row 를 선택해 주세요!");
				return;
			}
			int id = (int)model.getValueAt(selectedRow, 0);
			ProductDto dto = dao.getById(id);
					
		
			// 수정 UI
			JTextField inputPname = new JTextField(10);
			JTextField inputStockno = new JTextField(5);
			JTextField inputPrice = new JTextField(7);
			JPanel editPanel = new JPanel();
			editPanel.add(new JLabel("상품명:"));
			editPanel.add(inputPname);
			editPanel.add(new JLabel("재고:"));
			editPanel.add(inputStockno);
			editPanel.add(new JLabel("가격:"));
			editPanel.add(inputPrice);

			inputPname.setText(dto.getPname());
			inputStockno.setText(dto.getStockno()+"");
			inputPrice.setText(dto.getPrice()+"");
					
			int result = JOptionPane.showConfirmDialog(this, editPanel, 
					id+" 번 상품 수정", JOptionPane.OK_CANCEL_OPTION);
					
			if(result == JOptionPane.OK_OPTION) {
				String pname = inputPname.getText();
				int stockno = Integer.parseInt(inputStockno.getText());
				int price = Integer.parseInt(inputPrice.getText());
				ProductDto newDto = new ProductDto();
				newDto.setId(id);
				newDto.setPname(pname);
				newDto.setStockno(stockno);
				newDto.setPrice(price);
				boolean isSuccess = dao.update(newDto);
				if(isSuccess) {
					JOptionPane.showMessageDialog(this, "수정 성공!");
					printProduct();
				}else {
					JOptionPane.showMessageDialog(this, "수정 실패!");
				}
			}
		});
				
		// 추가 버튼의 동작
		insertBtn.addActionListener((e) -> {
			String pname = inputPname.getText();
			int stockno = Integer.parseInt(inputStockno.getText());
			int price = Integer.parseInt(inputPrice.getText());
			
			ProductDto dto = new ProductDto();
			dto.setPname(pname);
			dto.setStockno(stockno);
			dto.setPrice(price);
			
			boolean isSuccess = dao.insert(dto);
			if(isSuccess) {
				JOptionPane.showMessageDialog(this, "추가 했습니다");
			}else {
				JOptionPane.showMessageDialog(this, "추가 실패!");
			}
			printProduct();
		});
		
		// 삭제 버튼의 동작
		deleteBtn.addActionListener((e) -> {
			int selectedRow = table.getSelectedRow();
			if(selectedRow == -1) {
				JOptionPane.showMessageDialog(this, "삭제할 row 를 선택해 주세요!");
				return;
			}
			int id = (int)model.getValueAt(selectedRow, 0);
			dao.deleteById(id);
			printProduct();
		});			

		// JPanel 페널에 UI 배치 (ProductFrame 생성자 안에 왼->오 순서대로 넣어야 함!)
		JPanel panel = new JPanel();
		panel.add(label1); // 상품명 레이블
		panel.add(inputPname); // 상품명 입력란
		panel.add(label2); // 재고수량 레이블
		panel.add(inputStockno); // 재고수량 입력란
		panel.add(label3); // 가격 레이블
		panel.add(inputPrice); // 가격 입력란
		panel.add(insertBtn); // 추가 버튼
		panel.add(updateBtn); // 수정 버튼
		panel.add(deleteBtn); // 삭제 버튼

		// 페널의 배경색 설정
		panel.setBackground(Color.pink);
		// 페널을 프레임의 위쪽에 배치
		add(panel, BorderLayout.NORTH);

		// 테이블
		// 회원목록을 출력할 테이블
		table = new JTable();
		// 테이블의 칼럼명을 배열로 미리 준비한다.
		String[] colNames = { "상품번호", "상품명", "재고수량", "가격" };
		// 테이블에 연결할 모델 객체`
		model = new DefaultTableModel();
		// 모델에 칼럼명을 전달한다.
		model.setColumnIdentifiers(colNames);
		// 모델을 테이블에 연결
		table.setModel(model);

		// 테이블의 글자 크기와 행의 높이 조절
		table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
		table.setFont(new Font("Sans-serif", Font.PLAIN, 12)); // 데이터 글자 크기 14
		table.setRowHeight(25); // 각 행의 높이를 조정

		// row 가 많은 경우 스크롤이 가능하도록 테이블에 scroll 기능을 부여한다.
		JScrollPane scroll = new JScrollPane(table);
		// 테이블을 품고 있는 JScrollPane 을 프레임의 가운데에 배치하기
		add(scroll, BorderLayout.CENTER);

		printProduct();
	}
		

	// 상품 목록을 출력하는 메소드
	public void printProduct() {
		model.setRowCount(0);
		List<ProductDto> list = dao.selectAll();
		for (ProductDto tmp : list) {
			Object[] row = { tmp.getId(), tmp.getPname(), tmp.getStockno(), tmp.getPrice() };
			model.addRow(row);
		}
	}

	public static void main(String[] args) {
		ProductFrame f = new ProductFrame();
		f.setTitle("상품 및 재고 관리 프로그램");
		f.setBounds(100, 100, 800, 500);
		f.setDefaultCloseOperation(EXIT_ON_CLOSE);
		f.setVisible(true);
	}

}
