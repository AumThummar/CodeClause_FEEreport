package fee_report;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class AddAccountant extends JFrame implements ActionListener 
{
	JLabel l,l1,l2,l3,l4,l5,i;
	JButton bt1,bt2;
	JPanel p1,p2,p3;
	JTextField tf1,tf2,tf3,tf4;
	JPasswordField pf;
	Font f,f1;
	
	
	
	AddAccountant()
	{
		super("Add Accountant Page");
		setLocation(100,100);
		setSize(600,400);
		
		l=new JLabel("Add Accountant");
		l.setHorizontalAlignment(JLabel.CENTER);
		l.setForeground(Color.BLUE);
		
		l1=new JLabel("Name");
		l1.setHorizontalAlignment(JLabel.CENTER);
		l2=new JLabel("Password");
		l2.setHorizontalAlignment(JLabel.CENTER);
		l3=new JLabel("Email");
		l3.setHorizontalAlignment(JLabel.CENTER);
		l4=new JLabel("Phone no.");
		l4.setHorizontalAlignment(JLabel.CENTER);
		l5=new JLabel("Address");
		l5.setHorizontalAlignment(JLabel.CENTER);
		
		tf1=new JTextField();
		tf2=new JTextField();
		tf3=new JTextField();
		tf4=new JTextField();
		
		pf=new JPasswordField();
		
		bt1=new JButton("Add Accountant");
		bt2=new JButton("Back");
		bt1.addActionListener(this);
		bt2.addActionListener(this);
		
		ImageIcon icn=new ImageIcon(ClassLoader.getSystemResource("fee_report/icons/AddAccountant.png"));
		Image icn2=icn.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT); 
		ImageIcon icn3=new ImageIcon(icn2);
		i=new JLabel(icn3); 
		
		f=new Font("Ariel",Font.BOLD,20);
		f1=new Font("Ariel",Font.BOLD,15);
		l.setFont(f);
		l1.setFont(f1);
		l2.setFont(f1);
		l3.setFont(f1);
		l4.setFont(f1);
		l5.setFont(f1);
		bt1.setFont(f1);
		bt2.setFont(f1);
		tf1.setFont(f1);
		tf2.setFont(f1);
		tf3.setFont(f1);
		tf4.setFont(f1);
		pf.setFont(f1);
		
		p1=new JPanel();
		p1.setLayout(new GridLayout(1,1,10,10));
		p1.add(l);
		
		p2=new JPanel();
		p2.setLayout(new GridLayout(6,2,10,10));
		p2.add(l1);
		p2.add(tf1);
		p2.add(l2);
		p2.add(pf);
		p2.add(l3);
		p2.add(tf2);
		p2.add(l4);
		p2.add(tf3);
		p2.add(l5);
		p2.add(tf4);
		p2.add(bt1);
		p2.add(bt2);
		
		p3=new JPanel();
		p3.setLayout(new GridLayout(1,1,10,10));
		p3.add(i);
		
		setLayout(new BorderLayout(10,10));
		
		add(p1,"North");
		add(p2,"Center");
		add(p3,"East");
		
		
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==bt1)
		{
			String Name=tf1.getText();
			String Password=String.valueOf(pf.getPassword());
			String Email=tf2.getText();
			String Phone=tf3.getText();
			String Address=tf4.getText();
			try
			{
				ConnectionClass obj=new ConnectionClass();
				String q="insert into accountant(name,password,email,phone,address) values('"+Name+"','"+Password+"','"+Email+"','"+Phone+"','"+Address+"')";
				int a=obj.stm.executeUpdate(q);
				if(a==1)
				{
					JOptionPane.showMessageDialog(null, "Accountant added successfully");
					this.setVisible(false);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Accountant not added");
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
			new AdminSection().setVisible(true);
		}
	}
	public static void main(String[] args)
	{
		new AddAccountant().setVisible(true);
	}
}
