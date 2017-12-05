package com.weather;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.DesiredCapabilities;

public class testClass {
	
	
	static FileReader reader;
	static Properties prop;
	static DesiredCapabilities caps = new DesiredCapabilities();
	
	public static void loadConfig() {

		try {
			reader = new FileReader("D:\\Twc-Android-Automation\\AndroidApp-master\\config.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		prop = new Properties();
		try {
			prop.load(reader);
			// prop.getProperty("capability.app");

		} catch (IOException e) {
			// TODO Aut o-generated catch block
			e.printStackTrace();
		}

	}
	
	
	public static Capabilities reaCap() {
		
		Set set= prop.entrySet();
		
		Iterator itr=set.iterator();  
		
		while(itr.hasNext()){  
			Map.Entry entry=(Map.Entry)itr.next();  
			caps.setCapability((String) entry.getKey(), entry.getValue());
		
		}
		return caps;
	}
	
	public static void main(String[] args) {
		loadConfig();
		reaCap();
	}

}
