package com.actitime.generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class GenericLib {
	
	public static String getValue(String key)
{
		
  String value = null;
  Properties prop = new Properties();
  
  try {
	prop.load(new FileInputStream(new File("C:/Users/PRASHANT/workspace/Actitime/config.properties")));
} catch (FileNotFoundException e) {
	e.printStackTrace();
} catch (IOException e) {
	e.printStackTrace();
}
  
  value=prop.getProperty(key);
	return value;	
		
		
		
}

}
