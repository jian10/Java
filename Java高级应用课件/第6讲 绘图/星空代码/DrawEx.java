import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

class DrawPanel extends JPanel{
	
	 int x,y;
	public DrawPanel() {
		// TODO Auto-generated constructor stub
		addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mousePressed(e);
				x=e.getX();
				y=e.getY();
			}

			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseDragged(e);
				
			}
			
		});
	}
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		g.setColor(Color.WHITE);
		for(int i=0;i<200;i++)
		{
		g.drawString("*", (int)(Math.random()*1024), (int)(Math.random()*768));
		}
		
	}
	
}
public class DrawEx extends JFrame{

	/**
	 * @param args
	 */
	public DrawEx() {
		// TODO Auto-generated constructor stub
		setSize(1024,768);
		DrawPanel drawPanel=new DrawPanel();
		drawPanel.setBackground(Color.BLACK);
		drawPanel.repaint();
		add(drawPanel);
		setVisible(true);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new DrawEx();
	}

}
