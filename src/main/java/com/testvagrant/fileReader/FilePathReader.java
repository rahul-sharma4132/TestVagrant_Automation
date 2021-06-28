package com.testvagrant.fileReader;

import java.io.File;

public class FilePathReader {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static String getFilePath(String fileName) {
		String propFilePath = null;
		try {
			File propFile = new File(".");
			if (fileName.contains("properties"))
				propFilePath = propFile + "//src//main//resources//" + fileName;
			if (fileName.contains("xml"))
				propFilePath = propFile + "//src//test//resources//" + fileName;
		} catch (Exception e) {
		}
		return propFilePath;
	}

}
