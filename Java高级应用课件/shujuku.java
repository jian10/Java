import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;


public class shujuku extends JFrame{
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	JPanel panel_1;
	Connection con;
	private JTable table;
	/**
	 * @param args
	 */
	public shujuku() {
		// TODO Auto-generated constructor stub
		setBounds(100,100,300,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("客户信息管理");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost/SPGL","root","123456");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("客户添加", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("客户名称");
		lblNewLabel.setBounds(10, 35, 54, 15);
		panel.add(lblNewLabel);
		
		JLabel label = new JLabel("\u5BA2\u6237\u5730\u5740");
		label.setBounds(10, 96, 54, 15);
		panel.add(label);
		
		textField = new JTextField();
		textField.setBounds(92, 32, 66, 21);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(92, 93, 66, 21);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JButton button = new JButton("\u6DFB\u52A0");
		button.setBounds(0, 143, 93, 23);
		panel.add(button);
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try {
					Statement st=con.createStatement();
					ResultSet rs=st.executeQuery("select * from client where ClientName='"+textField.getText()+"'and Clientaddr='"+textField_1.getText()+"'");
					System.out.println("select * from client where ClientName='"+textField.getText()+"'and Clientaddr='"+textField_1.getText()+"'");
					if(textField.getText().equals("")||textField_1.getText().equals("")){
						JOptionPane.showMessageDialog(null, "客户名与客户地址不能为空！");
					}
					else if (rs.next()) {
						JOptionPane.showMessageDialog(null, "该客户已存在！");
					}
					else {
						int rs1=st.executeUpdate("insert into client(ClientName,Clientaddr) values('"+textField.getText()+"','"+textField_1.getText()+"')");
						System.out.println("insert client(ClientName,Clientaddr) values('"+textField.getText()+"','"+textField_1.getText()+"')");
						JOptionPane.showMessageDialog(null, "客户添加成功！");
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		
		JButton button_1 = new JButton("\u91CD\u586B");
		button_1.setBounds(127, 143, 93, 23);
		panel.add(button_1);
		button_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				textField.setText("");
				textField_1.setText("");
			}
		});
		
		panel_1 = new JPanel();
		tabbedPane.addTab("客户查询", null, panel_1, null);
		panel_1.setLayout(null);
		
		textField_2 = new JTextField();
		textField_2.setBounds(10, 37, 66, 21);
		panel_1.add(textField_2);
		textField_2.setColumns(10);
		
		JButton button_2 = new JButton("\u67E5\u8BE2");
		button_2.setBounds(105, 36, 93, 23);
		panel_1.add(button_2);
		
		
		button_2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Vector v=new Vector();
				v.add("Clientcode");
				v.add("ClientName");
				v.add("Clientaddr");
				Vector v1=new Vector();
				Statement st;
				try {
					st = con.createStatement();
					ResultSet rs=st.executeQuery("select * from client where ClientName like '%"+textField_2.getText()+"%'");
					System.out.println("select * from client where ClientName like '%"+textField_2.getText()+"%'");
					while (rs.next()) {
						Vector v2=new Vector();
						v2.add(rs.getString(1));
						v2.add(rs.getString(2));
						v2.add(rs.getString(3));
						v1.add(v2);
						
					}
					
					
					JTable table=new JTable(v1,v);
					JScrollPane scrollPane=new JScrollPane(table);
					scrollPane.setBounds(10, 85, 200, 100);
					panel_1.add(scrollPane);
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new shujuku();
	}
}
