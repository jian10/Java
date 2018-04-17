import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javafx.scene.shape.Line;

import javax.swing.JButton;
import javax.swing.JFrame;


public class DrawEx extends JFrame{

	MyListener lis;
	ArrayList list=new ArrayList();
	public DrawEx() {
		// TODO Auto-generated constructor stub
		setBounds(100,100,500,400);
		setLayout(new FlowLayout());
		lis=new MyListener();
		JButton btnLine=new JButton("Line");
		btnLine.addActionListener(lis);
		add(btnLine);
		
		addMouseListener(lis);
		addMouseMotionListener(lis);
		setVisible(true);//一定要将窗体设置为可见后才可以获取画笔对象
		lis.setGraphics(this.getGraphics());
		
		
	}
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
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
class MyListener implements ActionListener,MouseListener,MouseMotionListener{
	String command="Line";
	private int x1,x2;
	private int y1,y2;
	Graphics g;
	ArrayList list;
	public MyListener(Graphics g,ArrayList list) {
		// TODO Auto-generated constructor stub
		this.g=g;
		this.list=list;
	}
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		command= e.getActionCommand();
	}
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		x1=e.getX();
		y1=e.getY();
	}
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		x2=e.getX();
		y2=e.getY();
		if(command.equals("Line"))
		{
			g.drawLine(x1, y1, x2, y2);
			Line line=new Line(x1, y1, x2, y2);
			list.add(line);
		}
	}
	
}