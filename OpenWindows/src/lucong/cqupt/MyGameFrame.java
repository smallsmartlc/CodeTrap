package lucong.cqupt;


import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

import lucong.cqupt.MyGameFrame.PaintThread;




	
 public class MyGameFrame extends Frame{
	 Image success1 = GameUtil.getImage("images/success .png");
	 Black black1 = new Black(100,150,100,100);
	 Black black2 = new Black(200,150,100,100);
	 Black black3 = new Black(300,150,100,100);
	 Black black4 = new Black(100,250,100,100);
	 Black black5 = new Black(200,250,100,100);
	 Black black6 = new Black(300,250,100,100);
	 Black black7 = new Black(100,350,100,100);
	 Black black8 = new Black(200,350,100,100);
	 Black black9 = new Black(300,350,100,100);
	 JButton restart = new JButton("���¿�ʼ");	 
	 public void paint(Graphics g) {
		 g.drawImage(success1, 100, 150, null); 
		 Font f = g.getFont();
		 g.setFont(new Font("����", Font.CENTER_BASELINE, 20));
		g.drawString("��Ϸ�����ü����ϵ�qweasdzxc", 100, 100);
		g.drawString("�ֱ����һ���촰", 100, 120);
		g.setFont(f);
		//for(int i=0;i<blacks.length;i++) {
		 if(black1.live) {black1.draw(g);}
		 if(black2.live) {black2.draw(g);}
		 if(black3.live) {black3.draw(g);}
		 if(black4.live) {black4.draw(g);}
		 if(black5.live) { black5.draw(g);}
		 if(black6.live) { black6.draw(g);}
		 if(black7.live) { black7.draw(g);}
		 if(black8.live) { black8.draw(g);}
		 if(black9.live) { black9.draw(g);}
		 //}
		 Color c = g.getColor();
		 g.setColor(Color.red);
		 g.setFont(new Font("����", Font.BOLD, 40));
		 if(!black1.live&!black2.live&!black3.live&!black4.live&!black5.live&!black6.live&!black7.live&!black8.live&!black9.live)
			{
			 g.drawString("��Ӯ�ˣ�����", 100, 500);
				repaint();
			}
	g.setColor(c);
	 }
	 	
		class  PaintThread  extends  Thread  {
			//����ˢ��ҳ��ﵽ����Ч��,������δʹ��
			public void run() {
				while(true){
					repaint();		//�ػ�
					
					try {
						Thread.sleep(40);   	//1s=1000ms
					} catch (InterruptedException e) {
						e.printStackTrace();
					}		
				}
			}
			
		}
	 
 public static void main(String[] args) {
		// TODO Auto-generated method stub
	 MyGameFrame  f = new MyGameFrame();
		f.launchFrame();
}
 class KeyMonitor extends KeyAdapter{

	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_Q:{
			black1.live=!black1.live;
			black2.live=!black2.live;
			black4.live=!black4.live;
			repaint();
		}break;
		case KeyEvent.VK_W:{
			black1.live=!black1.live;
			black2.live=!black2.live;
			black3.live=!black3.live;
			black5.live=!black5.live;
			repaint();
		}break;
		case KeyEvent.VK_E:{
			black3.live=!black3.live;
			black2.live=!black2.live;
			black6.live=!black6.live;
			repaint();	
		}break;
		case KeyEvent.VK_A:{
			black1.live=!black1.live;
			black4.live=!black4.live;
			black5.live=!black5.live;
			black7.live=!black7.live;
			repaint();
		}break;
		case KeyEvent.VK_S:{
			black2.live=!black2.live;
			black4.live=!black4.live;
			black5.live=!black5.live;
			black6.live=!black6.live;
			black8.live=!black8.live;
			repaint();
		}break;
		case KeyEvent.VK_D:{
			black3.live=!black3.live;
			black5.live=!black5.live;
			black6.live=!black6.live;
			black9.live=!black9.live;
			repaint();
		}break;
		case KeyEvent.VK_Z:{
			black4.live=!black4.live;
			black7.live=!black7.live;
			black8.live=!black8.live;
			repaint();
		}break;
		case KeyEvent.VK_X:{
			black5.live=!black5.live;
			black7.live=!black7.live;
			black8.live=!black8.live;
			black9.live=!black9.live;
			repaint();
		}break;
		case KeyEvent.VK_C:{
			black6.live=!black6.live;
			black8.live=!black8.live;
			black9.live=!black9.live;
			repaint();
		}break;

}	
		

	}
	 
 }
 public void launchFrame() {
		this.setTitle("smallsmart");//���ñ���
		this.setVisible(true);//��ʼ��
		this.setSize(Constant.GAME_WIDTH, Constant.GAME_HEIGHT);//���ô��ڳߴ�
		this.setLocation(500, 100);//���ô���λ��
		//this.setBounds(500, 200, 500, 500);//ͬʱ���ô��ڳߴ��봰��λ��


		int d1;
		double d =Math.random()*9;
		for(int i=0;i<d;i++) {
			d1 = (int)(Math.random()*9);
			if(d1==0) black1.live=false;
			if(d1==1) black2.live=false;
			if(d1==2) black3.live=false;
			if(d1==3) black4.live=false;
			if(d1==4) black5.live=false;
			if(d1==5) black6.live=false;
			if(d1==6) black7.live=false;
			if(d1==7) black8.live=false;
			if(d1==8) black9.live=false;
		}
		this.addWindowListener(new WindowAdapter() {//�����ڲ���
			@Override
			public void windowClosing(WindowEvent e) {
			System.exit(0);
			}//���õ�����Ͻ�x��ʱ��رճ���
		});
		//new PaintThread().start();	
addKeyListener(new KeyMonitor());
 }
 private Image offScreenImage = null;
 
	public void update(Graphics g) {
	    if(offScreenImage == null)
	        offScreenImage = this.createImage(Constant.GAME_WIDTH,Constant.GAME_HEIGHT);//������Ϸ���ڵĿ�Ⱥ͸߶�
	     
	    Graphics gOff = offScreenImage.getGraphics();
	    paint(gOff);
	    g.drawImage(offScreenImage, 0, 0, null);
	}
 }
 