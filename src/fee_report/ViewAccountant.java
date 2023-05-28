package fee_report;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class ViewAccountant extends JFrame 
{
	String x[]= {"Employment ID","Name","Password","Email","Phone no.","Address"};
	String y[][]=new String[50][6];
	int i=0,j=0;
	JTable t;
	Font f,f1;
	
	ViewAccountant()
	{
		super("Accountant Information");
		setSize(800,400);
		setLocation(100,100);
		
		f=new Font("Ariel",Font.BOLD,15);
		
		try
		{
			ConnectionClass obj=new ConnectionClass();
			String p="select * from accountant";
			ResultSet rest=obj.stm.executeQuery(p);
			while(rest.next())
			{
				y[i][j++]=rest.getString("empid");
				y[i][j++]=rest.getString("name");
				y[i][j++]=rest.getString("password");
				y[i][j++]=rest.getString("email");
				y[i][j++]=rest.getString("phone");
				y[i][j++]=rest.getString("address");
				i++;
				j=0;
			}
			
			t=new JTable(y,x);
			t.setFont(f);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		JScrollPane sp=new JScrollPane(t);
		add(sp);
	}
	
	public static void main(String[] args)
	{
		new ViewAccountant().setVisible(true);
	}

}
