package rFence;

import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

import javax.activation.*;
import javax.mail.*;  
import javax.mail.internet.*;  

import java.util.Properties; 

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.poi.hssf.record.cf.PatternFormatting;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ISuiteResult;

public class RfenceSupport 
{

/* Login function */
	public boolean login(WebDriver driver, String uname, String pwd) throws Exception
	{
		boolean result=true;
		System.out.println("Inside the login method......");
		driver.get("http://192.168.1.218:8080/AJAX/RFENCE/index.jsp");
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='userName']")).sendKeys(uname);
		driver.findElement(By.xpath(".//*[@id='password']")).sendKeys(pwd);
		driver.findElement(By.xpath("html/body/form/div[2]/div[2]/div/div[3]/table/tbody/tr[4]/td[2]/input")).click();
		while(isElementPresent(By.xpath(".//*[@id='OverlayParent']"), driver))
		{
			Thread.sleep(2000);	
		}
				
		Thread.sleep(500);
		System.out.println("Welcome to home screen");
		return result;
	}
 
	public boolean isElementPresentcheck(By by, WebDriver driver)
	{
		try
		{
			//driver.findElement(by).getText();
			if(driver.findElement(by).isDisplayed())
				return true;
			else
				return false;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return false;
		}	
	}
	
	/* Delete Function*/
	public String del(WebDriver driver, String fname,String cat,int d, String fleetname) throws Exception
	{
		String acop = "";
		try
		{
			WebElement ele, ele1;
			Thread.sleep(1000);
			if(isElementPresentcheck(By.xpath(".//*[@id='menuBtn16']"), driver))
			{
				driver.findElement(By.xpath(".//*[@id='menuBtn16']")).click();
			}
			do
			{
				Thread.sleep(2000);
			}while(isElementPresent(By.xpath(".//*[@id='OverlayParent']"),driver));
			driver.findElement(By.xpath(".//*[@id='menuBtn15']")).click();
			do
			{
				Thread.sleep(2000);
			}while(isElementPresent(By.xpath(".//*[@id='OverlayParent']"),driver));
			Thread.sleep(2000);
			driver.findElement(By.xpath(".//*[@id='searchFleet_chosen']/a/div/b")).click();
			driver.findElement(By.xpath(".//*[@id='searchFleet_chosen']/div/div/input")).sendKeys(fleetname);
			driver.findElement(By.xpath(".//*[@id='searchFleet_chosen']/div/ul/li")).click();
			
			/*Select droplist = new Select(driver.findElement(By.xpath(".//*[@id='searchFleet']")));   
			droplist.selectByVisibleText(fleetname);*/
			driver.findElement(By.xpath(".//*[@id='txtSearchGeofence']")).clear();
			driver.findElement(By.xpath(".//*[@id='txtSearchGeofence']")).sendKeys(fname);
			driver.findElement(By.xpath(".//*[@id='lnkBtnSearch']")).click();
			Thread.sleep(2000);
			ele = driver.findElement(By.linkText(fname));
			String val = ele.getAttribute("id");
			ele.click();
			do
			{
				Thread.sleep(2000);
			}while(isElementPresent(By.xpath(".//*[@id='OverlayParent']"),driver));
			String v[]=val.split("_");
			ele = driver.findElement(By.id(v[0]));
			System.out.println("Tagname:"+ele.getTagName());
			System.out.println("id"+ele.getAttribute("id"));
			ele1=ele.findElement(By.tagName("ul"));
			System.out.println("Tagname:"+ele1.getTagName());
			ele1=ele1.findElement(By.tagName("li"));
			ele1.findElement(By.tagName("a")).click();
			System.out.println(ele1.getAttribute("id"));
			Thread.sleep(2000);
			driver.findElement(By.xpath(".//*[@id='menuBtn9']")).click();
			Thread.sleep(2000);
			if(isAlertPresent(driver))
			{
				Alert alert = driver.switchTo().alert();
				System.out.println(alert.getText());
				acop = alert.getText();
				alert.accept();
				Thread.sleep(2000);
				if(isAlertPresent(driver))
				{
					Alert alert1 = driver.switchTo().alert();
					System.out.println(alert1.getText());
					acop = alert1.getText();
					alert1.accept();
					
					Thread.sleep(2000);
				}
			}
			Thread.sleep(2000);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return acop;
		
	}
/* Delete Function Back up*/
	public String delbkp(WebDriver driver, String fname,String cat,int d, String eop) throws Exception
	{
		WebElement element;
		int flag=0;
		try{
			driver.findElement(By.xpath(".//*[@id='tabs']/li[1]")).click();
			while(isElementPresent(By.xpath(".//*[@id='OverlayParent']"),driver))
			{
				Thread.sleep(2000);
			}
			System.out.println("eop :"+eop);
			driver.findElement(By.xpath(".//*[@id='txtSearchGeofence']")).click();
			driver.findElement(By.xpath(".//*[@id='txtSearchGeofence']")).clear();
			driver.findElement(By.xpath(".//*[@id='txtSearchGeofence']")).sendKeys(fname);
			Thread.sleep(2000);
			driver.findElement(By.xpath(".//*[@id='toolContainer']/div[1]/div/div")).click();
			Thread.sleep(2000);
			while(isElementPresent(By.xpath(".//*[@id='OverlayParent']"),driver))
			{
				Thread.sleep(2000);
			}
			if(isAlertPresent(driver))
			{
				if(alertmsg(driver).startsWith("Tabs cannot"))
				{
					driver.switchTo().alert().accept();
					tab(driver);
					System.out.println("Test tab alert");
				}
				else
				{
					Alert alert =driver.switchTo().alert();
					Thread.sleep(1000);
					if(d==0)
					{
						if(alert.getText().startsWith("No data found for the string"))
							eop="Geofence not present";
						else
							eop=alert.getText();
					}
					alert.accept();
					Thread.sleep(1000);
				}	
			}
			else
			{
				if(!isElementPresent(By.linkText(fname), driver))
				{
					if(eop.equalsIgnoreCase("Fence Deleted successfully"))
					{
						return eop;
					}
					else
					{
						eop="Unexpected error while deleting...";
						return eop;
					}
				}
				element=driver.findElement(By.linkText(fname));
				System.out.println(element.getText());
				System.out.println(element.getAttribute("id"));
				element.click();
				String val = element.getAttribute("id");
				String v1[]=val.split("_");
				System.out.println(v1[0]);
				element=driver.findElement(By.id(v1[0]));
				System.out.println(element.getAttribute("aria-expanded"));
				if(element.getAttribute("aria-expanded").equalsIgnoreCase("TRUE"))
				{
					System.out.println(element.getTagName());
					element=element.findElement(By.tagName("ul"));
					System.out.println(element.getTagName());
					List<WebElement> elements;
					elements=element.findElements(By.tagName("li"));
					System.out.println(elements.size());
					for(int j=0;j<elements.size();j++)
					{
						flag =0;
						System.out.println("Element no "+(j+1));
						element=elements.get(j);
						System.out.println(element.getTagName());
						List<WebElement> elements1 = element.findElements(By.tagName("a"));
						System.out.println(elements1.size());
						//		System.out.println(elements1.size());
						for(int i=0;i<elements1.size();i++)
						{
							element=elements1.get(i);
							System.out.println(element.getText());
							if(element.getText().equalsIgnoreCase(cat))
							{
								element.click();
								driver.findElement(By.xpath(".//*[@id='menuBtn9']")).click();
								if(isAlertPresent(driver))
								{
									Alert alert = driver.switchTo().alert();
									alert.accept();
									System.out.println("Deleted...");
									eop="Fence Deleted successfully";
									flag=1;
									d=1;
									Thread.sleep(2000);
									if(isAlertPresent(driver))
									{
										alert = driver.switchTo().alert();
										alert.accept();
									}
								}
								else
								{
									System.out.println("Error");
								}
							}
							do
							{
								Thread.sleep(2000);
							}while(isElementPresent(By.xpath(".//*[@id='OverlayParent']"),driver));
							System.out.println("flag value " +flag);
						}
						/*if(flag==1)
						{
							driver.findElement(By.xpath(".//*[@id='tabs']/li[1]")).click();
							do
							{
								Thread.sleep(2000);
							}while(isElementPresent(By.xpath(".//*[@id='OverlayParent']"),driver));
							System.out.println("Break");
							break;
						}*/
					}
					if(d==0)
					{
						eop="There is no fence of this category to delete...";
					}
					else
					{
						if(flag==1)
							eop = del(driver, fname,cat,d,eop);
					}	
				}
			}	
			return eop;
		}catch(Exception e)
		{	
			e.printStackTrace();
			eop="Unexpected error while deleting...";
			return eop;
		}
	}


/*Zoom in function */
public void zoom (WebDriver driver) throws Exception
	{
	Robot r =new Robot();
	r.mouseMove(800, 300);
	r.mouseWheel(-100);
	r.delay(1000);
	r.mouseWheel(-100);
	r.delay(1000);
	r.mouseWheel(-100);
	r.delay(1000);
	r.mouseWheel(-100);
	r.delay(1000);
	r.mouseWheel(-100);
	r.delay(1000);
	r.mouseWheel(-100);
	r.delay(1000);
	r.mouseWheel(-100);
	r.delay(1000);
	Thread.sleep(1000);
	}

/* This method finds and returns if there is an alert present. */
public boolean isAlertPresent(WebDriver driver)
	{
	try
	{
		driver.switchTo().alert();
		
		return true;
	}catch (NoAlertPresentException Ex)
	{
		return false;
	}
	}

/* Handling alert msg function */
public String alertmsg(WebDriver driver)
	{
	if(isAlertPresent(driver))
	{
		Alert alert =driver.switchTo().alert();
		String alt = alert.getText();
				return alt;
	}
	else{
		return "No data";
	}
	}


/* This method is used to write the output result status to a Excel. */
public String writeoutput(Map<String, Object[]> data, String str)
{
	//Creating a Workbook and Sheet to write output
    //short bg = 2;
    HSSFWorkbook workbook = new HSSFWorkbook();
    HSSFSheet osheet = workbook.createSheet("Test Status");
    Set<String> keyset = data.keySet();
    int rownum = 0;
      
    //Copying the data from the Map to the sheet.
    for (String key : keyset)
       {
           Row orow = osheet.createRow(rownum++);
           Object [] objArr = data.get(key);
           int cellnum = 0;
           for (Object obj : objArr)
           {
        	   if(obj.toString().equalsIgnoreCase("Pass"))
        	   {
        		   HSSFCellStyle style = workbook.createCellStyle();
        		   HSSFFont font = workbook.createFont();
        		   font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        		   style.setFont(font);
        		   style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
        		   style.setFillPattern(PatternFormatting.SOLID_FOREGROUND);
        		   Cell cell = orow.createCell(cellnum);
        		   cellnum++;
        		   cell.setCellStyle(style);
        		   cell.setCellValue((String)obj);
        		   System.out.println(cell.getRowIndex());
        		   System.out.println(cell.getColumnIndex());
        	   
        	   }
        	   else if(obj.toString().equalsIgnoreCase("Fail"))
        	   {
        		   HSSFCellStyle style = workbook.createCellStyle();
        		   HSSFFont font = workbook.createFont();
        		   font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        		   style.setFont(font);
        		   style.setFillForegroundColor(IndexedColors.RED.getIndex());
        		   style.setFillPattern(PatternFormatting.SOLID_FOREGROUND);
        		   Cell cell = orow.createCell(cellnum);
        		   cellnum++;
        		   cell.setCellStyle(style);
        		   cell.setCellValue((String)obj);
        		   System.out.println(cell.getRowIndex());
        		   System.out.println(cell.getColumnIndex());
        	   }
        	   else if(obj.toString().equalsIgnoreCase("TC No") || obj.toString().equalsIgnoreCase("Module") || obj.toString().equalsIgnoreCase("Description")
        			   || obj.toString().equalsIgnoreCase("Expected Result") || obj.toString().equalsIgnoreCase("Actual Result") 
        			   || obj.toString().equalsIgnoreCase("Status") || obj.toString().equalsIgnoreCase("Execution Time(Sec.)"))
        	   {
        		   HSSFCellStyle style = workbook.createCellStyle();
        		   style.setFillForegroundColor(IndexedColors.CORNFLOWER_BLUE.getIndex());
        		   style.setFillPattern(PatternFormatting.SOLID_FOREGROUND);
        		   HSSFFont font = workbook.createFont();
        		   font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        		   style.setFont(font);
        		   Cell cell = orow.createCell(cellnum);
        		   cellnum++;
        		   cell.setCellStyle(style);
        		   cell.setCellValue((String)obj);
        		   System.out.println(cell.getRowIndex());
        		   System.out.println(cell.getColumnIndex());
        	   }
        	   else if(obj.toString().equalsIgnoreCase("Total Time Consumed"))
        	   {
        		   HSSFCellStyle style = workbook.createCellStyle();
        		   HSSFFont font = workbook.createFont();
        		   Cell cell = orow.createCell(cellnum);
        		   cellnum++;
        		   cell.setCellStyle(style);
        		   cell.setCellValue((String)obj);
        		   font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        		   style.setFont(font);
        		   System.out.println(cell.getRowIndex());
        		   System.out.println(cell.getColumnIndex());
        	   }
        	   else
               {
        		   Cell cell = orow.createCell(cellnum);
        		   HSSFCellStyle style = workbook.createCellStyle();
                   cellnum++;
                   String string=obj.toString();
                   try
                   {
                	   System.out.println(Integer.parseInt(string));
                	   style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
                	   cell.setCellStyle(style);
                	   cell.setCellValue((String)obj);
                   }
                   catch(NumberFormatException e)
                   {
                	   System.out.println("Not integer...");
                	   cell.setCellValue((String)obj);
                   }
                   
                   
               }
        	   
           }
           
       }
       try
       {
           FileOutputStream out = new FileOutputStream(new File("\\\\AMXSERVER\\amx-share\\STW_QA\\rFence Automation\\"+str+".xls"));
           workbook.write(out);
           out.close();
           System.out.println("output written successfully...");
           
       }
       catch (Exception e)
       {
           e.printStackTrace();
       }
       finally
       {
    	   return "D:\\RF\\"+str+".xls";
       }
   }

/* This method is used to read input data from an Excel. */
public String colnum(Cell cell, int i)
{
	String abc = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	String ab = abc.substring(cell.getColumnIndex(), cell.getColumnIndex()+1);
	if(i==0)
		ab=ab.concat("2");
	else
		ab=ab.concat(String.valueOf(cell.getRowIndex()));
	System.out.println(ab);
	return ab;
}

/* This method is used to read input data from an Excel. */
public String[][] readData (String fname, int pnum) throws Exception
{
	InputStream input = new BufferedInputStream(new FileInputStream(fname));
	POIFSFileSystem fs = new POIFSFileSystem( input );
	HSSFWorkbook wb = new HSSFWorkbook(fs);
	HSSFSheet sheet = wb.getSheetAt(pnum);
	Row row;
	Cell c;
	String[][] d1 =new String[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
	for(int i=1;i<=sheet.getLastRowNum();i++)
	{
		row = sheet.getRow(i);
		for(int j=0;j<sheet.getRow(0).getLastCellNum();)
		{
			c = row.getCell(j);
			d1[i-1][j]=c.toString();
			j++;
		}
	}
	return d1;
}


/* This method is used to save a file using save as dialogue box. */
public void Rectangle(WebDriver driver) throws Exception
{
	Robot rt = new Robot();
	/*rt.keyPress(KeyEvent.VK_ENTER);
	rt.delay(1000);
	rt.keyRelease(KeyEvent.VK_ENTER);*/
	Thread.sleep(1000);
	driver.findElement(By.xpath(".//*[@id='menuBtn4']")).click();
	Thread.sleep(2000);
	if(driver.findElement(By.xpath(".//*[@id='tools']/ul/li[6]/ul/li[3]/img")).isDisplayed())
	{
		System.out.println("Safe...");
		driver.findElement(By.xpath(".//*[@id='tools']/ul/li[6]/ul/li[3]/img")).click();
	}
	else
	{
		System.out.println("Thappache...");
		//driver.findElement(By.xpath(".//*[@id='tools']/ul/li[4]/ul/li[3]/img")).click();
	}
	rt.delay(1000);
	rt.delay(1000);
	rt.mouseMove(600, 500);
	rt.mousePress(InputEvent.BUTTON1_MASK);
	rt.delay(1000);
	rt.mouseRelease(InputEvent.BUTTON1_MASK);
	rt.mouseMove(695, 600);
	rt.mousePress(InputEvent.BUTTON1_MASK);
	rt.delay(1000);
	rt.mouseRelease(InputEvent.BUTTON1_MASK);
	Thread.sleep(2000);
	//driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	if(alertmsg(driver).equalsIgnoreCase("Distance between nodes cannot be less than 50 feet or exceed 12 miles."))
	{
		Alert alert =driver.switchTo().alert();
		alert.accept();
		rt.mouseWheel(10);
		Rectangle(driver);
		
	}
	/*else
	{
		Alert alert =driver.switchTo().alert();
		alert.accept();
	}*/
}

public void Polygon(WebDriver driver) throws Exception
{
	Robot rt = new Robot();
	/*rt.keyPress(KeyEvent.VK_ENTER);
	rt.delay(1000);
	rt.keyRelease(KeyEvent.VK_ENTER);*/
	rt.delay(1000);
	driver.findElement(By.xpath(".//*[@id='menuBtn4']")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath(".//*[@id='tools']/ul/li[6]/ul/li[1]/img")).click();
	rt.delay(1000);
	rt.mouseMove(600, 400);
	rt.mousePress(InputEvent.BUTTON1_MASK);
	rt.delay(1000);
	rt.mouseRelease(InputEvent.BUTTON1_MASK);
	rt.mouseMove(695, 400);
	rt.mousePress(InputEvent.BUTTON1_MASK);
	rt.delay(1000);
	rt.mouseRelease(InputEvent.BUTTON1_MASK);
	rt.mouseMove(695, 500);
	rt.mousePress(InputEvent.BUTTON1_MASK);
	rt.delay(1000);
	rt.mouseRelease(InputEvent.BUTTON1_MASK);
	rt.mouseMove(655, 500);
	rt.mousePress(InputEvent.BUTTON1_MASK);
	rt.delay(1000);	
	rt.mouseRelease(InputEvent.BUTTON1_MASK);
	rt.mouseMove(600, 400);
	rt.mousePress(InputEvent.BUTTON1_MASK);
	rt.delay(1000);	
	rt.mouseRelease(InputEvent.BUTTON1_MASK);
	Thread.sleep(2000);
	if(alertmsg(driver).equalsIgnoreCase("Distance between nodes cannot be less than 50 feet or exceed 12 miles."))
	{
			System.out.println("Alert");
			Alert alert =driver.switchTo().alert();
			alert.accept();
			rt.mouseWheel(100);
			Polygon(driver);
		
	}
}

/* This method is used to compare expected with Actual */
public boolean testStatus(String eopt, String aopt)
{
	System.out.println(eopt+":"+aopt);
	if(eopt.equalsIgnoreCase(aopt))
	{
		System.out.println("Pass");
		return true;
	}
	else
	{
		System.out.println("Fail");
		return false;
	}
}

/* This method is used to get the exceution time of each function */
public String timestamp(long Stime)
{
	long Etime = System.currentTimeMillis();
	long Ttime = Etime - Stime;
	long Exetime =Ttime /1000 ;
	return Long.toString(Exetime);
}

/* Logout function */
public void logout(WebDriver driver)
{
	driver.findElement(By.xpath(".//*[@id='logout']/input")).click();
	Alert alt = driver.switchTo().alert();
	alt.accept();
}

/* Element checking function */
public boolean isElementPresent(By by, WebDriver driver)
	{

	try
	{
		driver.findElement(by).click();
		return true;
	}
	catch (Exception e)
	{
		return false;
	}
	}

/* Save function */
public String save(WebDriver driver,String n)
	{
	String acop="Fence Created successfully";
	try{
		driver.findElement(By.xpath(".//*[@id='lnkBtnSave']")).click();
		while(isElementPresent(By.xpath(".//*[@id='OverlayParent']"),driver))
		{
			Thread.sleep(2000);
		}
		if(alertmsg(driver).equalsIgnoreCase("Geofence " +n+ " saved successfully"))
		{
			System.out.println("Geofence saved");
			Alert alert =driver.switchTo().alert();
			Thread.sleep(1000);
			alert.accept();
			Thread.sleep(2000);
			if(isAlertPresent(driver))
			{
				if(alertmsg(driver).startsWith("Tabs cannot"))
				{
					driver.switchTo().alert().accept();
					tab(driver);
					System.out.println("Test tab alert");
				}
				else
				{
					driver.switchTo().alert().accept();
					Thread.sleep(1000);
				}
				
			}
			
		}
		
		if(alertmsg(driver).equalsIgnoreCase("Geofence already exist, Please enter new geofence name"))
		{
			Alert alert =driver.switchTo().alert();
			alert.accept();
			Thread.sleep(1000);
			System.out.println("Inside of Geofence name alteration");
			driver.findElement(By.xpath(".//*[@id='txtSaveGeofenceName']")).clear();
			String inp = n;
			inp=inp.concat("2");
			System.out.println(inp);
			driver.findElement(By.xpath(".//*[@id='txtSaveGeofenceName']")).sendKeys(inp);
			acop = save(driver,inp);
			Thread.sleep(1000);
		}
		return acop;
	}catch(Exception e)
	{ 
		return "Null"; 
	}
	}

/* plotting fence using address */
public String Plotaddr(WebDriver driver,String loc) throws Exception
	{
	String eop = "";
	System.out.println("Inside of Use Address block");
	driver.findElement(By.xpath(".//*[@id='divCreateGeo']/div/div[2]/p/label[1]/input")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath(".//*[@id='txtGeoGeofencingAddress1']")).sendKeys(loc);
	driver.findElement(By.xpath(".//*[@id='divCreateGeo']/div/div[2]/div[1]/p/label")).click();
	Thread.sleep(2000);
	/*Robot rt = new Robot();
	rt.keyPress(KeyEvent.VK_ENTER);
	rt.delay(1000);
	rt.keyRelease(KeyEvent.VK_ENTER);*/
	driver.findElement(By.xpath(".//*[@id='btnCreateCancel']/a[1]/input")).click();
	Thread.sleep(1000);
	
	if(isAlertPresent(driver))
    {
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        eop=alert.getText();
        alert.accept();
        if(isElementPresentcheck(By.xpath(".//*[@id='btnCreateCancel']/a[2]/input"), driver))
        	driver.findElement(By.xpath(".//*[@id='btnCreateCancel']/a[2]/input")).click();
    }
	return eop;
	}

/* Plotting fence using gps */
public String Plotgps(WebDriver driver,String loc) throws Exception
	{
	String eop = "";
	String s1 ="";
	System.out.println("Inside of Use GPS block");
	driver.findElement(By.xpath(".//*[@id='divCreateGeo']/div/div[2]/p/label[2]/input")).click();
	s1 =loc;
	if(!(s1.equalsIgnoreCase("")))
	{
	String s2[] = s1.split(",");
	System.out.println(s2[0]);
	System.out.println(s2[1]);
	if(!(s2[0].equalsIgnoreCase("null")))
	{
	driver.findElement(By.xpath(".//*[@id='divCreateGeo']/div/div[2]/div[2]/div/div[1]/input")).sendKeys(s2[0]);
	}
	if(!(s2[1].equalsIgnoreCase("null")))
	{
	driver.findElement(By.xpath(".//*[@id='divCreateGeo']/div/div[2]/div[2]/div/div[2]/input")).sendKeys(s2[1]);
	}
	}
	driver.findElement(By.xpath(".//*[@id='btnCreateCancel']/a[1]/input")).click();
	Thread.sleep(1000);
	if(isAlertPresent(driver))
    {
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        eop=alert.getText();
        alert.accept();
        driver.findElement(By.xpath(".//*[@id='btnCreateCancel']/a[2]/input")).click();
    }
	return eop;
	}

/*Plotting fence using map */
public String Plotmap(WebDriver driver,String loc) throws Exception
	{
	String eop = "";
	System.out.println("Inside of Use Map block");
	driver.findElement(By.xpath(".//*[@id='divCreateGeo']/div/div[2]/p/label[3]/input")).click();
	driver.findElement(By.xpath(".//*[@id='btnCreateCancel']/a[1]/input")).click();
	driver.findElement(By.xpath(".//*[@id='txtLocationSearchBox']")).clear();
	driver.findElement(By.xpath(".//*[@id='txtLocationSearchBox']")).sendKeys(loc);
	Robot rt = new Robot();
	rt.keyPress(KeyEvent.VK_ENTER);
	rt.delay(1000);
	rt.keyRelease(KeyEvent.VK_ENTER);
	Thread.sleep(1000);
	if(isAlertPresent(driver))
    {
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        eop=alert.getText();
        alert.accept();
        
    }
	return eop;
	}

/* Category selection function */
public boolean Category(WebDriver driver, String category)
{
    try
    {
        WebElement element;
        element=driver.findElement(By.xpath(".//*[@id='menuBtn11']"));
        if(element.isEnabled())
        {
            System.out.println("Enabled...");
            element.click();
            Thread.sleep(1500);
            List<WebElement> cat = driver.findElements(By.xpath(".//*[@id='optCategories']"));
            for(int i=1, k=1;i<3;i++)
            {
                int max;
                if(i==1)
                    max=6;
                else
                    max=5;
                for(int j=1;j<=max;j++)
                {
                    System.out.println("i "+i+"\nj "+j+"\nk "+k+"\nmax "+max);
                    System.out.println(driver.findElement(By.xpath(".//*[@id='divCategoriesGeo']/div/div[2]/div/div/div["+i+"]/ul/li["+j+"]/label")).getText());
                     System.out.println(category);
                    if(driver.findElement(By.xpath(".//*[@id='divCategoriesGeo']/div/div[2]/div/div/div["+i+"]/ul/li["+j+"]/label")).getText().equalsIgnoreCase(category))
                    {
                        System.out.println("Match found");
                        cat.get(k-1).click();
                        System.out.println("Category selected as "+driver.findElement(By.xpath(".//*[@id='divCategoriesGeo']/div/div[2]/div/div/div["+i+"]/ul/li["+j+"]/label")).getText());
                        Thread.sleep(500);
                        break;
                    }
                    k++;
                }
                
            }
            Thread.sleep(2000);
            driver.findElement(By.xpath(".//*[@id='btnSaveCategories']/a[1]/input")).click();
        }
        else
        {
            System.out.println("Geofence not selected");
            return false;
        }
        return true;
    }
    catch(Exception e){
        e.printStackTrace();
        return false;
    }
}

public String modify(WebDriver driver, String fname ,int type, String category , String fleetname) 
{
	String acop ="";
	WebElement ele, ele1;
	try
	{
		do
		{
			Thread.sleep(2000);
		}while(isElementPresent(By.xpath(".//*[@id='OverlayParent']"),driver));
		Thread.sleep(2000);
	    if(isElementPresentcheck(By.xpath(".//*[@id='menuBtn16']"), driver))
		{
			System.out.println("Clear button is available");
	    	driver.findElement(By.xpath(".//*[@id='menuBtn16']")).click();
	    	Thread.sleep(2000);
		} 
		driver.findElement(By.xpath(".//*[@id='menuBtn15']")).click();
		/*Select droplist = new Select(driver.findElement(By.xpath(".//*[@id='searchFleet']")));   
		droplist.selectByVisibleText(fleetname);*/
		driver.findElement(By.xpath(".//*[@id='searchFleet_chosen']/a/div/b")).click();
		driver.findElement(By.xpath(".//*[@id='searchFleet_chosen']/div/div/input")).sendKeys(fleetname);
		driver.findElement(By.xpath(".//*[@id='searchFleet_chosen']/div/ul/li")).click();
		
		driver.findElement(By.xpath(".//*[@id='txtSearchGeofence']")).clear();
		driver.findElement(By.xpath(".//*[@id='txtSearchGeofence']")).sendKeys(fname);
		driver.findElement(By.xpath(".//*[@id='lnkBtnSearch']")).click();
		Thread.sleep(2000);
		ele = driver.findElement(By.linkText(fname));
		String val = ele.getAttribute("id");
		ele.click();
		do
		{
			Thread.sleep(2000);
		}while(isElementPresent(By.xpath(".//*[@id='OverlayParent']"),driver));

		String v[]=val.split("_");
		ele = driver.findElement(By.id(v[0]));
		//element=driver.findElement(By.id(v1[0]));
		//ele.click();
		System.out.println("Tagname:"+ele.getTagName());
		System.out.println("id"+ele.getAttribute("id"));
		ele1=ele.findElement(By.tagName("ul"));
		System.out.println("Tagname:"+ele1.getTagName());
		ele1=ele1.findElement(By.tagName("li"));
		ele1.findElement(By.tagName("a")).click();
		System.out.println(ele1.getAttribute("id"));
		Thread.sleep(2000);
		//driver.findElement(By.xpath(".//*[@id='toolContainer']/div[1]/div/div")).click();
		Category(driver, category);
		driver.findElement(By.xpath(".//*[@id='menuBtn3']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='lnkBtnSave']")).click();
		while(isElementPresent(By.xpath(".//*[@id='OverlayParent']"),driver))
		{
			Thread.sleep(2000);
		}
		if(alertmsg(driver).equalsIgnoreCase("Geofence " +fname+ " updated successfully"))
		{
			System.out.println("Geofence updated");
			Alert alert =driver.switchTo().alert();
			alert.accept();
		}
		else{
			System.out.println("No alert present");
		}
		
		acop = "Fence Modified successfully";
		Thread.sleep(2000);
		
		return acop;
	
	}catch (Exception e)
	{
		e.printStackTrace();
		return acop;
	}
}

	/* Tab closing function */
	public void tab(WebDriver driver)
	{
		try
		{
			for(int i=9;i>=2;i--)
			{
				System.out.println(i);
				driver.findElement(By.xpath(".//*[@id='tabs']/li["+i+"]/img")).click();
				while(isElementPresent(By.xpath(".//*[@id='OverlayParent']"),driver))
				{
					Thread.sleep(2000);
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}


	/* This method is used to write the output result status to a Excel. */
	public void updateoutput(Map<String, Object[]> data, String fname)
	{
		try
		{
			int rowcount=0;
			InputStream input = new BufferedInputStream(new FileInputStream(fname));
			POIFSFileSystem fs = new POIFSFileSystem( input );
			HSSFWorkbook wb = new HSSFWorkbook(fs);
			HSSFSheet sheet = wb.getSheetAt(0);
			//Row row = sheet.getRow(sheet.getLastRowNum());
			HSSFWorkbook workbook = new HSSFWorkbook();
		    HSSFSheet osheet = workbook.createSheet("Test Status");
			int i=0;
			for(;i<sheet.getLastRowNum();i++)
				osheet.createRow(i);
			Row row = osheet.createRow(i);
			Cell cell;
			int cellnum=0;
			rowcount=sheet.getLastRowNum();
			System.out.println(sheet.getLastRowNum());
			rowcount++;
			Set<String> keyset = data.keySet();
			for (String key : keyset)
			{
				Object [] objArr = data.get(key);
				for (Object obj : objArr)
				{
					System.out.println(row.getRowNum());
					cell = row.createCell(cellnum);
					cellnum++;
					cell.setCellValue((String)obj);
				}
			}
			
			try
		       {
		           FileOutputStream out = new FileOutputStream(new File(fname));
		           wb.write(out);
		           out.close();
		           System.out.println("output updated successfully...");
		       }
		       catch (Exception e)
		       {
		           e.printStackTrace();
		       }
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/*Searching a fleet*/
	/* public void search(WebDriver driver, String name)
	{
		try
		{
			driver.findElement(By.xpath(".//*[@id='txtSearchGeofence']")).clear();
			driver.findElement(By.xpath(".//*[@id='txtSearchGeofence']")).sendKeys(name);
			while(isElementPresent(By.xpath(".//*[@id='OverlayParent']"),driver))
			{
				Thread.sleep(2000);
			}
			driver.findElement(By.xpath(".//*[@id='toolContainer']/div[1]/div/div")).click();
			Thread.sleep(2000);
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	} */
	
/* Delete All Function */
	public String delAll(WebDriver driver, String fname,int d, String eop) throws Exception
	{
		//String cat=null;
		WebElement element;
		int flag=0;
		try{
			driver.findElement(By.xpath(".//*[@id='tabs']/li[1]")).click();
			while(isElementPresent(By.xpath(".//*[@id='OverlayParent']"),driver))
			{
				Thread.sleep(2000);
			}
			System.out.println("eop :"+eop);
			driver.findElement(By.xpath(".//*[@id='txtSearchGeofence']")).click();
			driver.findElement(By.xpath(".//*[@id='txtSearchGeofence']")).clear();
			driver.findElement(By.xpath(".//*[@id='txtSearchGeofence']")).sendKeys(fname);
			Thread.sleep(2000);
			driver.findElement(By.xpath(".//*[@id='toolContainer']/div[1]/div/div")).click();
			Thread.sleep(2000);
			while(isElementPresent(By.xpath(".//*[@id='OverlayParent']"),driver))
			{
				Thread.sleep(2000);
			}
			if(isAlertPresent(driver))
			{
				if(alertmsg(driver).startsWith("Tabs cannot"))
				{
					driver.switchTo().alert().accept();
					tab(driver);
					System.out.println("Test tab alert");
				}
				else
				{
					Alert alert =driver.switchTo().alert();
					Thread.sleep(1000);
					if(d==0)
					{
						if(alert.getText().startsWith("No data found for the string"))
							eop="Geofence not present";
						else
							eop=alert.getText();
					}
					alert.accept();
					Thread.sleep(1000);
				}	
			}
			else
			{
				if(!isElementPresent(By.linkText(fname), driver))
				{
					if(eop.equalsIgnoreCase("Fence Deleted successfully"))
					{
						System.out.println("in here");
						return eop;
					}
					else
					{
						eop="Unexpected error while deleting...";
						return eop;
					}
				}
				element=driver.findElement(By.linkText(fname));
				System.out.println(element.getText());
				System.out.println(element.getAttribute("id"));
				element.click();
				String val = element.getAttribute("id");
				String v1[]=val.split("_");
				System.out.println(v1[0]);
				element=driver.findElement(By.id(v1[0]));
				System.out.println(element.getAttribute("aria-expanded"));
				if(element.getAttribute("aria-expanded").equalsIgnoreCase("TRUE"))
				{
					System.out.println(element.getTagName());
					element=element.findElement(By.tagName("ul"));
					System.out.println(element.getTagName());
					List<WebElement> elements;
					elements=element.findElements(By.tagName("li"));
					System.out.println(elements.size());
					for(int j=0;j<elements.size();j++)
					{
						flag =0;
						System.out.println("Element no "+(j+1));
						element=elements.get(j);
						System.out.println(element.getTagName());
						List<WebElement> elements1 = element.findElements(By.tagName("a"));
						System.out.println(elements1.size());
						String[] str = new String[elements1.size()];
						for(int i=0;i<elements1.size();i++)
						{
							element=elements1.get(i);
							str[i]=element.getText();			
						}
						for(int i=0;i<elements1.size();i++)
						{
							element=elements1.get(i);
							System.out.println(str[i]);
							if(element.getText().equalsIgnoreCase(str[i]))
							{
								element.click();
								driver.findElement(By.xpath(".//*[@id='menuBtn9']")).click();
								Thread.sleep(1000);
								if(isAlertPresent(driver))
								{
									Alert alert = driver.switchTo().alert();
									alert.accept();
									System.out.println("Deleted...");
									eop="Fence Deleted successfully";
									flag=1;
									d=1;
									Thread.sleep(2000);
									if(isAlertPresent(driver))
									{
										alert = driver.switchTo().alert();
										alert.accept();
									}
								}
								else
								{
									System.out.println("Error");
								}
							}
							do
							{
								Thread.sleep(2000);
							}while(isElementPresent(By.xpath(".//*[@id='OverlayParent']"),driver));
							System.out.println("flag value " +flag);
						}
						if(flag==1)
						{
							driver.findElement(By.xpath(".//*[@id='tabs']/li[1]")).click();
							do
							{
								Thread.sleep(2000);
							}while(isElementPresent(By.xpath(".//*[@id='OverlayParent']"),driver));
							System.out.println("Break");
							break;
						}
					}
					if(d==0)
					{
						eop="There is no fence of this category to delete...";
					}
					else
					{
						if(flag==1)
							eop = delAll(driver, fname,d, eop);
					}	
				}
			}	
			return eop;
		}catch(Exception e)
		{	
			e.printStackTrace();
			eop="Unexpected error while deleting...";
			return eop;
		}
	}
	
	//Sending mail
	public void mail(String filename) 
	{
		// TODO Auto-generated method stub
		String host="smtp.gmail.com";  
		  final String user="naveen@startrakwireless.com";//change accordingly  
		  final String password="Billa.14";//change accordingly  
		    
		  String to = "sathishb@startrakwireless.com";//change accordingly
		  String cc = "abirami@startrakwireless.com";
		   Properties props = new Properties();  
		   props.put("mail.smtp.host",host);  
		   props.put("mail.smtp.auth", "true");
		   props.put("mail.smtp.starttls.enable","true");
		   
		   Session session = Session.getDefaultInstance(props,  new javax.mail.Authenticator() 
		   {  
			   protected PasswordAuthentication getPasswordAuthentication() 
			   {  
				   return new PasswordAuthentication(user,password);  
			   }  
		    });  
		  
		   //Compose the message  
		    try {  
		     MimeMessage message = new MimeMessage(session);  
		     message.setFrom(new InternetAddress(user));  
		     message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
		     message.addRecipient(Message.RecipientType.CC, new InternetAddress(cc));
		     message.setSubject("Test Result");  
		    
		     
		     BodyPart messageBodyPart1 = new MimeBodyPart();  
		     messageBodyPart1.setText("This is message body");  
		     
		     MimeBodyPart messageBodyPart2 = new MimeBodyPart();  
		     DataSource source = new FileDataSource(filename);  
		     messageBodyPart2.setDataHandler(new DataHandler(source));  
		     messageBodyPart2.setFileName(filename); 
		     
		     Multipart multipart = new MimeMultipart();  
		     multipart.addBodyPart(messageBodyPart1);  
		     multipart.addBodyPart(messageBodyPart2);  
		     
		     message.setContent(multipart);  
		     
		     Transport t = session.getTransport("smtp");
		     
		     try {
		         t.connect(user, password);
		        // t.sendMessage(message, message.getAllRecipients());
		     } finally {
		         t.close();
		     }
		     
		     System.out.println("message sent successfully...");  
		   
		     } catch (MessagingException e) {e.printStackTrace();}  
	}
	public void search(WebDriver driver,String fleetname) throws Exception
	{
		//if()
		driver.findElement(By.xpath(".//*[@id='menuBtn15']")).click();
		/*Select droplist = new Select(driver.findElement(By.xpath(".//*[@id='searchFleet']")));   
		droplist.selectByVisibleText(fleetname);
		//driver.findElement(By.xpath(".//*[@id='txtSearchGeofence']")).sendKeys(fname);*/
		driver.findElement(By.xpath(".//*[@id='searchFleet_chosen']/a/div/b")).click();
		driver.findElement(By.xpath(".//*[@id='searchFleet_chosen']/div/div/input")).sendKeys(fleetname);
		driver.findElement(By.xpath(".//*[@id='searchFleet_chosen']/div/ul/li")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='lnkBtnSearch']")).click();
		
		
		
	}
	public int compare(ArrayList<String> a ,ArrayList<String> b)
	{
		int f =0;
		for (int i = 0; i < a.size(); i++) 
        {
			System.out.println("Inside the i loop");
			String s1=a.get(i);
			for (int j=0; j<b.size(); j++)
			{
				System.out.println("Inside the j loop");
				String s2=b.get(j);
				System.out.println(s1+":"+s2);
				if(s1.equalsIgnoreCase(s2))
				{
					System.out.println("string matching");
					f = f+1;
					System.out.println(f);
					break;
				}
        	}
                  
        }
        return f;
    }
	
	public String deploy(WebDriver driver, String fleetname) throws Exception 
	{   
		String acop ="";
		int n = 0;
		ArrayList<String> a1 = new ArrayList<String>();
	    ArrayList<String> a2 = new ArrayList<String>();
	    Thread.sleep(5000);
	    if(isElementPresentcheck(By.xpath(".//*[@id='menuBtn16']"), driver))
	    {
	    	driver.findElement(By.xpath(".//*[@id='menuBtn16']")).click();
	    }
	    do
		{
			Thread.sleep(2000);
		}while(isElementPresent(By.xpath(".//*[@id='OverlayParent']"),driver));
	    search(driver,fleetname);
	    do
		{
			Thread.sleep(2000);
		}while(isElementPresent(By.xpath(".//*[@id='OverlayParent']"),driver));
	    
	    checkOverlaps(driver);
	    
		driver.findElement(By.xpath(".//*[@id='menuBtn13']")).click(); //Clicking on the deploy button...
		do
		{
			Thread.sleep(2000);
		}while(isElementPresent(By.xpath(".//*[@id='OverlayParent']"),driver));
		if(isAlertPresent(driver))
		{
			Alert alert = driver.switchTo().alert();
			System.out.println("Deploy : "+alert.getText());
			acop = alert.getText();
			alert.accept();
		}
		do
		{
			Thread.sleep(2000);
		}while(isElementPresent(By.xpath(".//*[@id='OverlayParent']"),driver));
		if(isElementPresentcheck(By.xpath(".//*[@id='divDeployGeo']/div"), driver))
		{
			while(isElementPresent(By.xpath(".//*[@id='OverlayParent']"),driver));
			{
				System.out.println("Overlay");
				Thread.sleep(2000);
			}
			acop = driver.findElement(By.xpath(".//*[@id='deployErrorMsg']")).getText();
			driver.findElement(By.xpath(".//*[@id='btnDeployGeofence']/a/input")).click();
			int a = driver.findElements(By.xpath(".//*[@id='fillDeploy']/tr")).size();
			System.out.println("a : "+a);
			a1= sqlcon.main(fleetname,a);
			a2 = testUnixDir.main();
			n=compare(a1, a2);
			if(n == 3)
			{
				System.out.println("File compared successfully");
			}
			else
			{
				System.out.println("File comparision failed...");
			}
			
		}
		return acop;
	}
	
	public String checkOverlaps(WebDriver driver)
	{
		String acop="Null";
		try
		{
			
			List<WebElement> w = driver.findElements(By.xpath(".//*[@id='menuBtn15']"));
			System.out.println(w.get(0).getText());
			System.out.println(w.get(1).getText());
			w.get(1).click();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			
			Thread.sleep(2000);
			if(isAlertPresent(driver))
			{
				Alert alert = driver.switchTo().alert();
				System.out.println("Check overlaps : "+alert.getText());
				Thread.sleep(2000);
				if(alert.getText().startsWith("Are you sure you want to check overlaps for the"))
				{
					alert.accept();
					Thread.sleep(2000);
					if(isAlertPresent(driver))
					{
						driver.switchTo().alert().accept();
					}
					else
					{
						Thread.sleep(2000);
						
						deleteOverlap(driver);
						
						System.out.println("Check overlaps : Deletion done...");
					}
				}
				else
				{
					System.out.println("Check overlaps : "+driver.switchTo().alert().getText());
					alert.accept();
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			return acop;
		}
	}
	
	public void deleteOverlap(WebDriver driver)
	{
		try
		{
			Robot rt = new Robot();
			int naveen=800,kannan=400;
			rt.mouseMove(naveen,kannan);
			WebElement w = driver.findElement(By.xpath(".//*[@id='mapOverlap']/div/div[1]/div[3]"));
			System.out.println(w.getLocation());
			int flag=0;
			for(int i=0;true;i++)
			{
				System.out.println("Flag : "+flag);
				if(flag==0)
				{
					flag=1;
				}
				else if(flag==1)
				{
					rt.mouseMove(naveen+20, kannan+20);
					flag=-1;
				}
				else if(flag==-1)
				{
					rt.mouseMove(naveen-20, kannan+20);
					flag=-2;
				}
				else if(flag==-2)
				{
					rt.mouseMove(naveen+20, kannan-20);
					flag=2;
				}
				else if(flag==2)
				{
					rt.mouseMove(naveen-20, kannan-20);
					flag=1;
				}
				else
				{
					Thread.sleep(2000);
					if(isAlertPresent(driver))
					{
						System.out.println(driver.switchTo().alert().getText());
						driver.switchTo().alert().accept();
					}
					System.out.println("Breaking");
					break;
				}
				
				for(int j=0;true;j++)
				{	
					rt.delay(1000);
					rt.delay(1000);
					rt.delay(1000);
					rt.mousePress(InputEvent.BUTTON1_MASK);
					rt.delay(1000);
					rt.mouseRelease(InputEvent.BUTTON1_MASK);
					
					driver.findElement(By.xpath(".//*[@id='btn_overlap_delete']")).click();
					Thread.sleep(2000);
					if(isAlertPresent(driver))
					{
						Alert alert1 = driver.switchTo().alert();
						System.out.println(alert1.getText());
						if(alert1.getText().contains("Are you sure you want to Delete"))
						{
							System.out.println(alert1.getText()+" : Deleting...");
							flag=3;
							alert1.accept();
							Thread.sleep(2000);
							if(isAlertPresent(driver))
							{
								System.out.println(driver.switchTo().alert());
								driver.switchTo().alert().accept();
								break;
							}
						}
						else
						{
							alert1.dismiss();
							break;
						}
					}
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	 /* To write Pass to the output file */
	public void writePass(String tc, int counter)
	{
		try
		{
			FileInputStream fsIP= new FileInputStream(new File("\\\\amxserver\\amx-share\\STW_QA\\rFence Automation\\input.xls")); //Read the spreadsheet that needs to be updated my file
    		HSSFWorkbook wb = new HSSFWorkbook(fsIP); //Access the workbook
    		HSSFSheet worksheet = wb.getSheetAt(0); //Access the worksheet, so that we can update / modify it.
    		Cell cell = null; // declare a Cell object
    		int rownum=0;
    		System.out.println(worksheet.getLastRowNum());
    		for(int c=1;c<worksheet.getLastRowNum();c++)
    		{
    			System.out.println("tc "+tc);
    			Cell cell1 = worksheet.getRow(c).getCell(0);
    			System.out.println(cell1.getStringCellValue());
    			if(tc.equalsIgnoreCase(cell1.getStringCellValue()))
    			{
    				rownum=cell1.getRowIndex();
    				break;
    			}
    		}
    		System.out.println("rownumber = "+rownum);
    		cell = worksheet.getRow(rownum).getCell(6);   // Access the second cell in second row to update the value
    		if(!cell.getStringCellValue().equalsIgnoreCase("Fail"))
    			cell.setCellValue("Pass");  // Get current cell value value and overwrite the value
    		fsIP.close(); //Close the InputStream
    		Thread.sleep(2000);
    		System.out.println("Closed input stream");
    		FileOutputStream output_file =new FileOutputStream(new File("\\\\amxserver\\amx-share\\STW_QA\\rFence Automation\\input.xls"));  //Open FileOutputStream to write updates
    		wb.write(output_file); //write changes
    		output_file.close();  //close the stream
    		counter++;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/* To write Fail to the output file */
	public void writeFail(String tc, int counter)
	{
		try
		{
			FileInputStream fsIP= new FileInputStream(new File("\\\\amxserver\\amx-share\\STW_QA\\rFence Automation\\input.xls")); //Read the spreadsheet that needs to be updated my file
    		HSSFWorkbook wb = new HSSFWorkbook(fsIP); //Access the workbook
    		HSSFSheet worksheet = wb.getSheetAt(0); //Access the worksheet, so that we can update / modify it.
    		Cell cell = null; // declare a Cell object
    		int rownum=0;
    		System.out.println(worksheet.getLastRowNum());
    		for(int c=1;c<worksheet.getLastRowNum();c++)
    		{
    			System.out.println("tc "+tc);
    			Cell cell1 = worksheet.getRow(c).getCell(0);
    			System.out.println(cell1.getStringCellValue());
    			if(tc.equalsIgnoreCase(cell1.getStringCellValue()))
    			{
    				rownum=cell1.getRowIndex();
    				break;
    			}
    			//System.out.println("rownumber = "+rownum);
    		}
    		System.out.println("rownumber = "+rownum);
    		cell = worksheet.getRow(rownum).getCell(6);   // Access the second cell in second row to update the value
    		cell.setCellValue("Fail");  // Get current cell value value and overwrite the value
    		fsIP.close(); //Close the InputStream
    		Thread.sleep(2000);
    		System.out.println("Closed input stream");
    		FileOutputStream output_file =new FileOutputStream(new File("\\\\amxserver\\amx-share\\STW_QA\\rFence Automation\\input.xls"));  //Open FileOutputStream to write updates
    		wb.write(output_file); //write changes
    		output_file.close();  //close the stream
    		counter++;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	
	}
}