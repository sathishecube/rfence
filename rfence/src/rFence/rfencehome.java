package rFence;

import java.awt.Robot;
import java.awt.event.InputEvent;
import java.util.ArrayList;
import java.util.Map;

import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class rfencehome 
{
	@Test
	public Map<String, Object[]> Home (Map<String, Object[]> data, int rc) throws Exception
	{
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver","\\\\AMXSERVER\\amx-share\\STW_QA\\chromedriver.exe"); 
		driver = new ChromeDriver();
		System.out.println("Browser opening....");
		
		RfenceSupport s = new RfenceSupport();
		String tc;
		String mod;
		String tcdesc;
		String eopt;
		String acop="-";
		String scenario="";
		String [][] input = s.readData("\\\\AMXSERVER\\amx-share\\STW_QA\\rFence Automation\\Test Data.xls",2);
		Robot r = new Robot();
		
		rc ++;
		System.out.println(input.length);
		driver.manage().window().maximize();
		try
		{
			if(s.login(driver, input[0][2], input[0][3]))
			{
				//driver.manage().window().maximize();
				Thread.sleep(1000);
				s.zoom(driver);
				for(int i=0;i<input.length;i++)
				{
					tc = input[i][0];
					mod = input[i][16];
					tcdesc = input[i][1];
					eopt = input[i][15];
					scenario=input[i][18];
					int counter=1;
					long stime=System.currentTimeMillis();
					try 
					{
						if(input[i][4].equalsIgnoreCase("Y")) //Create module
						{						
							s.search(driver, input[i][17]);
							if(input[i][11].equalsIgnoreCase("Y"))//Create Rectangle
							{
								do
								{
									Thread.sleep(2000);
								}while(s.isElementPresent(By.xpath(".//*[@id='OverlayParent']"),driver));	
								driver.findElement(By.xpath(".//*[@id='menuBtn1']")).click();
								if(s.isAlertPresent(driver))
								{
									if(s.alertmsg(driver).startsWith("Tabs cannot"))
									{
										driver.switchTo().alert().accept();
										s.tab(driver);
										System.out.println("Test tab alert");
									}
									else
									{
										Alert alert =driver.switchTo().alert();
										Thread.sleep(1000);
										alert.accept();
										Thread.sleep(1000);
									}
									
								}
								
								if(input[i][9].equalsIgnoreCase("Use Address"))
								{
									acop=s.Plotaddr(driver, input[i][10]);
									if(acop =="")
									{
										Thread.sleep(2000);
										s.Rectangle(driver);
										r.mouseMove(800, 400);
										r.mousePress(InputEvent.BUTTON1_MASK);
										r.delay(1000); 
										r.mouseRelease(InputEvent.BUTTON1_MASK);
										s.Category(driver, input[i][14]);
										driver.findElement(By.xpath(".//*[@id='menuBtn3']")).click();
										Thread.sleep(1000);
										driver.findElement(By.xpath(".//*[@id='txtSaveGeofenceName']")).sendKeys(input[i][13]);
										acop = s.save(driver, input[i][13]);
									}
									
								}
								else if(input[i][9].equalsIgnoreCase("Use GPS"))
								{	
									acop=s.Plotgps(driver, input[i][10]);
									if(acop =="")
									{
										Thread.sleep(2000);
										s.Rectangle(driver);
										r.mouseMove(800, 400);
										r.mousePress(InputEvent.BUTTON1_MASK);
										r.delay(1000); 
										r.mouseRelease(InputEvent.BUTTON1_MASK);
										s.Category(driver, input[i][14]);
										driver.findElement(By.xpath(".//*[@id='menuBtn3']")).click();
										driver.findElement(By.xpath(".//*[@id='txtSaveGeofenceName']")).sendKeys(input[i][13]);
										acop = s.save(driver, input[i][13]);
										
									}
								}
								else if(input[i][9].equalsIgnoreCase("Use map"))
								{
									acop=s.Plotmap(driver, input[i][10]);
									if(acop =="")
									{
										Thread.sleep(3000);
										s.Rectangle(driver);
										r.mouseMove(800, 400);
										r.mousePress(InputEvent.BUTTON1_MASK);
										r.delay(1000); 
										r.mouseRelease(InputEvent.BUTTON1_MASK);
										s.Category(driver, input[i][14]);
										driver.findElement(By.xpath(".//*[@id='menuBtn3']")).click();
										driver.findElement(By.xpath(".//*[@id='txtSaveGeofenceName']")).sendKeys(input[i][13]);
										acop = s.save(driver, input[i][13]);
										
									}
									
								}
								else
								{
									System.out.println("Invalid input... Provide proper location type...");
									acop="Invalid input... Provide proper location type...";
								}
							}						
							if(input[i][12].equalsIgnoreCase("Y")) //Creating polygon
							{
								do
								{
									Thread.sleep(2000);
								}while(s.isElementPresent(By.xpath(".//*[@id='OverlayParent']"),driver));
							
								driver.findElement(By.xpath(".//*[@id='menuBtn1']")).click();
							
								if(input[i][9].equalsIgnoreCase("Use Address"))
								{
									acop=s.Plotaddr(driver, input[i][10]);
									if(acop =="")
									{
										Thread.sleep(2000);
										s.Polygon(driver);
										s.Category(driver, input[i][14]);
										driver.findElement(By.xpath(".//*[@id='menuBtn3']")).click();
										driver.findElement(By.xpath(".//*[@id='txtSaveGeofenceName']")).sendKeys(input[i][13]);
										acop = s.save(driver, input[i][13]);
									}					
									
								}
								
								else if(input[i][9].equalsIgnoreCase("Use GPS"))
								{
									acop=s.Plotgps(driver, input[i][10]);
									if(acop =="")
									{
										Thread.sleep(2000);
										s.Polygon(driver);
										s.Category(driver, input[i][14]);
										driver.findElement(By.xpath(".//*[@id='menuBtn3']")).click();
										driver.findElement(By.xpath(".//*[@id='txtSaveGeofenceName']")).sendKeys(input[i][13]);
										acop = s.save(driver, input[i][13]);
									
									}
									
																
								}
								
								else if(input[i][9].equalsIgnoreCase("Use map"))
								{
									acop=s.Plotmap(driver, input[i][10]);
									if(acop =="")
									{
										Thread.sleep(2000);
										s.Polygon(driver);
										s.Category(driver, input[i][14]);
										driver.findElement(By.xpath(".//*[@id='menuBtn3']")).click();
										driver.findElement(By.xpath(".//*[@id='txtSaveGeofenceName']")).sendKeys(input[i][13]);
										acop = s.save(driver, input[i][13]);
									}
								
									
								}
								else
								{
									System.out.println("Invalid input... Provide proper location type...");
									acop="Invalid input... Provide proper location type...";
								}
								
								
							}
							
							
							if(driver.findElement(By.xpath(".//*[@id='divCreateGeo']/div/div[1]/a/img")).isDisplayed())
							{
								driver.findElement(By.xpath(".//*[@id='divCreateGeo']/div/div[1]/a/img")).click();
							}
							
						}
						
						else if(input[i][6].equalsIgnoreCase("Y"))//Deleting a fence
						{
							while(s.isElementPresent(By.xpath(".//*[@id='OverlayParent']"),driver))
							{
								Thread.sleep(2000);
							}
							acop = s.del(driver, input[i][13],input[i][14],0,input[i][17]);
							
						}
						
						else if(input[i][5].equalsIgnoreCase("Y"))// Modifying a fence
						{
							int type =0;
							if(input[i][11].equalsIgnoreCase("Y"))
							{
								type=1;
							}
							acop = s.modify(driver, input[i][13], type, input[i][14] ,input[i][17]);
						}
					
						else if(input[i][8].equalsIgnoreCase("Y")) //Deploy fleet
						{
							
							while(s.isElementPresent(By.xpath(".//*[@id='OverlayParent']"),driver))
							{
								Thread.sleep(2000);
							}
							acop = s.deploy(driver, input[i][17]);
							
						    
						}
						else
						{
							System.out.println("Invalid input... No operation called...");
							acop = "Invalid input... No operation called...";
						}
						
						if(s.testStatus(acop, eopt))
						{
							data.put(""+rc, new Object[] {tc, mod, tcdesc, eopt, acop, "Pass", s.timestamp(stime) });
							rc++;
							s.writePass(scenario, counter);
						}
						else
						{
							data.put(""+rc, new Object[] {tc, mod, tcdesc, eopt, acop, "Fail", s.timestamp(stime) });
							rc++;
							s.writeFail(scenario, counter);
							
						}
					}
					catch(Exception e)
					{
						e.printStackTrace();
						data.put(""+rc, new Object[] {tc, mod, tcdesc, eopt, "Unexpected Error", "Fail", s.timestamp(stime) });
						rc++;
					}
				}	
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		//driver.quit();
		return data;
	}
}
	