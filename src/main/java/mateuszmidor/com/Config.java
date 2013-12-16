package mateuszmidor.com;

/* Klasa udostêpniaj¹ca dane z pliku konfiguracji */

import java.io.FileInputStream;
import java.util.Properties;


public class Config {
	private final static String CONFIG_FILE_NAME = "config.xml";
	static private Properties properties = loadProperties();
	
	// wczytuje plik konfiguracyjny do pamiêci
	static private Properties loadProperties()
	{
		Properties properties = new Properties();
		try {
			FileInputStream fis = new FileInputStream(CONFIG_FILE_NAME);
			properties.loadFromXML(fis);
		}
		catch (Exception e) {
			MessageDialog.showException("B³¹d podczas ³adowania pliku ustawieñ", e);
		}
		
		return properties;
	}
	
	// zwraca wartoœæ zadanego parametru z konfiguracji
	static public String valueOf(String parameter_name)
	{
		return properties.getProperty(parameter_name);		
	}
}
