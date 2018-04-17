import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;



import javax.swing.JButton;
import javax.swing.JFrame;


public class DrawEx extends JFrame{
//	Graphics g;
//	MyListener lis;
	ArrayList list=new ArrayList();
	public DrawEx() {
		// TODO Auto-generated constructor stub
		setBounds(100,100,500,400);
		setLayout(new FlowLayout());
		setVisible(true);//一定要将窗体设置为可见后才可以获取画笔对象
		Color color=getContentPane().getBackground();
		JButton btnLine=new JButton("Line");
		MyListener lis=new MyListener(getGraphics(),list,color);;
		add(btnLine);
		btnLine.addActionListener(lis);
		addMouseListener(lis);
		addMouseMotionListener(lis);
	}
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		for(int i=0;i<list.size();i++)
		{
			Line line=(Line)list.get(i);
			g.drawLine(line.x1, line.y1, line.x2, line.y2);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new DrawEx();
	}

}
