package io.nology.employeecreator;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class EnvLoader {
	public static void load() {
		try {
			Properties properties = new Properties();
			FileInputStream inputStream = new FileInputStream(".env");
			properties.load(inputStream);
			inputStream.close();
			
			for (String key: properties.stringPropertyNames()) {
				String value = properties.getProperty(key);
				System.setProperty(key, value);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
