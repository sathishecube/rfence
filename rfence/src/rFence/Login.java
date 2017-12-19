package rFence;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

@Test
public class Login 
{
public Map<String, Object[]> log(Map<String, Object[]> data, int rc) throws Exception
	{
		//Opening Firefox WebDriver
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver","\\\\AMXSERVER\\amx-share\\STW_QA\\chromedriver.exe"); 
		driver = new ChromeDriver();
		System.out.println("Browser openning....");
		
		
		//Instantiating the support class
		RfenceSupport s = new RfenceSupport();
		System.out.println(rc);
		String [][] inputData = s.readData("\\\\AMXSERVER\\amx-share\\STW_QA\\rFence Automation\\Test Data.xls",1);
		data.put(""+rc, new Object[] {"TC No", "Module", "Description", "Expected Result", "Actual Result", "Status", "Execution Time(Sec.)"});
		rc ++;
		
		//Input data values
		String tc;
		String tcdesc;
		String pw;
		String un;
		String eopt;
		String acop="-";
		String scenario="";
		//Executing the test case
		try
		{
		for (int i=0;i<inputData.length;i++)
		{
			acop="";
			System.out.println(i);
			long stime=System.currentTimeMillis();
			tc = inputData[i][0];
			tcdesc = inputData[i][1];
			int counter=1;
			scenario=inputData[i][6];
			un = inputData[i][2];
			pw = inputData[i][3];
			eopt = inputData[i][5];
			System.out.println(tc+" "+tcdesc+" "+un+" "+pw+" "+eopt);
			driver.get("http://192.168.1.218:8080/AJAX/RFENCE/index.jsp");
			driver.manage().window().maximize();
			Thread.sleep(2000);
			driver.findElement(By.xpath(".//*[@id='userName']")).sendKeys(un);
			driver.findElement(By.xpath(".//*[@id='password']")).sendKeys(pw);
			driver.findElement(By.xpath("html/body/form/div[2]/div[2]/div/div[3]/table/tbody/tr[4]/td[2]/input")).click();
			Thread.sleep(2000);
			System.out.println(scenario);
			if(s.isElementPresent(By.xpath(".//*[@id='errorMsg']"),driver))
					{acop=driver.findElement(By.xpath(".//*[@id='errorMsg']")).getText();}
			if(acop.equalsIgnoreCase("Invalid Username / Password"))
			{
				try {
					System.out.println("Login Unsuccessful...\nUser Name : "+un+"\nPassword :"+pw);
					if(acop.equalsIgnoreCase(eopt))
					{
						data.put(""+rc, new Object[] {tc, "Login", tcdesc, eopt, acop, "Pass", s.timestamp(stime)});
						//scenario="TC2";
						s.writePass(scenario, counter);
					}
					else
					{
						data.put(""+rc, new Object[] {tc, "Login",  tcdesc, eopt, acop, "Fail", s.timestamp(stime)});
						//scenario="TC1";
						s.writeFail(scenario, counter);
					}
					rc++;
				} catch (Exception e) {
					System.out.println(e);
				}
			}else{
				System.out.println("Login Successful...\nUser Name : "+un+"\nPassword :"+pw);
				acop = "Login Successful";
				if(s.testStatus(acop, eopt))
				{
					data.put(""+rc, new Object[] {tc, "Login", tcdesc, eopt, acop, "Pass", s.timestamp(stime)});
					//scenario="TC1";
					s.writePass(scenario, counter);
				}
				else
				{
					data.put(""+rc, new Object[] {tc, "Login", tcdesc, eopt, acop, "Fail", s.timestamp(stime)});
					//scenario="TC2";
					s.writeFail(scenario, counter);
				}
				rc++;
			}
		}
		
		}catch (Exception e)
		{
			e.printStackTrace();
		} 
		finally
		{
		driver.quit();
		return data;
		}
	}
}

