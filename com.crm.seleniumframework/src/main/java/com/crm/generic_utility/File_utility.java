package com.crm.generic_utility;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * this method is used to launch the application
 * @author Pradeepkumar C
 *
 */
public class File_utility {
	public String getpropertyKeyValue(String Key) throws Throwable {
		//FileInputStream fis= new FileInputStream("./commomdata.property.txt");
		FileInputStream fis= new FileInputStream(ipathConstant.PROPERTY_PATH);
		Properties pro =new Properties();
		pro.load(fis);
		String value = pro.getProperty(Key);

		return value;


		


	}

}
