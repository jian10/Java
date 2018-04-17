import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class graphicEx extends JFrame{

	/**
	 * @param args
	 */
	public graphicEx() {
		// TODO Auto-generated constructor stub
		setSize(800,800);
//		JPanel mv=new JPanel();
//		mv.setBackground(Color.black);
//		getContentPane().add(mv);
//		add(mv);
		listener l=new listener();
		
		setLayout(new FlowLayout());
		String[] shapes={"Line","Rect","Oval"};
		for(int i=0;i<shapes.length;i++)
		{
			JButton btn=new JButton(shapes[i]);
			btn.addActionListener(l);
			add(btn);
		}
		addMouseListener(l);
		addMouseMotionListener(l);
		setResizable(false);
		setVisible(true);
		l.setGraphics(this.getGraphics());
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new graphicEx();
	}

}
class listener implements ActionListener,MouseListener,MouseMotionListener{

	Graphics g;
	String command="Line";
	int x1,y1;
	int x2,y2;
	void setGraphics(Graphics g){
		this.g=g;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		x1=e.getX();
		y1=e.getY();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		x2=e.getX();
		y2=e.getY();
		if(command.equals("Line")){
			
			g.drawLine(x1, y1, x2, y2);
		}
		if(command.equals("Rect")){
			g.drawRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x1-x2), Math.abs(y1-y2));
		}
		if(command.equals("Oval"))
		{
			g.drawOval(x1, y1, Math.abs(x1-x2), Math.abs(y1-y2));
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		command=e.getActionCommand();
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		if(command.equals("Line"))
		{
			x2=e.getX();
			y2=e.getY();
			g.drawLine(x1, y1, x2, y2);
			x1=x2;
			y1=y2;
		}
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}