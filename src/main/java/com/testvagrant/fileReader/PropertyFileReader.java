package com.testvagrant.fileReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class PropertyFileReader {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getPropValue("NDTVWebsiteReader.properties","city"));
	}
	
	public static String getPropValue(String propFileName,String propName) {
		String propValue = null;
		try {
		String propFilePath = FilePathReader.getFilePath(propFileName);
		InputStream input = new FileInputStream(propFilePath);
		Properties property = new Properties();
		property.load(input);
		propValue = property.getProperty(propName);
		}catch(Exception e) {}
		return propValue;
	}

}