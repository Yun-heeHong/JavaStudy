package �ڹ�26_���������α׷���_���Ǳ�;

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

public class MainScreen11 extends Frame implements ActionListener{
	
	int coin=0; //�������Աݾ�
	int totCoin=0; //�Ѱ����ݾ�
	
	//Ŀ�� �ݾ� ���� Ŀ�Ǹ�
	int coffeePrice[] = {2001,2002,2003,2004,2005,2006};
	int coffeeCnt[] = {1,2,3,4,5,6};
	String coffeeName[] = {"Ŀ���","����������","�ݵ���","�Ƹ޸�ī��","�ٴҶ��","ī���ī"};
	
	//������ Ŀ�� ����
	int selCoffee = 0; //0~5�� ���ʴ��Ŀ�� ������ �迭�� �����س��� 
	
	boolean makeCheck=true;
	
	private Dimension dimen, dimen1;
	private int xpos, ypos;
	Font font20 = new Font("SansSerif", Font.PLAIN, 20);
	Font font30 = new Font("SansSerif", Font.BOLD, 30);
	Font font50 = new Font("SansSerif", Font.BOLD, 50);
	
	private Image img1;
	private Image img2;
	private Image img3;
	private Image img4;
	private Image img5;
	private Image img6;	
	private Image imgSel;//����������Ŀ��
	
	Label lbTitle = new Label("Ŀ�� - ���Ǳ�");
	Label lbCoffee1Cnt = new Label("���� "+coffeeCnt[0]+"��",Label.CENTER);
	Label lbCoffee2Cnt = new Label("���� "+coffeeCnt[1]+"��",Label.CENTER);
	Label lbCoffee3Cnt = new Label("���� "+coffeeCnt[2]+"��",Label.CENTER);
	Label lbCoffee4Cnt = new Label("���� "+coffeeCnt[3]+"��",Label.CENTER);
	Label lbCoffee5Cnt = new Label("���� "+coffeeCnt[4]+"��",Label.CENTER);
	Label lbCoffee6Cnt = new Label("���� "+coffeeCnt[5]+"��",Label.CENTER);
	Label lbCoffeeSelCnt = new Label("0��",Label.CENTER);
	Label lbCoffee1Price = new Label(coffeePrice[0]+"��",Label.CENTER);
	Label lbCoffee2Price = new Label(coffeePrice[1]+"��",Label.CENTER);
	Label lbCoffee3Price = new Label(coffeePrice[2]+"��",Label.CENTER);
	Label lbCoffee4Price = new Label(coffeePrice[3]+"��",Label.CENTER);
	Label lbCoffee5Price = new Label(coffeePrice[4]+"��",Label.CENTER);
	Label lbCoffee6Price = new Label(coffeePrice[5]+"��",Label.CENTER);
	Label lbCoffeeSelPrice = new Label("Ŀ�� - ���Ǳ�");
	Label lbSelTitle = new Label("���ô����..");
	Label lbJan1 = new Label("�����ܾ�  : ");
	Label lbJan2 = new Label(coin+"��",Label.RIGHT);
	Label lbCoin1 = new Label("��ǰ�ݾ�  : ");
	Label lbCoin2 = new Label("0��",Label.RIGHT);
	
	Label lbCoin = new Label("< ���Աݾ� >");
	Label lbSel = new Label("< ������ ��ǰ >");
	Label lbSelPrice = new Label("���� :    0��");

	Button btnCofee1 = new Button(coffeeName[0]);
	Button btnCofee2 = new Button(coffeeName[1]);
	Button btnCofee3 = new Button(coffeeName[2]);
	Button btnCofee4 = new Button(coffeeName[3]);
	Button btnCofee5 = new Button(coffeeName[4]);
	Button btnCofee6 = new Button(coffeeName[5]);
	Button btn1000 = new Button("1000��");
	Button btn5000 = new Button("5000��");
	Button btn10000 = new Button("10000��");
	Button btnBuy = new Button("�����ϱ�");
	Button btnAdmin = new Button("�����ڸ��");
	
	
	
