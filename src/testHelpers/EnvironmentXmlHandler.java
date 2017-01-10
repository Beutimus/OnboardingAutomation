package testHelpers;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class EnvironmentXmlHandler {
	
	private static EnvironmentXmlHandler instance = new EnvironmentXmlHandler();
	private static final String settingFilePath = ".\\Settings\\settings.xml";
	private static final String xmlFilePath = ".\\Settings\\environments.xml";
	private static String environmentURL;
	private static String databaseURL;
	private static String databaseLogin;
	
	private EnvironmentXmlHandler()
	{
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db;
		try {
			db = dbf.newDocumentBuilder();

			Document setting = db.parse(new File(settingFilePath));
			Document environment = db.parse(new File(xmlFilePath));
			
			NodeList mainNode = setting.getElementsByTagName("CurrentEnvironment");
			
			String environmentSetting = mainNode.item(0).getTextContent();
			
			NodeList environmentNames = environment.getElementsByTagName("Name");
			NodeList environmentURLs = environment.getElementsByTagName("URL");
			NodeList environmentDBURLs = environment.getElementsByTagName("DBURL");
			NodeList environmentDBLogin = environment.getElementsByTagName("DBLogin");
			
			System.out.println(environmentNames.getLength());
			
			for (int i = 0; i < environmentNames.getLength(); i++)
			{
				String name = environmentNames.item(i).getTextContent();
				
				System.out.println("Env Name: " + name);
				
				if (name.toLowerCase().equals(environmentSetting.toLowerCase()))
				{
					System.out.println("Match");
					environmentURL = environmentURLs.item(i).getTextContent();
					databaseURL = environmentDBURLs.item(i).getTextContent();
					databaseLogin = environmentDBLogin.item(i).getTextContent();
				}
			}
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
		return environmentURL;
	}

	public static String databaseURL()
	{
		return databaseURL;
	}
	
	public static  String databaseUserName()
	{
		String login = databaseLogin.substring(0, databaseLogin.indexOf('|'));
		
		return login;
	}
	
	public static String databasePassword()
	{
		String login = databaseLogin.substring(databaseLogin.indexOf('|') + 1);
		
		return login;
	}
}
