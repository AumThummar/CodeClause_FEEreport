package fee_report;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class AddStudent extends JFrame implements ActionListener  
{
	JLabel l,l1,l2,l3,l4,l5,l6,l7,l8,l9,l10;
	JButton bt1,bt2;
	JPanel p1,p2;
	JTextField tf1,tf2,tf3,tf4,tf5,tf6,tf7,tf8,tf9,tf10;
	Font f,f1;
	
	AddStudent()
	{
		super("Add Student Page");
		setLocation(100,100);
		setSize(800,600);
		
		l=new JLabel("Add Student");
		l.setHorizontalAlignment(JLabel.CENTER);
		l.setForeground(Color.BLUE);
		
		l1=new JLabel("Name");
		l1.setHorizontalAlignment(JLabel.CENTER);
		l2=new JLabel("Emain");
		l2.setHorizontalAlignment(JLabel.CENTER);
		l3=new JLabel("Course");
		l3.setHorizontalAlignment(JLabel.CENTER);
		l4=new JLabel("Fee");
		l4.setHorizontalAlignment(JLabel.CENTER);
		l5=new JLabel("Paid");
		l5.setHorizontalAlignment(JLabel.CENTER);
		l6=new JLabel("Address");
		l6.setHorizontalAlignment(JLabel.CENTER);
		l7=new JLabel("City");
		l7.setHorizontalAlignment(JLabel.CENTER);
		l8=new JLabel("State");
		l8.setHorizontalAlignment(JLabel.CENTER);
		l9=new JLabel("Country");
		l9.setHorizontalAlignment(JLabel.CENTER);
		l10=new JLabel("Phone no.");
		l10.setHorizontalAlignment(JLabel.CENTER);
		
		tf1=new JTextField();
		tf2=new JTextField();
		tf3=new JTextField();
		tf4=new JTextField();
		tf5=new JTextField();
		tf6=new JTextField();
		tf7=new JTextField();
		tf8=new JTextField();
		tf9=new JTextField();
		tf10=new JTextField();

		bt1=new JButton("Add Student");
		bt2=new JButton("Back");
		bt1.addActionListener(this);
		bt2.addActionListener(this);
		
		f=new Font("Ariel",Font.BOLD,20);
		f1=new Font("Ariel",Font.BOLD,15);
		l.setFont(f);
		l1.setFont(f1);
		l2.setFont(f1);
		l3.setFont(f1);
		l4.setFont(f1);
		l5.setFont(f1);
		l6.setFont(f1);
		l7.setFont(f1);
		l8.setFont(f1);
		l9.setFont(f1);
		l10.setFont(f1);
		bt1.setFont(f1);
		bt2.setFont(f1);
		tf1.setFont(f1);
		tf2.setFont(f1);
		tf3.setFont(f1);
		tf4.setFont(f1);
		tf5.setFont(f1);
		tf6.setFont(f1);
		tf7.setFont(f1);
		tf8.setFont(f1);
		tf9.setFont(f1);
		tf10.setFont(f1);

		
		p1=new JPanel();
		p1.setLayout(new GridLayout(1,1,10,10));
		p1.add(l);
		
		p2=new JPanel();
		p2.setLayout(new GridLayout(11,2,10,10));
		p2.add(l1);
		p2.add(tf1);
		p2.add(l2);
		p2.add(tf2);
		p2.add(l3);
		p2.add(tf3);
		p2.add(l4);
		p2.add(tf4);
		p2.add(l5);
		p2.add(tf5);
		p2.add(l6);
		p2.add(tf6);
		p2.add(l7);
		p2.add(tf7);
		p2.add(l8);
		p2.add(tf8);
		p2.add(l9);
		p2.add(tf9);
		p2.add(l10);
		p2.add(tf10);
		p2.add(bt1);
		p2.add(bt2);
		
		setLayout(new BorderLayout(10,10));
		
		add(p1,"North");
		add(p2,"Center");
		
	}
	
	public void actionPerformed(ActionEvent e)
	{
		
		if(e.getSource()==bt1)
		{
			String Name=tf1.getText();
			String Email=tf2.getText();
			String Course=tf3.getText();
			float Fee=Float.parseFloat(tf4.getText());
			float Paid=Float.parseFloat(tf5.getText());
			String Address=tf6.getText();
			String City=tf7.getText();
			String State=tf8.getText();
			String Country=tf9.getText();
			String Phone=tf10.getText();
			try
			{
				ConnectionClass obj=new ConnectionClass();
				String q="insert into student(name,email,course,fee,paid,address,city,state,country,phone) values('"+Name+"','"+Email+"','"+Course+"','"+Fee+"','"+Paid+"','"+Address+"','"+City+"','"+State+"','"+Country+"','"+Phone+"')";
				int aa=obj.stm.executeUpdate(q);
				if(aa==1)
				{
					JOptionPane.showMessageDialog(null, "Student added successfully");
					this.setVisible(false);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Student not added");
					this.setVisible(true);
				}
			}
			catch(Exception ee)
			{
				ee.printStackTrace();
			}
		}
		if(e.getSource()==bt2) 
		{
			this.setVisible(false);
			new AccountantSection().setVisible(true);
		}
		
	}
	
	public static void main(String[] args)
	{
		new AddStudent().setVisible(true);
	}
}
