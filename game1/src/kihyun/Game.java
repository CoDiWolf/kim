package kihyun;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
public class Game extends JFrame {
 private static final long serialVersionUID = 1L;
 public static void main(String[] args) {
 Game UI = new Game();
 UI.IntUI();
 
 }
 //          ,    4*4     
 private int Numbers[][] = new int[4][4] ;
 private void IntUI() {
 this.setTitle("자바 발표물 2048 ");
 this.setLocation(450, 100);
 this.setSize(400, 500);
 this.setLayout(null);
 //       
 ImageIcon imgicon = new ImageIcon("src/play1.png");
 JButton bt = new JButton(imgicon);
 bt.setFocusable(false);
 bt.setBorderPainted(false);
 bt.setFocusPainted(false);
 bt.setContentAreaFilled(true);
 bt.setBounds(5, 10, 120, 30);//메뉴1      
 this.add(bt);
 //      
 ImageIcon backicon = new ImageIcon("src/return1.png");
 JButton back = new JButton(backicon);
 back.setFocusable(false);
 back.setBorderPainted(false);
 back.setFocusPainted(false);
 back.setContentAreaFilled(true);
 back.setBounds(250, 10, 120, 30);//메뉴3        
 this.add(back);
 //
 

     
 ImageIcon imgicon2 = new ImageIcon();
 JButton about = new JButton(imgicon2);
 about.setFocusable(false);
 about.setBorderPainted(false);
 about.setFocusPainted(false);
 about.setContentAreaFilled(false);
 about.setBounds(160, 10, 70, 30);
 this.add(about);
 //     
 JLabel lb = new JLabel("현재기록:0");
 lb.setBounds(40, 45, 120, 30);
 lb.setFont(new Font("  ", Font.CENTER_BASELINE, 18));
 lb.setForeground(new Color(0x000000));
 this.add(lb);
 //    
 Recorder.getRecording();
 int maxscore = Recorder.getMaxscore_2048();
 JLabel M=new JLabel("최고기록:0");
 M.setBounds(150,45,120,30);
 M.setFont(new Font("  ", Font.CENTER_BASELINE, 18));
 M.setForeground(new Color(0x000000));
 this.add(M);
 //  
 JCheckBox isSoundBox=new JCheckBox("  ");
 isSoundBox.setBounds(290, 45, 120, 30);
 isSoundBox.setFont(new Font("  ", Font.CENTER_BASELINE, 18));
 isSoundBox.setFocusable(false);
 isSoundBox.setBorderPainted(false);
 isSoundBox.setFocusPainted(false);
 isSoundBox.setContentAreaFilled(false);
 this.add(isSoundBox);
 this.setDefaultCloseOperation(3);
 this.setResizable(false);
 this.setVisible(false);//     
 //        
 MyListener cl = new MyListener(this,Numbers,lb,M, bt, about,back,isSoundBox);
 bt.addActionListener(cl);
 about.addActionListener(cl);
 back.addActionListener(cl);
 isSoundBox.addActionListener(cl);
 this.addKeyListener(cl);
 }
//     
 @Override
public void paint(Graphics g) {
 super.paint(g);
 g.setColor(new Color(0xBBADA0));
 g.fillRoundRect(15, 110, 370, 370, 15, 15);//     
 g.setColor(new Color(0xCDC1B4));
 for (int i = 0; i < 4; i++) {
 for (int j = 0; j < 4; j++) {
 g.fillRoundRect(25 + i * 90, 120 + j * 90, 80, 80, 15, 15);//     
 }
 }
 //           
 for (int i = 0; i < 4; i++) {
 for (int j = 0; j < 4; j++) {
 if (Numbers[j][i] != 0) {
 int FontSize = 30;
 int MoveX = 0, MoveY = 0;
 switch (Numbers[j][i]) {
 case 2:
 g.setColor(new Color(0xeee4da));
 FontSize = 30;
 MoveX = 0;
 MoveY = 0;
 break;
 case 4:
 g.setColor(new Color(0xede0c8));
 FontSize = 30;
 MoveX = 0;
 MoveY = 0;
 break;
 case 8:
 g.setColor(new Color(0xf2b179));
 FontSize = 30;
 MoveX = 0;
 MoveY = 0;
 break;
 case 16:
 g.setColor(new Color(0xf59563));
 FontSize = 29;
 MoveX = -5;
 MoveY = 0;
 break;
 case 32:
 g.setColor(new Color(0xf67c5f));
 FontSize = 29;
 MoveX = -5;
 MoveY = 0;
 break;
 case 64:
 g.setColor(new Color(0xf65e3b));
 FontSize = 29;
 MoveX = -5;
 MoveY = 0;
 break;
 case 128:
 g.setColor(new Color(0xedcf72));
 FontSize = 28;
 MoveX = -10;
 MoveY = 0;
 break;
 case 256:
 g.setColor(new Color(0xedcc61));
 FontSize = 28;
 MoveX = -10;
 MoveY = 0;
 break;
 case 512:
 g.setColor(new Color(0xedc850));
 FontSize = 28;
 MoveX = -10;
 MoveY = 0;
 break;
 case 1024:
 g.setColor(new Color(0xedc53f));
 FontSize = 27;
 MoveX = -15;
 MoveY = 0;
 break;
 case 2048:
 g.setColor(new Color(0xedc22e));
 FontSize = 27;
 MoveX = -15;
 MoveY = 0;
 break;
 default:
 g.setColor(new Color(0x000000));
 break;
 }
 g.fillRoundRect(25 + i * 90, 120 + j * 90, 80, 80, 15, 15);//       
 g.setColor(new Color(0x000000));
 g.setFont(new Font("Kristen ITC", Font.PLAIN, FontSize));
 g.drawString(Numbers[j][i] + "", 25 + i * 90 + 30 + MoveX,
 120 + j * 90 + 50 + MoveY);
 }
 }
 }
 }
}
