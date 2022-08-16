package 자바26_윈도우프로그래밍_자판기;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Date;
public class japangi01{
	public static void main(String[] args) {
		Login7 l = new Login7();
	}
}
class Login7 extends Frame implements ActionListener{
	private Dimension dimen, dimen1;
	private int xpos, ypos;
	private Image img1;
	private Image img2;
	private Image img3;
	private Image img4;
	private Image img5;
	private Image img6;
	private Image img7;
	int tot1,tot2,tot3,tot4,tot5,tot6,tot7;
	int nowmoney, checkmoney, ordermoney;
	Label lbTitle = new Label("휴게소 음식메뉴");
	
	Label lb01 = new Label("수량 :");	
	Label lb02 = new Label("돈까스냉모밀 ");
	Button btn01 = new Button("9500원");
	
	Label lb03 = new Label("수량 :");
	Label lb04 = new Label("오징어야채덮밥");
	Button btn02 = new Button("8000원");
	
	Label lb05 = new Label("수량 :");
	Label lb06 = new Label("돈까스오므라이스 ");
	Button btn03 = new Button("9500원");
	
	Label lb07 = new Label("수량 :");
	Label lb08 = new Label("낙지덮밥 ");
	Button btn04 = new Button("8000원");
	
	Label lb09 = new Label("수량 :");
	Label lb10 = new Label("로제파스타");
	Button btn05 = new Button("7000원");
	
	Label lb11 = new Label("수량 :");
	Label lb12 = new Label("불꽃짬뽕");
	Button btn06 = new Button("7000원");
	
	Label lb13 = new Label("선택상품");
	
	Label lb14 = new Label("수량 :");
	Label lb15 = new Label("비빔냉면");
	Button btn07 = new Button("6500원");
	
	Label lb16 = new Label("투입금액");
	Button btn08 = new Button("1000원");
	Button btn09 = new Button("5000원");
	Button btn10 = new Button("10000원");
	Button btn11 = new Button("결제하기");
	
	Label lb17 = new Label("현재잔액: ");
	Label lb18 = new Label("결제금액: ");
	Font font20 = new Font("SansSerif", Font.BOLD, 20);
	Font font30 = new Font("SansSerif", Font.BOLD, 30);	
	
	Login7(){
		super("휴게소음식 메뉴화면");
		this.init();		
		this.setSize(1000,1000);
		this.center();//중앙배치		
		this.start();
		this.setVisible(true);
	}
	void start() {
		btn01.addActionListener(this);
		btn02.addActionListener(this);
		btn03.addActionListener(this);
		btn04.addActionListener(this);
		btn05.addActionListener(this);
		btn06.addActionListener(this);
		btn07.addActionListener(this);
		btn08.addActionListener(this);
		btn09.addActionListener(this);
		btn10.addActionListener(this);
		btn11.addActionListener(this);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		
		
		
	}
	void init()
	{

		
		this.setLayout(null); 		
		this.add(lbTitle); lbTitle.setFont(font30); 
		lbTitle.setBounds(300, 50, 400, 30);
		
		this.add(lb01); lb01.setFont(font20); 
		lb01.setBounds(50, 300, 130, 30);			
		this.add(lb02); lb02.setFont(font20); 
		lb02.setBounds(50, 350, 200, 30);
		this.add(btn01); btn01.setFont(font20); 
		btn01.setBounds(50, 400, 150, 30);
		
		this.add(lb03); lb03.setFont(font20); 
		lb03.setBounds(250, 300, 130, 30);		
		this.add(lb04); lb04.setFont(font20); 
		lb04.setBounds(250, 350, 200, 30);	
		this.add(btn02); btn02.setFont(font20); 
		btn02.setBounds(250, 400, 150, 30);
		
		this.add(lb05); lb05.setFont(font20); 
		lb05.setBounds(450, 300, 130, 30);
		this.add(lb06); lb06.setFont(font20); 
		lb06.setBounds(450, 350, 200, 30);
		this.add(btn03); btn03.setFont(font20); 
		btn03.setBounds(450, 400, 150, 30);
		
		this.add(lb07); lb07.setFont(font20); 
		lb07.setBounds(50, 650, 130, 30);
		this.add(lb08); lb08.setFont(font20); 
		lb08.setBounds(50, 700, 200, 30);
		this.add(btn04); btn04.setFont(font20); 
		btn04.setBounds(50, 750, 150, 30);
		
		this.add(lb09); lb09.setFont(font20); 
		lb09.setBounds(250, 650,130, 30);
		this.add(lb10); lb10.setFont(font20); 
		lb10.setBounds(250, 700, 200, 30);
		this.add(btn05); btn05.setFont(font20); 
		btn05.setBounds(250, 750, 150, 30);
		
		this.add(lb11); lb11.setFont(font20); 
		lb11.setBounds(450, 650, 130, 30);
		this.add(lb12); lb12.setFont(font20); 
		lb12.setBounds(450, 700, 200, 30);
		this.add(btn06); btn06.setFont(font20); 
		btn06.setBounds(450, 750, 150, 30);
		
		this.add(lb13); lb13.setFont(font30); 
		lb13.setBounds(700, 350, 150, 30);
		
		
		
		this.add(lb14); lb14.setFont(font20); 
		lb14.setBounds(700, 600, 150, 30);
		this.add(lb15); lb15.setFont(font20); 
		lb15.setBounds(700, 650, 150, 30);
		this.add(btn07); btn07.setFont(font20); 
		btn07.setBounds(700, 700, 150, 30);
		
		this.add(lb16); lb16.setFont(font20); 
		lb16.setBounds(50, 800, 150, 30);
		
		this.add(btn08); btn08.setFont(font20); 
		btn08.setBounds(50, 850, 150, 30);
		this.add(btn09); btn09.setFont(font20); 
		btn09.setBounds(250, 850, 150, 30);
		this.add(btn10); btn10.setFont(font20); 
		btn10.setBounds(450, 850, 150, 30);
		this.add(btn11); btn11.setFont(font20); 
		btn11.setBounds(700, 850, 150, 30);
		
		this.add(lb17); lb17.setFont(font20); 
		lb17.setBounds(150, 900, 200, 30);
		this.add(lb18); lb18.setFont(font20); 
		lb18.setBounds(500, 900, 200, 30);
		img1 = Toolkit.getDefaultToolkit().getImage("img01.jpg");
		img2 = Toolkit.getDefaultToolkit().getImage("img02.jpg");
		img3 = Toolkit.getDefaultToolkit().getImage("img03.jpg");
		img4 = Toolkit.getDefaultToolkit().getImage("img04.jpg");
		img5 = Toolkit.getDefaultToolkit().getImage("img05.jpg");
		img6 = Toolkit.getDefaultToolkit().getImage("img06.jpg");
		img7 = Toolkit.getDefaultToolkit().getImage("img07.jpg");
		
		
	}
	
	
	
	

	
	
