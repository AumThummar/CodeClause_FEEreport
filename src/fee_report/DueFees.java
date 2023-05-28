package fee_report;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class DueFees extends JFrame 
{
	String x[]= {"Roll no.","Name","Email","Course","Fee","Paid","Due","Address","City","State","Country","Phone no."};
	String y[][]=new String[50][12];
	int i=0,j=0;
	JTable t;
	Font f,f1;
	
	DueFees()
	{
		super("Due Fees Information");
		setSize(1400,500);
		setLocation(100,100);
		
		f=new Font("Ariel",Font.BOLD,15);
		
		try
		{
			ConnectionClass obj=new ConnectionClass();
			String p="select * from student where due>0";
			ResultSet rest=obj.stm.executeQuery(p);
			while(rest.next())
			{
				y[i][j++]=rest.getString("roll");
				y[i][j++]=rest.getString("name");
				y[i][j++]=rest.getString("email");
				y[i][j++]=rest.getString("course");
				y[i][j++]=rest.getString("fee");
				y[i][j++]=rest.getString("paid");
				y[i][j++]=rest.getString("due");
				y[i][j++]=rest.getString("address");
				y[i][j++]=rest.getString("city");
				y[i][j++]=rest.getString("state");
				y[i][j++]=rest.getString("country");
				y[i][j++]=rest.getString("phone");
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
		new DueFees().setVisible(true);
	}

}
