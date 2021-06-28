package com.testvagrant.fileReader;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLFileReader {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static String readXMLReader(String propertyName, String xmlfilename) {
		String propertyValue = null;
		String file = null;
		try {
			file = FilePathReader.getFilePath(xmlfilename);
			File inputFile = new File(file);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(inputFile);
			doc.getDocumentElement().normalize();
			NodeList nList = doc.getElementsByTagName("Element");
			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) nNode;
					String elementLocation = element.getAttribute("name");
					if (elementLocation.equalsIgnoreCase(propertyName)) {
						propertyValue = element.getElementsByTagName("xpath").item(0).getTextContent();
						break;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return propertyValue;
		}
	}
}
