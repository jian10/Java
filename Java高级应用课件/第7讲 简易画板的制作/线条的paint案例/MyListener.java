import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

public class MyListener implements ActionListener,MouseListener,MouseMotionListener{
	String command="Line";
	private int x1,x2;
	private int y1,y2;
	private int oldx=x1;
	private int oldy=y1;
	Graphics g;
	
	Color color;
	public MyListener(Graphics g) {
		// TODO Auto-generated constructor stub
		this.g=g;
	}
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		command= e.getActionCommand();
	}
	public void mouseDragged(MouseEvent e) {
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
		System.out.println("press");
		x1=e.getX();
		y1=e.getY();
	}
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		//绘制直线，并且将直线存储在ArrayList对象中
		
	}
	
}