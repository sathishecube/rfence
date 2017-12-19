package rFence;

import java.util.Map;
import java.util.TreeMap;

import org.testng.annotations.Test;

public class Mainfn
{
	@Test
	public void testing() throws Exception
	{
		long stime=System.currentTimeMillis();
		RfenceSupport s = new RfenceSupport();
		String [][] input = s.readData("\\\\AMXSERVER\\amx-share\\STW_QA\\rFence Automation\\Test Data.xls",0);
		int flag=0;
		String filename=null;
		
		//Creating map to store elements
		Map<String, Object[]> data   = new TreeMap<String, Object[]>();
		Map<String, Object[]> data1  = new TreeMap<String, Object[]>();
		Map<String, Object[]> datafin  = new TreeMap<String, Object[]>();
		
		//output rows
		int rc=101;
		data.put(""+rc, new Object[] {"TC No", "Module", "Description", "Expected Result", "Actual Result", "Status", "Execution Time(Sec.)"});
		System.out.println(input.length);
		
		for(int i=0;i<input.length;i++)
		{
			if(input[i][0].equalsIgnoreCase("Login"))
			{
				if(input[i][3].equalsIgnoreCase("Y"))
					
				{
					Login l = new Login();
					data=l.log(data, rc);
					rc=rc+data.size();
					flag=1;
				}
			}
			if(input[i][0].equalsIgnoreCase("Main function"))
			{
				if(input[i][3].equalsIgnoreCase("Y"))
				{
					rfencehome rh = new rfencehome();
					data1=rh.Home(data1, rc);
					rc=rc+data1.size();
					flag=1;
				}
			}
		}
		if(flag == 1)
		{
			rc++;
			data.putAll(data);
			data.putAll(data1);
			System.out.println(data.size());
			System.out.println(data1.size());
			data.put(""+rc, new Object[] {"", "", "", "", "", "Total Time Consumed",s.timestamp(stime) });
			filename = s.writeoutput(data, "Output_Test_rfence");
		}

		else
		{
			rc++;
			System.out.println("No modules to run");
			data.put(""+rc, new Object[] {"", "", "", "", "", "Total Time Consumed",s.timestamp(stime) });
			filename = s.writeoutput(data, "Output_Test_rfence");
		}
		
		s.mail(filename);
	}
}