	public void paint(Graphics g) {
		
		g.drawImage(img1, 50, 100, 170, 170, this);
		g.drawImage(img2, 250, 100, 170, 170, this);
		g.drawImage(img3, 450, 100, 170, 170, this);
		g.drawImage(img4, 50, 450, 170, 170, this);
		g.drawImage(img5, 250, 450, 170, 170, this);
		g.drawImage(img6, 450, 450, 170, 170, this);
		g.drawImage(img7, 700, 400, 170, 170, this);
			
}

	void center() {
		dimen = Toolkit.getDefaultToolkit().getScreenSize();
		dimen1 = this.getSize();
		xpos = (int) (dimen.getWidth() / 2 - dimen1.getWidth() / 2);
		ypos = (int) (dimen.getHeight() / 2 - dimen1.getHeight() / 2);
		this.setLocation(xpos, ypos);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==btn01) 	  {
			tot1++;
			lb01.setText("수량 : "+ tot1+"개");
			}
		if(e.getSource()==btn02) 	  {
			tot2++;
			lb03.setText("수량 : "+ tot2+"개");
			}
		if(e.getSource()==btn03) 	  {
			tot3++;
			lb05.setText("수량 : "+ tot3+"개");
			}
		if(e.getSource()==btn04) 	  {
			tot4++;
			lb07.setText("수량 : "+ tot4+"개");
			}
		if(e.getSource()==btn05) 	  {
			tot5++;
			lb09.setText("수량 : "+ tot5+"개");
			}
		if(e.getSource()==btn06) 	  {
			tot6++;
			lb11.setText("수량 : "+ tot6+"개");
			}
		if(e.getSource()==btn07) 	  {
			tot7++;
			lb14.setText("수량 : "+ tot7+"개");
			}
		
		if(e.getSource()==btn08) {
			nowmoney = nowmoney+1000;}
		if (e.getSource()==btn09) { 
			nowmoney = nowmoney+5000;}
		if (e.getSource()==btn10) {
			nowmoney = nowmoney+10000;}
		  lb17.setText("현재잔액 :"+ nowmoney+"원");
		
	if(e.getSource()==btn01) {
		ordermoney=ordermoney+9500;}
	if (e.getSource()==btn02) { 
		ordermoney=ordermoney+8000;}
	if (e.getSource()==btn03) {
		ordermoney=ordermoney+9500;}
	if (e.getSource()==btn04) {
		ordermoney=ordermoney+8000;}
	if (e.getSource()==btn05) {
		ordermoney=ordermoney+7000;}
	if (e.getSource()==btn06) {
		ordermoney=ordermoney+7000;}
	if (e.getSource()==btn07) {
		ordermoney=ordermoney+6500;}
	 lb18.setText("결제금액 :"+ ordermoney+"원");
	 
	 if (e.getSource()==btn11) {
	if(nowmoney>=ordermoney) {msg("결제가 완료되었습니다!!");}
	else
	{msg("잔액이 부족합니다!!");}
	}
}
	void msg(String msg)
	{
		final Dialog dlg = new Dialog(this, "알림 메세지창", true);
		dlg.setLayout(null);
		Label lbMsg = new Label(msg);
		
		dlg.add(lbMsg);	lbMsg.setFont(font20);
		lbMsg.setBounds(100, 100, 450, 30);
		
		dlg.setSize(450, 250);
		dlg.setLocation(700, 400);
		
		dlg.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dlg.setVisible(false);
			}
		});
		dlg.setVisible(true);
	}

}
			
		
		
		
		
		
		
		
		
		
	


