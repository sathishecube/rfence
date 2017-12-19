package rFence;

import java.util.ArrayList;
import java.util.Vector;

import org.apache.commons.net.ftp.FTPClient;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
//import com.jcraft.jsch.Session;



public class testUnixDir {

	public static ArrayList<String> main() 
	{
		FTPClient ftp;
		
		JSch jsch = new JSch();
	    Session session = null;
	    Channel channel = null;

	    // Variable Declaration.
	    String user = "ftpuser";
	    String host = "192.168.1.107";
	    Integer port = 22;
	    String password = "ftpuser";
	    String path = "//home//ftpuser//GF_TESTING_TEAM";
	    ArrayList<String> fName = new ArrayList<String>();
	   
	   try 
	   {
	        session = jsch.getSession(user, host, port);

	        java.util.Properties config = new java.util.Properties(); 
	        config.put("StrictHostKeyChecking", "no");
	        session.setConfig(config);
	        session.setPassword(password);

	        session.connect();

	        channel = session.openChannel("sftp");
	        channel.connect();
	        ChannelSftp sftpChannel = (ChannelSftp)channel;
	        
	        System.out.println("connected...");
	        System.out.println(sftpChannel.pwd());
	        
	        sftpChannel.cd(path);
	        System.out.println(sftpChannel.pwd());
	        
	        Vector ls = sftpChannel.ls(path);
	        System.out.println(ls.size());
	        
	        
	        for(int i=0;i<ls.size();i++)
	        {
	        	//System.out.println(ls.get(i));
	        	//System.out.println(ls.get(i).toString());
	        	//fName.add(ls.get(i).toString());
	        	String temp=ls.get(i).toString();
	        	temp=temp.substring(56);
	        	System.out.println(temp);
	        	fName.add(temp);
	        	
	        }
	        
	   }
	   catch(Exception e)
	   {
		   e.printStackTrace();
	   }
	   return fName;
	}

}
