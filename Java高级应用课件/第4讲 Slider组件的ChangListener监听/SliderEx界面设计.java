import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class SliderEx extends JFrame{

	/**
	 * @param args
	 */
	public SliderEx(){
		JPanel jpCenter=new JPanel();
		JLabel jlR=new JLabel("R");
		JSlider jsR=new JSlider(0,255,127);
		JTextField jtfR=new JTextField("127");
		jpCenter.add(jlR);
		jpCenter.add(jsR);
		jpCenter.add(jtfR);
		JLabel jlG=new JLabel("G");
		JSlider jsG=new JSlider(0,255,127);
		JTextField jtfG=new JTextField("127");
		jpCenter.add(jlG);
		jpCenter.add(jsG);
		jpCenter.add(jtfG);
		JLabel jlB=new JLabel("B");
		JSlider jsB=new JSlider(0,255,127);
		JTextField jtfB=new JTextField("127");
		jpCenter.add(jlB);
		jpCenter.add(jsB);
		jpCenter.add(jtfB);
		getContentPane().add(jpCenter,BorderLayout.CENTER);
		JPanel jpColor =new JPanel();
		JTextArea jtaColor=new JTextArea(5,10);
		jpColor.add(jtaColor);
		getContentPane().add(jpColor,BorderLayout.EAST);
		setBounds(100,100,380,171);
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new SliderEx();
	}

}
