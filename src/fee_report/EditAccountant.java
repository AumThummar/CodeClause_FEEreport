package fee_report;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class EditAccountant extends JFrame implements ActionListener 
{
	JLabel l,l1,l2,l3,l4,l5,l6;
	JButton bt1,bt2;
	JPanel p1,p2;
	JTextField tf2,tf4,tf5,tf6;
	JPasswordField pf;
	Font f,f1;
	Choice ch;
	
	EditAccountant()
	{
		super("Edit Accountant Page");
		setLocation(100,100);
		setSize(800,600);
		
		l=new JLabel("Edit Accountant");
		l.setHorizontalAlignment(JLabel.CENTER);
		l.setForeground(Color.BLUE);
		
		l1=new JLabel("Employment Id");
		l1.setHorizontalAlignment(JLabel.CENTER);
		l2=new JLabel("Name");
		l2.setHorizontalAlignment(JLabel.CENTER);
		l3=new JLabel("Password");
		l3.setHorizontalAlignment(JLabel.CENTER);
		l4=new JLabel("Email");
		l4.setHorizontalAlignment(JLabel.CENTER);
		l5=new JLabel("Phone no.");
		l5.setHorizontalAlignment(JLabel.CENTER);
		l6=new JLabel("Address");
		l6.setHorizontalAlignment(JLabel.CENTER);
		
		ch=new Choice();
		try
		{
			ConnectionClass obj=new ConnectionClass();
			String id="select empid from accountant";
			ResultSet rest=obj.stm.executeQuery(id);
			while(rest.next())
			{
				ch.add(rest.getString("empid"));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		tf2=new JTextField();
		tf4=new JTextField();
		tf5=new JTextField();
		tf6=new JTextField();

		pf=new JPasswordField();
		
		bt1=new JButton("Update Accountant");
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
		bt1.setFont(f1);
		bt2.setFont(f1);
		tf4.setFont(f1);
		tf5.setFont(f1);
		tf6.setFont(f1);
		pf.setFont(f1);
		
		p1=new JPanel();
		p1.setLayout(new GridLayout(1,1,10,10));
		p1.add(l);
		
		p2=new JPanel();
		p2.setLayout(new GridLayout(7,2,10,10));
		p2.add(l1);
		p2.add(ch);
		p2.add(l2);
		p2.add(tf2);
		p2.add(l3);
		p2.add(pf);
		p2.add(l4);
		p2.add(tf4);
		p2.add(l5);
		p2.add(tf5);
		p2.add(l6);
		p2.add(tf6);
		p2.add(bt1);
		p2.add(bt2);
		
		setLayout(new BorderLayout(10,10));
		
		add(p1,"North");
		add(p2,"Center");
		
		ch.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent arg0)
			{
				try
				{
					ConnectionClass obj1=new ConnectionClass();
					int emp=Integer.parseInt(ch.getSelectedItem());
					String s="select * from accountant where empid='"+emp+"'";
					ResultSet rest1=obj1.stm.executeQuery(s);
					while(rest1.next())
					{
						tf2.setText(rest1.getString("name"));
						pf.setText(rest1.getString("password"));
						tf4.setText(rest1.getString("email"));
						tf5.setText(rest1.getString("phone"));
						tf6.setText(rest1.getString("address"));
					}
				}
				catch(Exception ee)
				{
					ee.printStackTrace();
				}
			}
		});

	}
	
	public void actionPerformed(ActionEvent e)
	{
		int EmpId=Integer.parseInt(ch.getSelectedItem());
		String Name=tf2.getText();
		char[] Password=pf.getPassword();
		String Email=tf4.getText();
		String Phone=tf5.getText();
		String Address=tf6.getText();
		
		if(e.getSource()==bt1)
		{
			try
			{
				ConnectionClass obj2=new ConnectionClass();
				String q="update accountant set password='"+String.valueOf(Password)+"',email='"+Email+"',phone='"+Phone+"',address='"+Address+"' where name='"+Name+"'";
				int aa=obj2.stm.executeUpdate(q);
				if(aa==1)
				{
					JOptionPane.showMessageDialog(null, "Accountant updates successfully");
					this.setVisible(false);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Accountant not updated");
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
		new EditAccountant().setVisible(true);
	}

}
