import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JFrame;


public class Test extends JFrame{

	/**
	 * @param args
	 */
	public Test() {
		// TODO Auto-generated constructor stub
		setVisible(true);
		setBounds(30,30,300,400);
	}
	@Override
	public void paint(Graphics arg0) {
		// TODO Auto-generated method stub
		super.paint(arg0);
		ArrayList list=new ArrayList();
		Line line1=new Line(20, 1, 200, 200);
		list.add(line1);
		Line l1=(Line)list.get(0);
		
		Graphics g=getGraphics();
		g.drawLine(l1.x1, l1.y1, l1.x2,l1.y2);
		
		
	}
	public static void main(String[] args) {
		new Test();
		// TODO Auto-generated method stub
//		ArrayList list=new ArrayList();
//		list.add("stu1");
//		list.add("stu2");
//		list.add("stu3");
//		list.add("stu4");
//		System.out.println("队列list的长度是："+list.size());
//		System.out.println("第2位是："+list.get(1));
//		Rect rect1=new Rect(1, 1, 2, 2);
//		list.add(rect1);
//		System.out.println(list.get(0));
//		Rect r=(Rect)list.get(0);
//		System.out.println("矩形1起始点的x坐标是："+r.y2);
//		
//		Rect rect2=new Rect(10, 10, 30, 40);
////		list.add(rect2);
//		Line line1=new Line(20, 1, 200, 200);
//		list.add(line1);
//		Line l1=(Line)list.get(0);
		
	}

}
