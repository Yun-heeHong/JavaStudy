package 자바26_윈도우프로그래밍_자판기;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class MainAdmin11 extends Frame implements ActionListener{
	//상품 테이블 읽어와서 저장하는 2차원배열
	String coffee[][] = new String[6][4];
	
	private Dimension dimen, dimen1;
	private int xpos, ypos;
	Font font20 = new Font("SansSerif", Font.PLAIN, 20);
	Font font30 = new Font("SansSerif", Font.BOLD, 30);
	Font font50 = new Font("SansSerif", Font.BOLD, 50);
	
	
	Label lbTitle = new Label("커피 - 자판기(관리자화면)");
	Label lbCoffee1Name = new Label("상품1 이름:",Label.CENTER);
	Label lbCoffee2Name = new Label("상품2 이름:",Label.CENTER);
	Label lbCoffee3Name = new Label("상품3 이름:",Label.CENTER);
	Label lbCoffee4Name = new Label("상품4 이름:",Label.CENTER);
	Label lbCoffee5Name = new Label("상품5 이름:",Label.CENTER);
	Label lbCoffee6Name = new Label("상품6 이름:",Label.CENTER);
	
	TextField tfCoffee1Name = new TextField();
	TextField tfCoffee2Name = new TextField();
	TextField tfCoffee3Name = new TextField();
	TextField tfCoffee4Name = new TextField();
	TextField tfCoffee5Name = new TextField();
	TextField tfCoffee6Name = new TextField();
	
	
	Label lbCoffee1Cnt = new Label("수량 :",Label.CENTER);
	Label lbCoffee2Cnt = new Label("수량 :",Label.CENTER);
	Label lbCoffee3Cnt = new Label("수량 :",Label.CENTER);
	Label lbCoffee4Cnt = new Label("수량 :",Label.CENTER);
	Label lbCoffee5Cnt = new Label("수량 :",Label.CENTER);
	Label lbCoffee6Cnt = new Label("수량 :",Label.CENTER);

	TextField tfCoffee1Cnt = new TextField();
	TextField tfCoffee2Cnt = new TextField();
	TextField tfCoffee3Cnt = new TextField();
	TextField tfCoffee4Cnt = new TextField();
	TextField tfCoffee5Cnt = new TextField();
	TextField tfCoffee6Cnt = new TextField();
	
	Label lbCoffee1Price = new Label("가격 :",Label.CENTER);
	Label lbCoffee2Price = new Label("가격 :",Label.CENTER);
	Label lbCoffee3Price = new Label("가격 :",Label.CENTER);
	Label lbCoffee4Price = new Label("가격 :",Label.CENTER);
	Label lbCoffee5Price = new Label("가격 :",Label.CENTER);
	Label lbCoffee6Price = new Label("가격 :",Label.CENTER);

	TextField tfCoffee1Price = new TextField();
	TextField tfCoffee2Price = new TextField();
	TextField tfCoffee3Price = new TextField();
	TextField tfCoffee4Price = new TextField();
	TextField tfCoffee5Price = new TextField();
	TextField tfCoffee6Price = new TextField();
	
	Button btnCofee1 = new Button("적용");
	Button btnCofee2 = new Button("적용");
	Button btnCofee3 = new Button("적용");
	Button btnCofee4 = new Button("적용");
	Button btnCofee5 = new Button("적용");
	Button btnCofee6 = new Button("적용");

	
	
	
	MainAdmin11()
	{
		super("커피 - 자판기");
		this.setSize(1200,950);
		this.center();
		this.init();
		this.startEvent();
		this.setVisible(true);
		//디비에 연동해서 현재 데이타 가져와서 붙이기.
		getData();
	}
	void init() {	
		this.setLayout(null);
		this.add(lbTitle);
		this.add(lbCoffee1Cnt);this.add(lbCoffee1Price);this.add(btnCofee1);
		this.add(lbCoffee2Cnt);this.add(lbCoffee2Price);this.add(btnCofee2);
		this.add(lbCoffee3Cnt);this.add(lbCoffee3Price);this.add(btnCofee3);
		this.add(lbCoffee4Cnt);this.add(lbCoffee4Price);this.add(btnCofee4);
		this.add(lbCoffee5Cnt);this.add(lbCoffee5Price);this.add(btnCofee5);
		this.add(lbCoffee6Cnt);this.add(lbCoffee6Price);this.add(btnCofee6);
		this.add(lbCoffee1Name);
		this.add(lbCoffee2Name);
		this.add(lbCoffee3Name);
		this.add(lbCoffee4Name);
		this.add(lbCoffee5Name);
		this.add(lbCoffee6Name);			
		this.add(tfCoffee1Name);this.add(tfCoffee1Cnt);this.add(tfCoffee1Price);
		this.add(tfCoffee2Name);this.add(tfCoffee2Cnt);this.add(tfCoffee2Price);
		this.add(tfCoffee3Name);this.add(tfCoffee3Cnt);this.add(tfCoffee3Price);
		this.add(tfCoffee4Name);this.add(tfCoffee4Cnt);this.add(tfCoffee4Price);
		this.add(tfCoffee5Name);this.add(tfCoffee5Cnt);this.add(tfCoffee5Price);
		this.add(tfCoffee6Name);this.add(tfCoffee6Cnt);this.add(tfCoffee6Price);
		
		
		lbTitle.setBounds(300, 40, 600, 50);lbTitle.setFont(font50);
		//상품1		
		lbCoffee1Name.setBounds(50, 200, 210, 50);lbCoffee1Name.setFont(font30);
		tfCoffee1Name.setBounds(260, 200, 240, 50);tfCoffee1Name.setFont(font30);
		lbCoffee1Cnt.setBounds(500, 200, 100, 50);lbCoffee1Cnt.setFont(font30);
		tfCoffee1Cnt.setBounds(600, 200, 100, 50);tfCoffee1Cnt.setFont(font30);
		lbCoffee1Price.setBounds(700, 200, 100, 50);lbCoffee1Price.setFont(font30);
		tfCoffee1Price.setBounds(800, 200, 150, 50);tfCoffee1Price.setFont(font30);
		btnCofee1.setBounds(1000, 200, 100, 50);btnCofee1.setFont(font30);
		
		//상품2		
		lbCoffee2Name.setBounds(50, 300, 210, 50);lbCoffee2Name.setFont(font30);
		tfCoffee2Name.setBounds(260, 300, 240, 50);tfCoffee2Name.setFont(font30);
		lbCoffee2Cnt.setBounds(500, 300, 100, 50);lbCoffee2Cnt.setFont(font30);
		tfCoffee2Cnt.setBounds(600, 300, 100, 50);tfCoffee2Cnt.setFont(font30);
		lbCoffee2Price.setBounds(700, 300, 100, 50);lbCoffee2Price.setFont(font30);
		tfCoffee2Price.setBounds(800, 300, 150, 50);tfCoffee2Price.setFont(font30);
		btnCofee2.setBounds(1000, 300, 100, 50);btnCofee2.setFont(font30);		
		//상품3	
		lbCoffee3Name.setBounds(50, 400, 210, 50);lbCoffee3Name.setFont(font30);
		tfCoffee3Name.setBounds(260, 400, 240, 50);tfCoffee3Name.setFont(font30);
		lbCoffee3Cnt.setBounds(500, 400, 100, 50);lbCoffee3Cnt.setFont(font30);
		tfCoffee3Cnt.setBounds(600, 400, 100, 50);tfCoffee3Cnt.setFont(font30);
		lbCoffee3Price.setBounds(700, 400, 100, 50);lbCoffee3Price.setFont(font30);
		tfCoffee3Price.setBounds(800, 400, 150, 50);tfCoffee3Price.setFont(font30);
		btnCofee3.setBounds(1000, 400, 100, 50);btnCofee3.setFont(font30);
		
		//상품4	
		lbCoffee4Name.setBounds(50, 500, 210, 50);lbCoffee4Name.setFont(font30);
		tfCoffee4Name.setBounds(260, 500, 240, 50);tfCoffee4Name.setFont(font30);
		lbCoffee4Cnt.setBounds(500, 500, 100, 50);lbCoffee4Cnt.setFont(font30);
		tfCoffee4Cnt.setBounds(600, 500, 100, 50);tfCoffee4Cnt.setFont(font30);
		lbCoffee4Price.setBounds(700, 500, 100, 50);lbCoffee4Price.setFont(font30);
		tfCoffee4Price.setBounds(800, 500, 150, 50);tfCoffee4Price.setFont(font30);
		btnCofee4.setBounds(1000, 500, 100, 50);btnCofee4.setFont(font30);
		//상품5	
		lbCoffee5Name.setBounds(50, 600, 210, 50);lbCoffee5Name.setFont(font30);
		tfCoffee5Name.setBounds(260, 600, 240, 50);tfCoffee5Name.setFont(font30);
		lbCoffee5Cnt.setBounds(500, 600, 100, 50);lbCoffee5Cnt.setFont(font30);
		tfCoffee5Cnt.setBounds(600, 600, 100, 50);tfCoffee5Cnt.setFont(font30);
		lbCoffee5Price.setBounds(700, 600, 100, 50);lbCoffee5Price.setFont(font30);
		tfCoffee5Price.setBounds(800, 600, 150, 50);tfCoffee5Price.setFont(font30);
		btnCofee5.setBounds(1000, 600, 100, 50);btnCofee5.setFont(font30);		
		
		//상품6	
		lbCoffee6Name.setBounds(50, 700, 210, 50);lbCoffee6Name.setFont(font30);
		tfCoffee6Name.setBounds(260, 700, 240, 50);tfCoffee6Name.setFont(font30);
		lbCoffee6Cnt.setBounds(500, 700, 100, 50);lbCoffee6Cnt.setFont(font30);
		tfCoffee6Cnt.setBounds(600, 700, 100, 50);tfCoffee6Cnt.setFont(font30);
		lbCoffee6Price.setBounds(700, 700, 100, 50);lbCoffee6Price.setFont(font30);
		tfCoffee6Price.setBounds(800, 700, 150, 50);tfCoffee6Price.setFont(font30);
		btnCofee6.setBounds(1000, 700, 100, 50);btnCofee6.setFont(font30);		
		
	}	

	void startEvent()
	{
		btnCofee1.addActionListener(this);
		btnCofee2.addActionListener(this);
		btnCofee3.addActionListener(this);
		btnCofee4.addActionListener(this);
		btnCofee5.addActionListener(this);
		btnCofee6.addActionListener(this);

		
	}
	void center() {
		dimen = Toolkit.getDefaultToolkit().getScreenSize();
		dimen1 = this.getSize();
		xpos = (int) (dimen.getWidth() / 2 - dimen1.getWidth() / 2);
		ypos = (int) (dimen.getHeight() / 2 - dimen1.getHeight() / 2);
		this.setLocation(xpos, ypos);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				adminClose();
			}
		});
	}
	void adminClose()
	{
		this.setVisible(false);
	}
	public void actionPerformed(ActionEvent e) {

		String coffee1Name = tfCoffee1Name.getText();
		String coffee2Name = tfCoffee2Name.getText();
		String coffee3Name = tfCoffee3Name.getText();
		String coffee4Name = tfCoffee4Name.getText();
		String coffee5Name = tfCoffee5Name.getText();
		String coffee6Name = tfCoffee6Name.getText();
		
		String coffee1Cnt = tfCoffee1Cnt.getText();
		String coffee2Cnt = tfCoffee2Cnt.getText();
		String coffee3Cnt = tfCoffee3Cnt.getText();
		String coffee4Cnt = tfCoffee4Cnt.getText();
		String coffee5Cnt = tfCoffee5Cnt.getText();
		String coffee6Cnt = tfCoffee6Cnt.getText();
		
		String coffee1Price = tfCoffee1Price.getText();
		String coffee2Price = tfCoffee2Price.getText();
		String coffee3Price = tfCoffee3Price.getText();
		String coffee4Price = tfCoffee4Price.getText();
		String coffee5Price = tfCoffee5Price.getText();
		String coffee6Price = tfCoffee6Price.getText();
		
		
		
		
		if(e.getSource() == btnCofee1)
		{
			if(spaceCheck(coffee1Name, coffee1Cnt, coffee1Price))
			{
				return;
			}
			else
			{
				update(1,coffee1Name, coffee1Cnt, coffee1Price);
			}
					
		}
		else if(e.getSource() == btnCofee2)
		{
			if(spaceCheck(coffee2Name, coffee2Cnt, coffee2Price))
			{
				return;
			}
			else
			{
				update(2,coffee2Name, coffee2Cnt, coffee2Price);
			}
			
		}
		else if(e.getSource() == btnCofee3)
		{
			if(spaceCheck(coffee3Name, coffee3Cnt, coffee3Price))
			{
				return;
			}
			else
			{
				update(3,coffee3Name, coffee3Cnt, coffee3Price);
			}
		}
		else if(e.getSource() == btnCofee4)
		{
			if(spaceCheck(coffee4Name, coffee4Cnt, coffee4Price))
			{
				return;
			}
			else
			{
				update(4,coffee4Name, coffee4Cnt, coffee4Price);
			}
		}
		else if(e.getSource() == btnCofee5)
		{
			if(spaceCheck(coffee5Name, coffee5Cnt, coffee5Price))
			{
				return;
			}
			else
			{
				update(5,coffee5Name, coffee5Cnt, coffee5Price);
			}
		}
		else if(e.getSource() == btnCofee6)
		{
			if(spaceCheck(coffee6Name, coffee6Cnt, coffee6Price))
			{
				return;
			}
			else
			{
				update(6,coffee6Name, coffee6Cnt, coffee6Price);
			}
		}
		
			
			
	}
	boolean spaceCheck(String name, String cnt, String price)	
	{
		if(name.equals("")) {msg("커피명을 적어주세요."); return true;}
		if(cnt.equals("")) {msg("수량을 적어주세요.");   return true;}
		if(price.equals("")) {msg("가격을 적어주세요."); return true;}
		
		//여기까지왔다는건 공백이 아니라서 false~
		return false;
	}
	
	void msg(String msg)
	{
		final Dialog dlg = new Dialog(this, "알림 메세지창", true);
		dlg.setLayout(null);
		Label lbMsg = new Label(msg);
		
		dlg.add(lbMsg);	lbMsg.setFont(font20);
		lbMsg.setBounds(100, 100, 450, 30);
		
		dlg.setSize(500, 250);
		dlg.setLocation(700, 400);
		
		dlg.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dlg.setVisible(false);
			}
		});
		dlg.setVisible(true);
	}
	
	void search(String name)
	{
		try {
			Class.forName("org.gjt.mm.mysql.Driver");
		} catch (ClassNotFoundException ee) {
			System.out.println("드라이브가 연결안됨.");
			System.exit(0);
		}
		Connection conn = null;
		String url = "jdbc:mysql://127.0.0.1:3306/dw202?"
				+ "useUnicode=true&characterEncoding=utf8";				
		String id = "root";
		String pass = "qwer";
		Statement stmt = null;
		ResultSet rs = null;
		String query = "select * from member";
		try {
			conn = DriverManager.getConnection(url, id, pass);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			
			while (rs.next()) {
				if(rs.getString(4).equals(name))
				{

				}
			}
			
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException ee) {
			System.err.println("error = " + ee.toString());
		}
	}
	void getData()
	{
		try {
			Class.forName("org.gjt.mm.mysql.Driver");
		} catch (ClassNotFoundException ee) {
			System.out.println("드라이브가 연결안됨.");
			System.exit(0);
		}
		Connection conn = null;
		String url = "jdbc:mysql://127.0.0.1:3306/dw202?"
				+ "useUnicode=true&characterEncoding=utf8";				
		String id = "root";
		String pass = "qwer";
		Statement stmt = null;
		ResultSet rs = null;
		String query = "select * from japangi";
		try {
			conn = DriverManager.getConnection(url, id, pass);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			String result="";
			int count=0;
			
			while (rs.next()) {
				coffee[count][0] = rs.getInt("idx")+"";
				coffee[count][1] = rs.getString("name");
				coffee[count][2] = rs.getString("cnt");
				coffee[count][3] = rs.getString("price");				
				count++;
			}
			//화면에 뿌리기...노가다..					
					tfCoffee1Name.setText(coffee[0][1]);
					tfCoffee1Cnt.setText(coffee[0][2]);
					tfCoffee1Price.setText(coffee[0][3]);
					
					tfCoffee2Name.setText(coffee[1][1]);
					tfCoffee2Cnt.setText(coffee[1][2]);
					tfCoffee2Price.setText(coffee[1][3]);
					
					tfCoffee3Name.setText(coffee[2][1]);
					tfCoffee3Cnt.setText(coffee[2][2]);
					tfCoffee3Price.setText(coffee[2][3]);
					
					tfCoffee4Name.setText(coffee[3][1]);
					tfCoffee4Cnt.setText(coffee[3][2]);
					tfCoffee4Price.setText(coffee[3][3]);
					
					tfCoffee5Name.setText(coffee[4][1]);
					tfCoffee5Cnt.setText(coffee[4][2]);
					tfCoffee5Price.setText(coffee[4][3]);
					
					tfCoffee6Name.setText(coffee[5][1]);
					tfCoffee6Cnt.setText(coffee[5][2]);
					tfCoffee6Price.setText(coffee[5][3]);
			
		
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException ee) {
			System.err.println("error = " + ee.toString());
		}
	}
	
	boolean update(int idx, String name, String cnt, String price)
	{
		Connection dc=null;
		try {
			Class.forName("org.gjt.mm.mysql.Driver");
		} catch (ClassNotFoundException ee) {		
		}
		String url = "jdbc:mysql://127.0.0.1:3306/dw202?"
				+ "useUnicode=true&characterEncoding=utf8";
		String id = "root";
		String pass = "qwer";
		try {
			dc = DriverManager.getConnection(url, id, pass);
		} catch (SQLException ee) {
		}
		
		String query = "update japangi set name = ?, cnt = ?, price = ? where idx = ?";
	
		try {
			PreparedStatement pstmt = dc.prepareStatement(query);
			pstmt.setString(1, name);
			pstmt.setString(2, cnt);
			pstmt.setString(3, price);
			pstmt.setInt(4, idx);			
			pstmt.executeUpdate();
			pstmt.close();
			msg("정보수정완료!");
		} catch (SQLException ee) {
			System.err.println("정보수정 실패!!:"+ee.getMessage());
			return false;
		}
		return true;
	}

}
