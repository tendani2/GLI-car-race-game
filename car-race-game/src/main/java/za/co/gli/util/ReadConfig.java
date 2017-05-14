package za.co.gli.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadConfig {
	/**
	 * 
	 * @return
	 * @throws IOException
	 */
	public static Properties getPropValues(String fileName) throws IOException {
		Properties prop = new Properties();
		String propFileName = fileName;
		InputStream inputStream = null;
		
		try {
			inputStream = ReadConfig.class.getClassLoader().getResourceAsStream(propFileName);
 
			if (inputStream != null) {
				prop.load(inputStream);
			} else {
				throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
			}
 
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		} finally {
			inputStream.close();
		}
		return prop;
	}
	
}