	MainScreen11()
	{
		super("Ŀ�� - ���Ǳ�");
		this.setSize(1200,1050);
		this.center();
		this.init();
		this.startEvent();
		this.setVisible(true);
	}
	void init() {
		//��񿬵��ؼ� ��ó��
		//��ǰ��, ��ǰ����, ��ǰ������ ������
		getData();
		//ȭ�鿡 �������� ���� ����
		
		btnCofee1.setLabel(coffeeName[0]);
		lbCoffee1Cnt.setText("���� "+coffeeCnt[0]+"��");
		lbCoffee1Price.setText(coffeePrice[0]+"��");
		
		btnCofee2.setLabel(coffeeName[1]);
		lbCoffee2Cnt.setText("���� "+coffeeCnt[1]+"��");
		lbCoffee2Price.setText(coffeePrice[1]+"��");
		
		btnCofee3.setLabel(coffeeName[2]);
		lbCoffee3Cnt.setText("���� "+coffeeCnt[2]+"��");
		lbCoffee3Price.setText(coffeePrice[2]+"��");
		
		btnCofee4.setLabel(coffeeName[3]);
		lbCoffee4Cnt.setText("���� "+coffeeCnt[3]+"��");
		lbCoffee4Price.setText(coffeePrice[3]+"��");
		
		btnCofee5.setLabel(coffeeName[4]);
		lbCoffee5Cnt.setText("���� "+coffeeCnt[4]+"��");
		lbCoffee5Price.setText(coffeePrice[4]+"��");
		
		btnCofee6.setLabel(coffeeName[5]);
		lbCoffee6Cnt.setText("���� "+coffeeCnt[5]+"��");
		lbCoffee6Price.setText(coffeePrice[5]+"��");
		

		//ī���
		img1 = Toolkit.getDefaultToolkit().getImage("img/angel_coffee.png");
		//����������
		img2 = Toolkit.getDefaultToolkit().getImage("img/twosome_coffee.png");
		//�ݵ���
		img3 = Toolkit.getDefaultToolkit().getImage("img/pascucci_coffee.png");
		//�Ƹ޸�ī��
		img4 = Toolkit.getDefaultToolkit().getImage("img/kfc_coffee.png");
		//�ٴҶ��
		img5 = Toolkit.getDefaultToolkit().getImage("img/dunkin_coffee.png");
		//ī���ī
		img6 = Toolkit.getDefaultToolkit().getImage("img/isaac_coffee.png");
		//ī���ī
		imgSel = Toolkit.getDefaultToolkit().getImage("img/default.png");
		
		
		this.setLayout(null);
		this.add(lbTitle);
		this.add(lbCoffee1Cnt);this.add(lbCoffee1Price);this.add(btnCofee1);
		this.add(lbCoffee2Cnt);this.add(lbCoffee2Price);this.add(btnCofee2);
		this.add(lbCoffee3Cnt);this.add(lbCoffee3Price);this.add(btnCofee3);
		this.add(lbCoffee4Cnt);this.add(lbCoffee4Price);this.add(btnCofee4);
		this.add(lbCoffee5Cnt);this.add(lbCoffee5Price);this.add(btnCofee5);
		this.add(lbCoffee6Cnt);this.add(lbCoffee6Price);this.add(btnCofee6);
		this.add(lbCoffeeSelCnt);this.add(lbCoffeeSelPrice);
		this.add(btn1000);this.add(btn5000);this.add(btn10000);
		this.add(btnBuy);this.add(btnAdmin);
		this.add(lbCoin);
		this.add(lbCoin1);
		this.add(lbCoin2);
		this.add(lbSelTitle);
		this.add(lbJan1);
		this.add(lbJan2);
		this.add(lbSel);
		this.add(lbSelPrice);
		
		
		
		
		lbTitle.setBounds(400, 40, 600, 50);lbTitle.setFont(font50);
		//��ǰ1		
		lbCoffee1Cnt.setBounds(100, 300, 100, 30);lbCoffee1Cnt.setFont(font20);
		lbCoffee1Price.setBounds(100, 330, 100, 30);lbCoffee1Price.setFont(font20);
		btnCofee1.setBounds(50, 360, 250, 50);btnCofee1.setFont(font30);

		//��ǰ2		
		lbCoffee2Cnt.setBounds(400, 300, 100, 30);lbCoffee2Cnt.setFont(font20);
		lbCoffee2Price.setBounds(400, 330, 100, 30);lbCoffee2Price.setFont(font20);
		btnCofee2.setBounds(350, 360, 200, 50);btnCofee2.setFont(font30);

		//��ǰ3		
		lbCoffee3Cnt.setBounds(700, 300, 100, 30);lbCoffee3Cnt.setFont(font20);
		lbCoffee3Price.setBounds(700, 330, 100, 30);lbCoffee3Price.setFont(font20);
		btnCofee3.setBounds(650, 360, 200, 50);btnCofee3.setFont(font30);
		
		//��ǰ4		
		lbCoffee4Cnt.setBounds(100, 650, 100, 30);lbCoffee4Cnt.setFont(font20);
		lbCoffee4Price.setBounds(100, 680, 100, 30);lbCoffee4Price.setFont(font20);
		btnCofee4.setBounds(50, 710, 200, 50);btnCofee4.setFont(font30);

		//��ǰ5		
		lbCoffee5Cnt.setBounds(400, 650, 100, 30);lbCoffee5Cnt.setFont(font20);
		lbCoffee5Price.setBounds(400, 680, 100, 30);lbCoffee5Price.setFont(font20);
		btnCofee5.setBounds(350, 710, 200, 50);btnCofee5.setFont(font30);

		//��ǰ6		
		lbCoffee6Cnt.setBounds(700, 650, 100, 30);lbCoffee6Cnt.setFont(font20);
		lbCoffee6Price.setBounds(700, 680, 100, 30);lbCoffee6Price.setFont(font20);
		btnCofee6.setBounds(650, 710, 200, 50);btnCofee6.setFont(font30);
		
		lbCoin.setBounds(50, 800, 150, 50);lbCoin.setFont(font20);
		btn1000.setBounds(50, 850, 250, 50);btn1000.setFont(font30);
		btn5000.setBounds(350, 850, 250, 50);btn5000.setFont(font30);
		btn10000.setBounds(650, 850, 250, 50);btn10000.setFont(font30);
		btnAdmin.setBounds(950, 850, 200, 50);btnAdmin.setFont(font30);
		
		lbJan1.setBounds(50, 900, 150, 50);lbJan1.setFont(font30);
		lbJan2.setBounds(200, 900, 250, 50);lbJan2.setFont(font30);
		lbCoin1.setBounds(500, 900, 150, 50);lbCoin1.setFont(font30);
		lbCoin2.setBounds(650, 900, 250, 50);lbCoin2.setFont(font30);
		

		lbSel.setBounds(950, 160, 250, 50);lbSel.setFont(font30);
		lbSelTitle.setBounds(950, 460, 250, 50);lbSelTitle.setFont(font30);
		lbSelPrice.setBounds(950, 510, 250, 50);lbSelPrice.setFont(font30);
		btnBuy.setBounds(900, 600, 250, 50);btnBuy.setFont(font30);
		

		
	}	
	public void paint(Graphics g) {	
		
			g.drawImage(img1, 50, 100, 200, 200, this);
			g.drawImage(img2, 350, 100, 200, 200, this);
			g.drawImage(img3, 650, 100, 200, 200, this);
			g.drawImage(img4, 50, 450, 200, 200, this);
			g.drawImage(img5, 350, 450, 200, 200, this);
			g.drawImage(img6, 650, 450, 200, 200, this);
			
			g.drawImage(imgSel, 950, 250, 200, 200, this);
	}
	void startEvent()
	{
		btnCofee1.addActionListener(this);
		btnCofee2.addActionListener(this);
		btnCofee3.addActionListener(this);
		btnCofee4.addActionListener(this);
		btnCofee5.addActionListener(this);
		btnCofee6.addActionListener(this);
		btn1000.addActionListener(this);
		btn5000.addActionListener(this);
		btn10000.addActionListener(this);
		btnBuy.addActionListener(this);
		btnAdmin.addActionListener(this);
		
	}
	void center() {
		dimen = Toolkit.getDefaultToolkit().getScreenSize();
		dimen1 = this.getSize();
		xpos = (int) (dimen.getWidth() / 2 - dimen1.getWidth() / 2);
		ypos = (int) (dimen.getHeight() / 2 - dimen1.getHeight() / 2);
		this.setLocation(xpos, ypos);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	public void actionPerformed(ActionEvent e) {

		if(e.getSource() == btnCofee1)
		{
			selCoffee=0;//1��Ŀ�Ǽ���
			imgSel = Toolkit.getDefaultToolkit().getImage("img/angel_coffee.png");
			totCoin = coffeePrice[0];
			lbCoin2.setText(totCoin+"��");	
			lbSelPrice.setText(totCoin+"��");
			lbSelTitle.setText(coffeeName[0]);
			this.repaint();
					
		}
		else if(e.getSource() == btnCofee2)
		{
			selCoffee=1;//2��Ŀ�Ǽ���
			imgSel = Toolkit.getDefaultToolkit().getImage("img/twosome_coffee.png");
			totCoin = coffeePrice[1];
			lbCoin2.setText(totCoin+"��");
			lbSelPrice.setText(totCoin+"��");
			lbSelTitle.setText(coffeeName[1]);
			this.repaint();
		}
		else if(e.getSource() == btnCofee3)
		{
			selCoffee=2;//3��Ŀ�Ǽ���
			imgSel = Toolkit.getDefaultToolkit().getImage("img/kfc_coffee.png");
			totCoin = coffeePrice[2];
			lbCoin2.setText(totCoin+"��");
			lbSelPrice.setText(totCoin+"��");
			lbSelTitle.setText(coffeeName[2]);
			this.repaint();
		}
		else if(e.getSource() == btnCofee4)
		{
			selCoffee=3;//4��Ŀ�Ǽ���
			imgSel = Toolkit.getDefaultToolkit().getImage("img/dunkin_coffee.png");
			totCoin = coffeePrice[3];
			lbSelPrice.setText(totCoin+"��");
			lbSelTitle.setText(coffeeName[3]);
			lbCoin2.setText(totCoin+"��");
			
			this.repaint();
		}
		else if(e.getSource() == btnCofee5)
		{
			selCoffee=4;//5��Ŀ�Ǽ���
			imgSel = Toolkit.getDefaultToolkit().getImage("img/isaac_coffee.png");
			totCoin = coffeePrice[4];
			lbSelPrice.setText(totCoin+"��");
			lbSelTitle.setText(coffeeName[4]);
			lbCoin2.setText(totCoin+"��");
			this.repaint();
		}
		else if(e.getSource() == btnCofee6)
		{
			selCoffee=5;//6��Ŀ�Ǽ���
			imgSel = Toolkit.getDefaultToolkit().getImage("img/isaac_coffee.png");
			totCoin = coffeePrice[5];
			lbSelPrice.setText(totCoin+"��");
			lbSelTitle.setText(coffeeName[5]);
			lbCoin2.setText(totCoin+"��");
			this.repaint();
		}
		else if(e.getSource() == btn1000)
		{
			coin+=1000;
			lbJan2.setText(coin+"��");
		}
		else if(e.getSource() == btn5000)
		{
			coin+=5000;
			lbJan2.setText(coin+"��");
		}
		else if(e.getSource() == btn10000)
		{
			coin+=10000;
			lbJan2.setText(coin+"��");
		}
		else if(e.getSource() == btnAdmin)
		{
			MainAdmin11 ma = new MainAdmin11();
		}
		else if(e.getSource() == btnBuy)
		{
			//�ܾ��� �ּ� 3000���̻� ������쿡�� ����
			if(coin < 3000)
			{
				msg("�ּ�3000���̻� �ݾ��������ϼ���.");
				return;
			}
			//��ǰ���ø޼��� ���
			if(totCoin==0)
			{
				msg("������ Ŀ�Ǹ� �������ּ���.");
				return;
			}
			
			//����üũ �޼���
			countCheck(selCoffee);
			
			if(makeCheck==true)
			{			
				//������ Ŀ�� ����
				coin-=totCoin;
				//�����ȱݾ�ǥ��
				lbJan2.setText(coin+"��");		
				
				
				//����ǥ���ϱ�			
				try {
					lbSelTitle.setText("���ִ�");
					Thread.sleep(1000);
				} catch (InterruptedException e1) {	}
				try {
					lbSelTitle.setText("Ŀ�Ǹ�");
					Thread.sleep(1000);
				} catch (InterruptedException e1) {	}
				try {
					lbSelTitle.setText("�����մϴ�.");
					Thread.sleep(1000);
				} catch (InterruptedException e1) {	}
				
				imgSel = Toolkit.getDefaultToolkit().getImage("img/ing.gif");
				this.repaint();
			}
			else
			{
				makeCheck=true;
			}
			
			
		}	
	}
	void countCheck(int selCoffee)
	{
		if(coffeeCnt[selCoffee]==0)
		{
			msg("�����̾�� ���Ű��Ұ����մϴ�.");			
			makeCheck=false;
			return;
		}		
		if(selCoffee==0)
		{
			
			coffeeCnt[0]--;
			lbCoffee1Cnt.setText("���� "+coffeeCnt[0]+"��");
			
			
		}
		else if(selCoffee==1)
		{
			
			coffeeCnt[1]--;
			lbCoffee2Cnt.setText("���� "+coffeeCnt[1]+"��");
			
		}
		else if(selCoffee==2)
		{
			coffeeCnt[2]--;
			lbCoffee3Cnt.setText("���� "+coffeeCnt[2]+"��");
			
		}
		else if(selCoffee==3)
		{
			coffeeCnt[3]--;
			lbCoffee4Cnt.setText("���� "+coffeeCnt[3]+"��");
			
		}
		else if(selCoffee==4)
		{
			coffeeCnt[4]--;
			lbCoffee5Cnt.setText("���� "+coffeeCnt[4]+"��");
			
		}
		else if(selCoffee==5)
		{
			coffeeCnt[5]--;
			lbCoffee6Cnt.setText("���� "+coffeeCnt[5]+"��");
			
		}
		
		//�����ϴ� �޼��� ȣ��
		update(selCoffee+1, coffeeCnt[selCoffee]);
		
	}
	boolean update(int idx, int cnt)
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
		
		String query = "update japangi set cnt = ? where idx = ?";
	
		try {
			PreparedStatement pstmt = dc.prepareStatement(query);
			pstmt.setInt(1, cnt);
			pstmt.setInt(2, idx);		
			pstmt.executeUpdate();
			pstmt.close();
			msg("���ſϷ�!");
		} catch (SQLException ee) {
			System.err.println("�������� ����!!:"+ee.getMessage());
			return false;
		}
		return true;
	}
	void msg(String msg)
	{
		final Dialog dlg = new Dialog(this, "�˸� �޼���â", true);
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
		
	void getData()
	{
		try {
			Class.forName("org.gjt.mm.mysql.Driver");
		} catch (ClassNotFoundException ee) {
			System.out.println("����̺갡 ����ȵ�.");
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
				
				coffeeName[count] = rs.getString("name");
				coffeeCnt[count] = rs.getInt("cnt");
				coffeePrice[count] = rs.getInt("price");				
				count++;
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException ee) {
			System.err.println("error = " + ee.toString());
		}
	}

}
