import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


public class Demo9{	
	public static void main(String[] argc){
		newframe();
	}
	public static void newframe(){
		final JFrame frame = new JFrame("选择题");
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setBounds(600, 200, 400, 600);	
		frame.setResizable(false);
		Label timu[] = new Label[5];
		for(int i=0;i<timu.length;i++){
			timu[i] = new Label("第"+String.valueOf(i+1)+"题"+":  ");
			frame.add(timu[i]);
			timu[i].setBounds(10, 50*(i+1),50, 20);	
		}
		//定义四个选项ABCD，建5组这样的按钮
		final JRadioButton A[] = new JRadioButton[5];
		for(int i=0;i<A.length;i++){
			A[i] = new JRadioButton("A:XX");
			A[i].setBounds(100, 50*(i+1),53, 20);
		}		
		
		JRadioButton B[] = new JRadioButton[5];
		for(int i=0;i<B.length;i++){
			B[i] = new JRadioButton("B:XX");
			B[i].setBounds(150, 50*(i+1),53, 20);
			B[i].setVisible(true);
		}	
		
		JRadioButton C[] = new JRadioButton[5];
		for(int i=0;i<C.length;i++){
			C[i] = new JRadioButton("C:XX");	
			C[i].setBounds(200, 50*(i+1),53, 20);
			C[i].setVisible(true);
		}
		
		JRadioButton D[] = new JRadioButton[5];
		for(int i=0;i<D.length;i++){
			D[i] = new JRadioButton("D:XX");	
			D[i].setBounds(250, 50*(i+1),53, 20);
			D[i].setVisible(true);
		}
		//给ABCD分组
		ButtonGroup group_ABCD[] = new ButtonGroup[5];	
		for(int i=0;i<group_ABCD.length;i++){
			group_ABCD[i] = new ButtonGroup();
			group_ABCD[i].add(A[i]);
			group_ABCD[i].add(B[i]);
			group_ABCD[i].add(C[i]);
			group_ABCD[i].add(D[i]);
		}
		//将选项按钮加入到容器中
		Container com = new Container();
		com = frame.getContentPane();
		com.setLayout(new FlowLayout());	
		for(int i=0;i<5;i++){
			frame.add(timu[i]);
			com.add(A[i]);
			com.add(B[i]);
			com.add(C[i]);		
			com.add(D[i]);
		}
		//按钮  重新答题
		JButton chongxindati = new JButton("重新答题");
		chongxindati.setBounds(70, 400, 100, 25);		
		JButton tijiao = new JButton("提交");
		frame.add(chongxindati);
		chongxindati.addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent e) {			
			}
			public void mousePressed(MouseEvent e) {
			}
			public void mouseExited(MouseEvent e) {
			}
			public void mouseEntered(MouseEvent e) {
			}	
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				newframe();
			}
		});
		//按钮  提交
		tijiao.setBounds(250,400,100,25);
		frame.add(tijiao);	
		tijiao.addMouseListener(new MouseListener() {	
			public void mouseReleased(MouseEvent e) {
			}
			public void mousePressed(MouseEvent e) {
			}
			public void mouseExited(MouseEvent e) {
			}
			public void mouseEntered(MouseEvent e) {
			}
			public void mouseClicked(MouseEvent e) {
				int n = 0;
				JTextField shuchu = new JTextField();
				frame.add(shuchu);
				if(A[1].isSelected()){
					n++;
					}	
				shuchu.setBounds(250, 465, 50, 25);
				shuchu.setText(String.valueOf(n));
				frame.repaint();
			}
		});
		JLabel truenumber = new JLabel("正确答题数:");
		truenumber.setBounds(70, 450, 200,50);
		truenumber.setForeground(Color.red);
		truenumber.setFont(new Font("仿宋",Font.BOLD,20));
		frame.add(truenumber);
		frame.repaint();
	}
}
