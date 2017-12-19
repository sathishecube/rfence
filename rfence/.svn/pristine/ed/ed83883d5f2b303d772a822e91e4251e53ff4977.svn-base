package rFence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
public class sqlcon
{
	public static ArrayList<String> main(String fName, int rCount )
    {
		
		ArrayList<String> a1 = new ArrayList<String>();
		try {
		    	
        		Class.forName("oracle.jdbc.driver.OracleDriver");
        		Connection con = DriverManager.
        		getConnection("jdbc:oracle:thin:@192.168.1.218:1521:ORCL","GP_RFENCE","gpindia");
        		Statement stmt = con.createStatement();
        		System.out.println("Created DB Connection....");
        		String query = "select * from fleet_geofence_version where fleet_name = '"+fName+"' ";
        		System.out.println(query);
        		ResultSet r = stmt.executeQuery(query);
        		
        		while(r.next())
        		{   
        			String Poly = r.getString(5);
        			System.out.println(Poly);
        			String c = r.getString(2);
        			System.out.println(c);
        			String c1= c.substring(c.length()-3);
        			System.out.println(c1);
        			String d = r.getString(4);
        			System.out.println(d);
        			String fleet = r.getString(3);
        			System.out.println(fleet);
        			Float p =Float.parseFloat(d);
        			System.out.println(p);
        			p = p*100;
        			System.out.println(p);
        			int q = p.intValue();
        			System.out.println(Math.ceil(p));
        			
        			System.out.println(q);
           			a1.add(c +"_" +"00"+q+"_"+"NR_Upgrade Commands.csv");
           			System.out.println(a1);
        			a1.add(c +"_" +"00"+q+"_"+"NR_"+Poly+".BIN");
        			System.out.println(a1);
        			a1.add(fleet +"_" +"R"+c1+"_"+"V"+q+"_"+rCount+".csv");
        			System.out.println(a1);
        	   		
        		}
        	
        	 } catch (ClassNotFoundException e) {
        		e.printStackTrace();
        		} catch (SQLException e) {
        			e.printStackTrace();
        		}
		return a1;
    }
}
