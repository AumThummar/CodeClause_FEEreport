package fee_report;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class EditStudent extends JFrame implements ActionListener  
{
	JLabel l,lroll,l1,l2,l3,l4,l5,l6,l7,l8,l9,l10;
	JButton bt1,bt2;
	JPanel p1,p2;
	JTextField tf1,tf2,tf3,tf4,tf5,tf6,tf7,tf8,tf9,tf10;
	Font f,f1;
	Choice ch;
	
	EditStudent()
	{
		super("Edit Student Page");
		setLocation(100,100);
		setSize(800,600);
		
		l=new JLabel("Edit Student");
		l.setHorizontalAlignment(JLabel.CENTER);
		l.setForeground(Color.BLUE);
		
		lroll=new JLabel("Roll no.");
		lroll.setHorizontalAlignment(JLabel.CENTER);
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
	
		ch=new Choice();
		try
		{
			ConnectionClass obj=new ConnectionClass();
			String r="select roll from student";
			ResultSet rest=obj.stm.executeQuery(r);
			while(rest.next())
			{
				ch.add(rest.getString("roll"));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
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


		bt1=new JButton("Update Student");
		bt2=new JButton("Back");
		bt1.addActionListener(this);
		bt2.addActionListener(this);
		
		f=new Font("Ariel",Font.BOLD,20);
		f1=new Font("Ariel",Font.BOLD,15);
		l.setFont(f);
		lroll.setFont(f1);
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
		p2.setLayout(new GridLayout(13,2,10,10));
		p2.add(lroll);
		p2.add(ch);
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
		
		ch.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent arg0)
			{
				try
				{
					ConnectionClass obj1=new ConnectionClass();
					int rn=Integer.parseInt(ch.getSelectedItem());
					String s="select * from student where roll='"+rn+"'";
					ResultSet rest1=obj1.stm.executeQuery(s);
					while(rest1.next())
					{
						tf1.setText(rest1.getString("name"));
						tf2.setText(rest1.getString("email"));
						tf3.setText(rest1.getString("course"));
						tf4.setText(rest1.getString("fee"));
						tf5.setText(rest1.getString("paid"));
						tf6.setText(rest1.getString("address"));
						tf7.setText(rest1.getString("city"));
						tf8.setText(rest1.getString("State"));
						tf9.setText(rest1.getString("country"));
						tf10.setText(rest1.getString("phone"));
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
		int Roll=Integer.parseInt(ch.getSelectedItem());
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
		
		if(e.getSource()==bt1)
		{
			try
			{
				ConnectionClass obj2=new ConnectionClass();
				String q="update student set name='"+Name+"',email='"+Email+"',course='"+Course+"',fee='"+Fee+"',paid='"+Paid+"',address='"+Address+"',city='"+City+"',state='"+State+"',country='"+Country+"',phone='"+Phone+"' where roll='"+Roll+"'";
				int aa=obj2.stm.executeUpdate(q);
				if(aa==1)
				{
					JOptionPane.showMessageDialog(null, "Student updates successfully");
					this.setVisible(false);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Student not updated");
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
		new EditStudent().setVisible(true);
	}
}
