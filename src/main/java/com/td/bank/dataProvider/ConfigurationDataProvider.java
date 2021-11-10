package com.td.bank.dataProvider;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/*
 * This class reads the data from config.properties
 */
public class ConfigurationDataProvider {
	Properties propertyFile;
	String fileName;

	public ConfigurationDataProvider(String propertyFilePath) throws IOException {
		this.fileName = propertyFilePath;
		BufferedReader reader = new BufferedReader(new FileReader(fileName));
		propertyFile = new Properties();
		propertyFile.load(reader);
		reader.close();
	}

	public String getBaseURL() {
		return propertyFile.getProperty("baseURL");
	}

	public String getWaitTime() {

		return propertyFile.getProperty("WaitTime");
	}

	
}
