package testHelpers;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class EnvironmentXmlHandler {
	
	private static EnvironmentXmlHandler instance = new EnvironmentXmlHandler();
	private static String settingFilePath = "./Settings/settings.xml";
	private static String xmlFilePath = "./../environments.xml";
	
	private EnvironmentXmlHandler()
	{
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db;
		try {
			db = dbf.newDocumentBuilder();
			
			File file = new File(settingFilePath);
			
			System.out.println(file);

			Document doc = db.parse(new File(settingFilePath));


			File settingFile = new File(settingFilePath);
			File xmlFile = new File(xmlFilePath);

			System.out.println("" + settingFile.getAbsolutePath());
			System.out.println("" + xmlFile.getAbsolutePath());
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	public static String getEnvironmentBaseURL()
	{
		// TODO Implement this
		return null;
	}

}
