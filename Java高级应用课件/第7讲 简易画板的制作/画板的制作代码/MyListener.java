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
	ArrayList list;
	Color color;
	public MyListener(Graphics g,ArrayList list,Color color) {
		// TODO Auto-generated constructor stub
		this.g=g;
		this.list=list;
		this.color=color;
	}
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		command= e.getActionCommand();
	}
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("drag");
		g.setColor(color);
		g.drawLine(x1, y1, oldx, oldy);
		g.setColor(Color.black);
		g.drawLine(x1, y1, e.getX(), e.getY());
		oldx=e.getX();
		oldy=e.getY();
		
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
		x2=e.getX();
		y2=e.getY();//g.setColor(Color.black);
		if(command.equals("Line"))
		{
			g.drawLine(x1, y1, x2, y2);
			Line line=new Line(x1, y1, x2, y2);
			list.add(line);
		}
	}
	
}