package nopcommerce.Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {

	private static FileInputStream file;
	private static Properties prop;
	
	public static Properties readConfig() {
	
		try {
			file = new FileInputStream(System.getProperty("user.dir")+
					"\\Configuration\\config.properties");
			prop = new Properties();
			prop.load(file);
			return prop;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
}
